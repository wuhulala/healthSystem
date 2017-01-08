package com.wuhulala.loginsystem.dal.provider;

import java.util.List;
import java.util.Map;

/**
 * @author xueaohui
 */
public class ProjectProvider {
    private static final String TABLE = "tb_project";

    public String getProjectInIdList(Map<String, Object> parameters) {
        List<Integer> ids = (List<Integer>) parameters.get("ids");
        if (ids != null && ids.size() > 0) {
            StringBuffer sb = new StringBuffer("select * from ")
                    .append(TABLE)
                    .append(" where id in (")
                    .append(ids.toString().replace("[","").replace("]",""))
                    .append(")");
            return sb.toString();
        }
        return "select * from "+TABLE;
    }

    public String getProjectNotInIdList(Map<String, Object> parameters) {
        List<Integer> ids = (List<Integer>) parameters.get("ids");
        if (ids != null && ids.size() > 0) {
            StringBuffer sb = new StringBuffer("select * from ")
                    .append(TABLE)
                    .append(" where id not in (")
                    .append(ids.toString().replace("[","").replace("]",""))
                    .append(")");
            return sb.toString();
        }
        return "select * from "+TABLE;
    }
}
