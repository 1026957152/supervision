package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum PaymentUnitTypeEnum_单位性质 {


    国家机关 ("a", "国家机关",1,""),
    全额拨款事业单位 ("b", "全额拨款事业单位",2,""),

    差额拨款事业单位 ("c", "差额拨款事业单位",1,""),
    自收自支事业单位 ("d", "自收自支事业单位",2,""),
    参公管理事业单位 ("e", "参公管理事业单位",1,""),
    企业管理事业单位 ("g", "企业管理事业单位",2,""),



    民办非企业单位 ("h", "民办非企业单位",1,""),
    国有企业 ("i", "国有企业",2,""),



    民营企业 ("j", "民营企业",1,""),
    外资企业 ("k", "外资企业",2,""),
    股份有限公司 ("l", "股份有限公司",1,""),
    城镇集体企业 ("m", "城镇集体企业",2,""),

    城镇私营企业 ("n", "城镇私营企业",2,""),
    其他 ("z", "其他",1,""),
    军队 ("o", "军队",2,""),

;



    public static PaymentUnitTypeEnum_单位性质_建行 from(String text) {



        PaymentUnitTypeEnum_单位性质 typeEnum = PaymentUnitTypeEnum_单位性质.fromString(text);
        switch (typeEnum){
            case 国家机关:
            case 差额拨款事业单位:
            case 全额拨款事业单位:
            case 自收自支事业单位:
            case 参公管理事业单位:
            case 企业管理事业单位:
                return PaymentUnitTypeEnum_单位性质_建行.国家机关;

            case 民办非企业单位:
                return PaymentUnitTypeEnum_单位性质_建行.民办非企业单位_社会团体;

            case 国有企业:
                return PaymentUnitTypeEnum_单位性质_建行.国有企业;

            case 城镇集体企业:
                return PaymentUnitTypeEnum_单位性质_建行.城镇集体企业;

            case 外资企业:
                return PaymentUnitTypeEnum_单位性质_建行.外资企业;
            case 城镇私营企业:
                return PaymentUnitTypeEnum_单位性质_建行.城镇私营企业及其他城镇企业;

            default:
                return PaymentUnitTypeEnum_单位性质_建行.其他;

        }


    }

    private final String statusText;
    private final String displayText;
    private final Integer id;

    private String helpMessage;

    public String getHelpMessage() {
        return helpMessage;
    }

    public void setHelpMessage(String helpMessage) {
        this.helpMessage = helpMessage;
    }

    public String getDisplayText() {
        return displayText;
    }

    private PaymentUnitTypeEnum_单位性质(String statusText, String displayText, Integer id, String helpMessage) {
        this.statusText = statusText;
        this.displayText = displayText;

        this.id = id;
        this.helpMessage = helpMessage;
    }
    public String getText() {
        return this.statusText;
    }

    public Integer getId() {
        return this.id;
    }

/*
    public static List<ListItem> retriveTypese() {

        List<ListItem> list = new ArrayList<ListItem>();
        for (AccountingVoucherStatusEnum status : AccountingVoucherStatusEnum.values()) {
            ListItem element = new ListItem(status.getId(), status.getDisplayText(), status.getHelpMessage());
            list.add(element);
        }

        return list;

    }


    public static List<ListItem> retriveTypese(String statusText) {

        List<ListItem> list = new ArrayList<ListItem>();
        for(PersonalAccountStatusEnum status : PersonalAccountStatusEnum.values()) {
            ListItem element = new ListItem(status.getText(), status.getDisplayText());
            if (status.getText().equals(statusText)){
                element.setSelected(true);
            }
            list.add(element);
        }
        return list;

    }*/



    public static PaymentUnitTypeEnum_单位性质 fromString(String text) {
        for (PaymentUnitTypeEnum_单位性质 status : PaymentUnitTypeEnum_单位性质.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static PaymentUnitTypeEnum_单位性质 fromInt(Integer text) {
        for (PaymentUnitTypeEnum_单位性质 status : PaymentUnitTypeEnum_单位性质.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
