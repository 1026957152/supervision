package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum LoanClearStateEnum {





    未结清 ("0", "未结清",1,""),


    正常还清 ("1", "正常还清",1,""),
    提前还清 ("2", "提前还清",1,""),
    理赔还清 ("3", "理赔还清",1,""),
    核销还清 ("4", "核销还清",1,""),
    其他 ("9", "其他",1,""),

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

    LoanClearStateEnum(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static LoanClearStateEnum fromString(String text) {
        for (LoanClearStateEnum status : LoanClearStateEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static LoanClearStateEnum fromInt(Integer text) {
        for (LoanClearStateEnum status : LoanClearStateEnum.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
