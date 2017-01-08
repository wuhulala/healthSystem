package com.wuhulala.loginsystem.dal.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xueaohui
 * @version 1.0
 * @date 2016-08-02
 */
public class CommonProvider {

    private final static Logger log = LoggerFactory.getLogger(CommonProvider.class);

    /**
     * 自定义查询列表
     */
    public String queryList(Map<String, Object> params) {
        int limit = (Integer) params.get("limit");
        int offset = (Integer) params.get("offset");

        StringBuffer sb = new StringBuffer(createQuerySQL(params));
        sb.append(" limit " + offset + " , " + limit);

        return sb.toString();
    }

    /**
     * 自定义查询列表长度
     */
    public String queryListSize(Map<String, Object> params) {
        String sql = createQuerySQL(params);
        String result = sql.replaceAll("\\*","count(*)");
        return result;
    }


    /**
     * 生成一部分
     * @param params
     * @return
     */
    private String createQuerySQL(Map<String, Object> params){
        final String tableName = (String) params.get("tableName");

        Object object = params.get("object");
        StringBuffer sb = new StringBuffer("select * from ")
                .append(tableName);

        Field[] fields = object.getClass().getDeclaredFields();
        Map<String, Object> map = new HashMap();

        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].setAccessible(true);
                String fieldName = fields[i].getName();
                Object fieldValue = fields[i].get(object);
                if (fieldValue != null) {
                    map.put(fieldName, fieldValue);
                }
            } catch (IllegalAccessException e) {
                log.error("不合法 访问不到属性---" + fields[i].getName());
            }
        }
        int count = 0 ;
        if(map.size()>0){
            sb.append(" where ");
        }
        for (Map.Entry<String, Object> beanEntry : map.entrySet()) {
            String fieldName = beanEntry.getKey();
            Object fieldValue = beanEntry.getValue();
            sb.append(fieldName +" = \""+fieldValue.toString()+"\"");
            if(++count !=  map.size()){
                sb.append(" AND ");
            }
        }
        return sb.toString();
    }
}
