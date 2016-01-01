package com.posmanagement.webui;

import com.posmanagement.utils.PosDbManager;

import java.util.ArrayList;
import java.util.HashMap;

public class CardUI {
    public String generateCardTable() throws Exception {
        ArrayList<HashMap<String, Object>> dbRet = fetchCardList();
        if (dbRet.size() <= 0)
            return new String("");

        String htmlString = "";
        for (int index = 0; index < dbRet.size(); ++index) {
            htmlString += new UIContainer("tr")
                    .addAttribute("class", "text-c odd")
                    .addAttribute("role", "row")
                    .addElement(new UIContainer("td")
                        .addElement(
                            new UIContainer("input")
                                    .addAttribute("type", "radio")
                                    .addAttribute("name", "newid")
                                    .addAttribute("value", dbRet.get(index).get("CARDNO").toString())
                                    .addAttribute("checked", "checked",false)
                        ))
                    .addElement("td", dbRet.get(index).get("CARDNO").toString())
                    .addElement("td", dbRet.get(index).get("CARDMASTER").toString())
                    .addElement("td", dbRet.get(index).get("CMTEL").toString())
                    .addElement("td", dbRet.get(index).get("BILLDATE").toString())
                    .addElement("td", dbRet.get(index).get("SALESMAN").toString());
        }
        return htmlString;
    }

    public String generateMasterString(String cardno) throws Exception {
        ArrayList<HashMap<String, Object>> dbRet =  PosDbManager.executeSql("select cardmaster from cardtb where cardno='"+cardno+"'");
        if (dbRet.size() > 0)
            return dbRet.get(0).get("CARDMASTER").toString();
        else
            return "Not exists this Card!";
    }

    private ArrayList<HashMap<String, Object>> fetchCardList() throws Exception {
        return PosDbManager.executeSql("select cardtb.uuid, cardno,cardmaster,cmtel,billdate,userinfo.unick salesman " +
                "from cardtb inner join banktb " +
                "on cardtb.bankuuid=banktb.uuid inner join userinfo on userinfo.uid=cardtb.salesmanuuid");
    }
}