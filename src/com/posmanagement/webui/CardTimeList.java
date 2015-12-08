package com.posmanagement.webui;

import com.posmanagement.utils.DbManager;

import java.util.ArrayList;
import java.util.HashMap;

public class CardTimeList {
    public String generateHTMLString() throws Exception {
        return generateCardTimeList();
    }

    private String generateCardTimeList() throws Exception {
        ArrayList<HashMap<String, Object>> dbRet = fetchCardTimeList();
        if (dbRet.size() <= 0)
            return new String("");

        String htmlString = "";
        for (int index = 0; index < dbRet.size(); ++index) {
            htmlString +="<tr class=\"text-c odd\" role=\"row\">"+
                    "<td>"+ dbRet.get(index).get("CARDTIME")+"</td>"+
                    "<td><input type=\"checkbox\"";
            if (dbRet.get(index).get("ENABLED").toString().compareTo("on") == 0) {
                htmlString += "checked=\"checked\"";
            }
            htmlString += " /></td></tr>";
        }
        return htmlString;
    }

    private ArrayList<HashMap<String, Object>> fetchCardTimeList() throws Exception {
        return DbManager.createPosDbManager().executeSql("select * from cardtimetb");
    }
}