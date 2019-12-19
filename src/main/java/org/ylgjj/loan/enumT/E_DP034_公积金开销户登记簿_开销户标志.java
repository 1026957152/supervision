package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_DP034_公积金开销户登记簿_开销户标志 {

    E_0_开户 ("0", "开户",1,""),
    E_1_销户 ("1", "销户",2,""),
    E_2_销户激活 ("2", "销户激活",1,""),
    E_3_撤销 ("3", "撤销",1,""),
//0-开户,1-销户,2-销户激活,9-撤销	0:不可为空
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

    E_DP034_公积金开销户登记簿_开销户标志(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static E_DP034_公积金开销户登记簿_开销户标志 fromString(String text) {
        for (E_DP034_公积金开销户登记簿_开销户标志 status : E_DP034_公积金开销户登记簿_开销户标志.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_DP034_公积金开销户登记簿_开销户标志 fromInt(Integer text) {
        for (E_DP034_公积金开销户登记簿_开销户标志 status : E_DP034_公积金开销户登记簿_开销户标志.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
