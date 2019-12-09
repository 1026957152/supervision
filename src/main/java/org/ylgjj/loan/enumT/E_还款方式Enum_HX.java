package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_还款方式Enum_HX {

    等额本息 ("1", "等额本息",1,""),
    等额本金 ("2", "等额本金",2,""),
    等本等息 ("3", "等本等息",1,""),
    利随本清 ("4", "利随本清",1,""),

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

    E_还款方式Enum_HX(String statusText, String displayText, Integer id, String helpMessage) {
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
    public static 还款方式Enum_银行 from(String text) {



        System.out.println(text);

        E_还款方式Enum_HX typeEnum = E_还款方式Enum_HX.fromString(text);
        switch (typeEnum){
            case 等本等息:

                return 还款方式Enum_银行.等本等息;

            case 等额本息:

                return 还款方式Enum_银行.等额本息;
            case 等额本金:

                return 还款方式Enum_银行.等额本金;
            case 利随本清:

                return 还款方式Enum_银行.一次还款付息;

            default:
                return 还款方式Enum_银行.其他;

        }



    }
    public static E_还款方式Enum_HX fromString(String text) {
        for (E_还款方式Enum_HX status : E_还款方式Enum_HX.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_还款方式Enum_HX fromInt(Integer text) {
        for (E_还款方式Enum_HX status : E_还款方式Enum_HX.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
