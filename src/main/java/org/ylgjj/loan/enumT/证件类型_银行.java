package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *

 *
 * Created by silence on 2016/1/18.
 */
public enum 证件类型_银行 {

    身份证 ("01", "身份证",1,""),

    护照 ("02", "护照",1,""),

    军官证 ("03", "军官证",1,""),



    士兵证 ("04", "士兵证",1,""),
    警官证 ("05", "警官证",1,""),
    军队学员证 ("06", "军队学员证",1,""),



    军队离退休干部证 ("07", "军队离退休干部证",1,""),
    军队职工证 ("08", "军队职工证",1,""),
    港澳同胞回乡证 ("09", "港澳同胞回乡证",1,""),
    港澳居民来往内地通行证 ("10", "港澳居民来往内地通行证",1,""),
    中华人民共和国来往港澳通行证 ("11", "中华人民共和国来往港澳通行证",1,""),
    台湾居民来往大陆通行证 ("12", "台湾居民来往大陆通行证",1,""),
    大陆居民往来台湾通行证 ("13", "大陆居民往来台湾通行证",1,""),

    外国人居留证 ("14", "外国人居留证",1,""),


    外国人出入境证 ("15", "外国人出入境证",1,""),
    外交官证 ("16", "外交官证",1,""),

    领事馆证 ("17", "领事馆证",1,""),

    海员证 ("18", "海员证",1,""),

    驾驶证 ("19", "驾驶证",1,""),
    工作居住证 ("20", "工作居住证",1,""),
    暂住证 ("21", "暂住证",1,""),
    户口本 ("22", "户口本",1,""),


    其他证件 ("23", "其他证件",1,""),
    结婚证 ("24", "结婚证",1,""),

    ;
    //private String inaccflag;//入账标志
//-,


    //   -
//    -



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

    证件类型_银行(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static 证件类型_银行 fromString(String text) {
        for (证件类型_银行 status : 证件类型_银行.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static 证件类型_银行 fromInt(Integer text) {
        for (证件类型_银行 status : 证件类型_银行.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
