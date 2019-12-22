package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_LN005_贷款分户信息_贷款分户类型 {
    /*
        loanacctype		"01-正常贷款,
                02-逾期贷款,
                03-应收利息(表内),
    13-应收利息(表外),
    18-表外罚息"	0:不可为空	贷款分户类型*/
    E_01_正常贷款 ("01", "正常贷款",1,""),
    E_02_逾期贷款 ("02", "逾期贷款",2,""),
    E_03_应收利息 ("03", "应收利息",1,""),
    E_13_应收利息__表外__ ("13", "应收利息(表外)",1,""),
    E_18_表外罚息 ("18", "表外罚息",1,""),

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

    E_LN005_贷款分户信息_贷款分户类型(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static E_LN005_贷款分户信息_贷款分户类型 fromString(String text) {
        for (E_LN005_贷款分户信息_贷款分户类型 status : E_LN005_贷款分户信息_贷款分户类型.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_LN005_贷款分户信息_贷款分户类型 fromInt(Integer text) {
        for (E_LN005_贷款分户信息_贷款分户类型 status : E_LN005_贷款分户信息_贷款分户类型.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
