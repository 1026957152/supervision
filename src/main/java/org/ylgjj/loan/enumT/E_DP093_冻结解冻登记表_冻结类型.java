package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_DP093_冻结解冻登记表_冻结类型 {

    E_0_单位户 ("0", "单位户",1,""),
    E_1_预缴户 ("1", "预缴户",2,""),
    E_2_个人户 ("2", "个人户",1,""),

  //  private String accflag_不可为空_账户标志;//_0-单位户,1-预缴户,2-个人户_0.单位 2.个人
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

    E_DP093_冻结解冻登记表_冻结类型(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static E_DP093_冻结解冻登记表_冻结类型 fromString(String text) {
        for (E_DP093_冻结解冻登记表_冻结类型 status : E_DP093_冻结解冻登记表_冻结类型.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_DP093_冻结解冻登记表_冻结类型 fromInt(Integer text) {
        for (E_DP093_冻结解冻登记表_冻结类型 status : E_DP093_冻结解冻登记表_冻结类型.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
