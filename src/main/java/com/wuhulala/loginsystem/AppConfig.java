package com.wuhulala.loginsystem;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.wuhulala.loginsystem.interceptor.DuplicateSubmissionInterceptor;
import com.wuhulala.loginsystem.interceptor.ExecuteTimeHandlerInterceptor;
import com.wuhulala.loginsystem.interceptor.NeedLoginAdminInterceptor;
import com.wuhulala.loginsystem.interceptor.NeedLoginUserInterceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.io.IOException;
import java.util.List;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2016/11/25
 */
@EnableWebMvc
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan("com.wuhulala.loginsystem")
@MapperScan("com.wuhulala.loginsystem.dal.mapper")
@PropertySource("classpath:/config.properties")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private Environment env;

    @Bean
    public ExecuteTimeHandlerInterceptor executeTimeHandlerInterceptor(){
        return new ExecuteTimeHandlerInterceptor();
    }
    @Bean
    public DuplicateSubmissionInterceptor duplicateSubmissionInterceptor(){
        return new DuplicateSubmissionInterceptor();
    }
    @Bean
    public NeedLoginAdminInterceptor needLoginAdminInterceptor(){
        return new NeedLoginAdminInterceptor();
    }
    @Bean
    public NeedLoginUserInterceptor needLoginUserInterceptor(){
        return new NeedLoginUserInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(executeTimeHandlerInterceptor());
        registry.addInterceptor(needLoginUserInterceptor());
        registry.addInterceptor(needLoginAdminInterceptor());
        registry.addInterceptor(duplicateSubmissionInterceptor());
    }

    /**
     * 设置fastjson转换json
     * @param converters 转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //新建一个转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue
        );
        ValueFilter valueFilter = new ValueFilter() {
            public Object process(Object o, String s, Object o1) {
                if (null == o1){
                    o1 = "";
                }
                return o1;
            }
        };
        fastJsonConfig.setSerializeFilters(valueFilter);

        converter.setFastJsonConfig(fastJsonConfig);
        //添加转换器
        converters.add(converter);
    }

    /**
     * 静态资源映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
    }

    //配置页面
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
     * 添加dataSource
     */
    @Bean(name = "dataSource")
    public DruidDataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(env.getProperty("jdbc.username"));
        druidDataSource.setPassword(env.getProperty("jdbc.password"));
        druidDataSource.setUrl(env.getProperty("jdbc.url"));
        druidDataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        druidDataSource.setInitialSize(10);
        druidDataSource.setMaxActive(50);
        druidDataSource.setMinIdle(10);
        druidDataSource.setMaxWait(10000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);

        return druidDataSource;
    }

    /**
     * 配置事务管理器
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    /**
     * 配置mybatis的sqlSessionFactory
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(){
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(env.getProperty("mybatis.ConfigLocation")));
        sqlSessionFactoryBean.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
        try {
            sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources(env.getProperty("mybatis.mapperLocations")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactoryBean;
    }

    @Bean
    public TransactionTemplate transactionTemplate(){
        TransactionTemplate template = new TransactionTemplate();
        template.setTransactionManager(transactionManager());
        return template;
    }

    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1024*1024*50);
        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }

/*    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        RedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
        return redisConnectionFactory;
    }

    *//**
     * Redis Json-Serializer
     *//*
    @Bean
    public RedisTemplate<String,Object>redisTemplate(){
        RedisTemplate<String,Object>template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());

        template.setValueSerializer(new FastJsonRedisSerializer<>(Object.class));
        template.setKeySerializer(new StringRedisSerializer());

        template.afterPropertiesSet();
        return template;
    }

    *//**
     * Redis OpsValues
     *//*
    @Bean
    public ValueOperations<String,Object> valueOperations(RedisTemplate<String,Object> redisTemplate){
        return redisTemplate.opsForValue();
    }*/

}
