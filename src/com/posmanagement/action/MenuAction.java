package com.posmanagement.action;

public class MenuAction {
    private final static String SALEMANAGE = "saleManager";
    private final static String TELLERMANAGE = "tellerManager";
    private final static String BANKMANAGER = "bankManager";
    private final static String CARDTIMEMANAGER = "cardTimeManager";
    private final static String ASSETSMANAGER = "assetsManager";
    private final static String INDUSTRYMANAGER = "industryManager";
    private final static String RATESMANAGER = "ratesManager";

    public String ManageSaleMan() {
        return SALEMANAGE;
    }

    public String ManageTeller() {
         return TELLERMANAGE;
    }

    public String ManageBank() {
        return BANKMANAGER;
    }

    public String ManageCardTime()  {
        return CARDTIMEMANAGER;
    }

    public String ManageAssets() {
        return ASSETSMANAGER;
    }

    public String ManageIndustry() {
        return INDUSTRYMANAGER;
    }

    public String ManageRates() {
        return RATESMANAGER;
    }
}