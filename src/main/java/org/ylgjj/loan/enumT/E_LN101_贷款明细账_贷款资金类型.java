package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_LN101_贷款明细账_贷款资金类型 {


    E_01_正常本金 ("01", "正常本金",0,""),
    E_02_正常利息 ("02", "正常利息",1,""),

    E_11_逾期本金 ("11","逾期本金", 9,""),
    E_12_应收利息 ("12", "应收利息",7,""),
    E_13_罚息 ("13", "罚息",7,""),
    ;

/*    loanfundtype		"01-正常本金,
            02-正常利息,
            11-逾期本金,
            12-应收利息,
            13-罚息"	0:不可为空_贷款资金类型*/




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

    E_LN101_贷款明细账_贷款资金类型(String statusText, String displayText, Integer id, String helpMessage) {
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


    public static E_LN101_贷款明细账_贷款资金类型 fromString(String text) {
        for (E_LN101_贷款明细账_贷款资金类型 status : E_LN101_贷款明细账_贷款资金类型.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_LN101_贷款明细账_贷款资金类型 fromInt(Integer text) {
        for (E_LN101_贷款明细账_贷款资金类型 status : E_LN101_贷款明细账_贷款资金类型.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
