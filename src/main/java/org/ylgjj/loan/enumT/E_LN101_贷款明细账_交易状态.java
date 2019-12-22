package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_LN101_贷款明细账_交易状态 {


    E_0_正常 ("0", "正常",0,""),
    E_1_红字 ("1", "红字",1,""),
    E_2_蓝字 ("2", "蓝字",1,""),
    E_6_撤销 ("6", "撤销",1,""),
    E_7_当日冲正 ("7", "当日冲正",1,""),
    E_8_冲账 ("8", "冲账",1,""),
    E_9_抹账 ("9", "抹账",1,"")

    ;

/* "1-借方,2-贷方"	0:*/




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

    E_LN101_贷款明细账_交易状态(String statusText, String displayText, Integer id, String helpMessage) {
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


    public static E_LN101_贷款明细账_交易状态 fromString(String text) {
        for (E_LN101_贷款明细账_交易状态 status : E_LN101_贷款明细账_交易状态.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_LN101_贷款明细账_交易状态 fromInt(Integer text) {
        for (E_LN101_贷款明细账_交易状态 status : E_LN101_贷款明细账_交易状态.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
