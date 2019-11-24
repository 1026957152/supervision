package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum 证件类型 {

    身份证 ("1", "身份证",1,""),
    军官证 ("2", "军官证",2,""),
    护照 ("3", "护照",1,""),
    其他 ("9", "其他",1,""),

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

    private 证件类型(String statusText, String displayText, Integer id, String helpMessage) {
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


    public static 证件类型_银行 from(String text) {



        证件类型 typeEnum = 证件类型.fromString(text);
        switch (typeEnum){
            case 身份证:

                return 证件类型_银行.身份证;

            case 军官证:

                return 证件类型_银行.军官证;
            case 护照:
                return 证件类型_银行.护照;
            case 其他:

              return 证件类型_银行.其他证件;

            default:
                return 证件类型_银行.其他证件;

        }


    }


    public static 证件类型 fromString(String text) {
        for (证件类型 status : 证件类型.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static 证件类型 fromInt(Integer text) {
        for (证件类型 status : 证件类型.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
