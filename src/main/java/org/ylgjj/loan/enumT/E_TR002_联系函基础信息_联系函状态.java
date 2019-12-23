package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_TR002_联系函基础信息_联系函状态 {


    E_00_正常状态 ("00", "正常状态",0,""),
    E_01_联系函复核通过 ("01", "联系函复核通过",1,""),

    E_08_账户信息复核通过 ("08","账户信息复核通过", 9,""),
    E_13_转出审核不通过 ("13", "转出审核不通过",7,""),

    E_40_失败办结 ("40", "失败办结",7,""),
    E_02_联系函确认接收 ("02", "联系函确认接收",7,""),
    E_05_转入撤销业务办结 ("05", "转入撤销业务办结",7,""),

    E_06_协商中 ("06", "协商中",7,""),
    E_20_协商办结 ("20", "协商办结",7,""),



            ;






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

    E_TR002_联系函基础信息_联系函状态(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static E_TR002_联系函基础信息_联系函状态 fromString(String text) {
        for (E_TR002_联系函基础信息_联系函状态 status : E_TR002_联系函基础信息_联系函状态.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_TR002_联系函基础信息_联系函状态 fromInt(Integer text) {
        for (E_TR002_联系函基础信息_联系函状态 status : E_TR002_联系函基础信息_联系函状态.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
