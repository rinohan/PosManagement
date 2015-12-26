package com.posmanagement.webui;

import com.posmanagement.utils.PosDbManager;
import com.posmanagement.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class BillList {
    public String generateHTMLString() throws Exception {
        ArrayList<HashMap<String, Object>> dbRet = fetchBillList();
        if (dbRet.size() <= 0)
            return new String("");

        String htmlString = "";
        for (int index = 0; index < dbRet.size(); ++index) {
            htmlString += new UIContainer("tr")
                    .addAttribute("class", "text-c odd")
                    .addAttribute("role", "row")
                    .addElement("td", StringUtils.convertNullableString(dbRet.get(index).get("BANKCODE")))
                    .addElement("td", StringUtils.convertNullableString(dbRet.get(index).get("CARDNO")))
                    .addElement("td", StringUtils.convertNullableString(dbRet.get(index).get("BILLDATE")))
                    .addElement("td", StringUtils.convertNullableString(dbRet.get(index).get("LASTREPAYMENTDATE")))
                    .addElement(new UIContainer("td")//StringUtils.convertNullableString(dbRet.get(index).get("BILLAMOUNT")).equals("")?"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp":""
                            .addElement(new UIContainer("label",StringUtils.convertNullableString(dbRet.get(index).get("BILLAMOUNT")).equals("")?"0":dbRet.get(index).get("BILLAMOUNT").toString())
                            .addAttribute("name","billamount")
                            .addAttribute("title",StringUtils.convertNullableString(dbRet.get(index).get("CARDNO")))
                            .addAttribute("style","display:inline-block;width:30")))
                   // .addElement("td", StringUtils.convertNullableString(dbRet.get(index).get("BILLAMOUNT")))
                    .addElement("td", StringUtils.convertNullableString(dbRet.get(index).get("CANUSEAMOUNT")))
                    .addElement("td", StringUtils.convertNullableString(dbRet.get(index).get("BILLHADPAY")))
                    .addElement("td", StringUtils.convertNullableString(dbRet.get(index).get("BILLNOPAY")))
                    .addElement("td", StringUtils.convertNullableString(dbRet.get(index).get("LASTPAY")))
                    .addElement("td", StringUtils.convertNullableString(dbRet.get(index).get("LASTPAYDATETM")))
                    .addElement("td", StringUtils.convertNullableString(dbRet.get(index).get("LASTTELLER")))
                    .addElement("td", StringUtils.convertNullableString(dbRet.get(index).get("SALESMAN")))
                    .addElement("td", StringUtils.convertNullableString(dbRet.get(index).get("EXPIRED")))
                    .addElement(new UIContainer("td").addElement(new UIContainer("input")
                        .addAttribute("class", dbRet.get(index).get("STATUS").equals("enable")?"label label-success radius":"btn btn-danger radius")
                        .addAttribute("type","button")
                                    .addAttribute("title", dbRet.get(index).get("STATUS").equals("enable")?"已开启":"未开启")
                                    .addAttribute("value", dbRet.get(index).get("STATUS").equals("enable")?"Y":"N")));
        }
        return htmlString;
    }

    private ArrayList<HashMap<String, Object>> fetchBillList() throws Exception {
        return PosDbManager.executeSql("select * from billtb");
    }
}