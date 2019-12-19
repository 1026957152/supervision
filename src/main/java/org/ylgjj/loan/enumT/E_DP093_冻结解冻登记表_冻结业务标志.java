package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_DP093_冻结解冻登记表_冻结业务标志 {

    E_0_冻结 ("0", "冻结",1,""),
    E_1_解冻 ("1", "解冻",2,""),



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

    E_DP093_冻结解冻登记表_冻结业务标志(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static E_DP093_冻结解冻登记表_冻结业务标志 fromString(String text) {
        for (E_DP093_冻结解冻登记表_冻结业务标志 status : E_DP093_冻结解冻登记表_冻结业务标志.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_DP093_冻结解冻登记表_冻结业务标志 fromInt(Integer text) {
        for (E_DP093_冻结解冻登记表_冻结业务标志 status : E_DP093_冻结解冻登记表_冻结业务标志.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
