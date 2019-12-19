package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_LN014_贷款房屋信息_房屋类型 {


    E_01_商品房 ("01", "商品房",0,""),
    E_02_经济适用房 ("02", "经济适用房",1,""),

    E_03_存量房 ("03","存量房", 9,""),
    E_04_抵押房 ("04", "抵押房",7,""),
    E_05_房改房 ("05", "房改房",7,""),
    E_06_拍卖房 ("06", "拍卖房",7,""),
    E_07_拆迁房 ("07", "拆迁房",7,""),
    E_08_建造自住住房 ("08", "建造自住住房",7,""),

    E_09_翻建自住住房 ("09", "翻建自住住房",7,""),
    E_10_大修自住住房 ("10", "大修自住住房",7,""),

    E_11_集资房 ("11", "集资房",7,""),
    E_12_公租房 ("12", "公租房",7,""),
    E_13_廉租房 ("13", "廉租房",7,""),
    E_14_棚户区改造房 ("14", "棚户区改造房",7,""),

    E_15_竣工自住住房 ("15", "竣工自住住房",7,""),
    E_16_装修住房 ("16", "装修住房",7,""),
    ;


//01-商品房, 02-经济适用房, 03-存量房, 04-抵押房, 05-房改房, 06-拍卖房, 07-拆迁房, 08-建造自住住房, 09-翻建自住住房, 10-大修自住住房




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

    E_LN014_贷款房屋信息_房屋类型(String statusText, String displayText, Integer id, String helpMessage) {
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


    public static E_LN014_贷款房屋信息_房屋类型 fromString(String text) {
        for (E_LN014_贷款房屋信息_房屋类型 status : E_LN014_贷款房屋信息_房屋类型.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_LN014_贷款房屋信息_房屋类型 fromInt(Integer text) {
        for (E_LN014_贷款房屋信息_房屋类型 status : E_LN014_贷款房屋信息_房屋类型.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
