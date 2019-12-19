package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_DP005_单位分户账_单位账户类型 {

    普通 ("1", "普通",1,""),
    特殊 ("2", "特殊",2,""),
    组合 ("3", "组合",1,""),
    自由 ("4", "自由",1,""),
    军转 ("5", "军转",1,""),
    托管 ("6", "托管",1,""),
    执法 ("7", "执法",1,""),
    久悬未取 ("8", "久悬未取",1,""),
    预缴户 ("9", "预缴户",1,""),


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

    E_DP005_单位分户账_单位账户类型(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static E_DP005_单位分户账_单位账户类型 fromString(String text) {
        for (E_DP005_单位分户账_单位账户类型 status : E_DP005_单位分户账_单位账户类型.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_DP005_单位分户账_单位账户类型 fromInt(Integer text) {
        for (E_DP005_单位分户账_单位账户类型 status : E_DP005_单位分户账_单位账户类型.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
