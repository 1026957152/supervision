package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_DP005_单位分户账_单位账户状态 {

    正常 ("0", "正常",1,""),
    封存 ("1", "封存",2,""),
    空账 ("2", "空账",1,""),
    销户 ("9", "销户",1,""),

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

    E_DP005_单位分户账_单位账户状态(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static E_DP005_单位分户账_单位账户状态 fromString(String text) {
        for (E_DP005_单位分户账_单位账户状态 status : E_DP005_单位分户账_单位账户状态.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_DP005_单位分户账_单位账户状态 fromInt(Integer text) {
        for (E_DP005_单位分户账_单位账户状态 status : E_DP005_单位分户账_单位账户状态.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
