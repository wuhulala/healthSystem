package com.wuhulala.loginsystem.dal.provider;

import java.util.List;
import java.util.Map;

/**
 * @author xueaohui
 */
public class ComboProjectProvider {
    private static final String TABLE = "tb_combo_project";

    public String insertList(Map<String, Object> parameters) {
        List<Integer> ids = (List<Integer>) parameters.get("projectIds");
        int comboId = (int) parameters.get("comboId");
        if (ids != null && ids.size() > 0) {
            StringBuffer sb =new StringBuffer("insert into ").append(TABLE).append("(combo_id,project_id) values ");

            for (int i=0; i<ids.size(); i++) {
                sb.append("("+comboId+","+ids.get(i)+")");
                if (i < ids.size() - 1) {
                    sb.append(",");
                }
            }

            return sb.toString();
        }
        return null;
    }

}
