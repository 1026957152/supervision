package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_LN003_合同信息_贷款账户状态 {



    E_1_正常 ("1", "正常",1,""),
    E_2_逾期 ("2", "逾期",1,""),
    E_3_部分逾期 ("3", "部分逾期",1,""),
    E_4_停息挂账 ("4", "停息挂账",1,""),
    E_5_清户 ("5", "清户",1,""),
    E_6_销户 ("6", "销户",1,""),
    E_7_核销 ("7", "核销",1,""),

    ;


/*    		"1-正常,
            2-逾期,
            3-部分逾期,
            4-停息挂账,
            5-清户,
            6-销户,
            7-核销"	0:	*/



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

    E_LN003_合同信息_贷款账户状态(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static E_LN003_合同信息_贷款账户状态 fromString(String text) {
        for (E_LN003_合同信息_贷款账户状态 status : E_LN003_合同信息_贷款账户状态.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_LN003_合同信息_贷款账户状态 fromInt(Integer text) {
        for (E_LN003_合同信息_贷款账户状态 status : E_LN003_合同信息_贷款账户状态.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
