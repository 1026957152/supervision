package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum Lone_detail_account_status_Enum {


    正常 ("0", "debit",1,""),
    红字 ("1", "红字",1,""),


    蓝字 ("2", "蓝字",2,""),

    撤销 ("6", "撤销",6,""),

    当日冲正 ("7", "当日冲正",7,""),
    冲账 ("8", "冲账",8,""),
    抹账 ("9", "抹账",9,""),


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

    Lone_detail_account_status_Enum(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static Lone_detail_account_status_Enum fromString(String text) {
        for (Lone_detail_account_status_Enum status : Lone_detail_account_status_Enum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static Lone_detail_account_status_Enum fromInt(Integer text) {
        for (Lone_detail_account_status_Enum status : Lone_detail_account_status_Enum.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
