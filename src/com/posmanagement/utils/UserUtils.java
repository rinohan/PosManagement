package com.posmanagement.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class UserUtils {

    public boolean isAdmin(String UID){
        ArrayList<HashMap<String, Object>> dbRet = null;
        try {
            dbRet = PosDbManager.executeSql("select 1 from userinfo where   rid ='e664d6f3-85f8-4bd6-bcb8-c4e053732b29' and  uid='"+UID+"'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (dbRet.size() > 0);
    }
}
