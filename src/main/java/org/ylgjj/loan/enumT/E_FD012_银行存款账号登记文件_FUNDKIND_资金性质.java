package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_FD012_银行存款账号登记文件_FUNDKIND_资金性质 {
    //01-住房公积金存款,03-增值收益存款_
    E_01_住房公积金存款 ("01", "住房公积金存款",1,""),
    E_02_委托贷款户 ("02", "委托贷款户",2,""),


    E_03_增值收益存款 ("03", "增值收益存款_",3,""),



;






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

    private E_FD012_银行存款账号登记文件_FUNDKIND_资金性质(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static E_FD012_银行存款账号登记文件_FUNDKIND_资金性质 fromString(String text) {
        for (E_FD012_银行存款账号登记文件_FUNDKIND_资金性质 status : E_FD012_银行存款账号登记文件_FUNDKIND_资金性质.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }


}
