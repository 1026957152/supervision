package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_LN006_贷款分期还款计划_curseqStatusEnum {

    未还 ("0", "未还",1,""),
    正常归还 ("1", "正常归还",2,""),
    逾期归还 ("2", "逾期归还",1,""),
    提前部分 ("3", "提前部分",2,""),
    提前全部 ("4", "提前全部",1,""),
    逾期 ("9", "逾期",2,""),

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

    E_LN006_贷款分期还款计划_curseqStatusEnum(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static E_LN006_贷款分期还款计划_curseqStatusEnum fromString(String text) {
        for (E_LN006_贷款分期还款计划_curseqStatusEnum status : E_LN006_贷款分期还款计划_curseqStatusEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_LN006_贷款分期还款计划_curseqStatusEnum fromInt(Integer text) {
        for (E_LN006_贷款分期还款计划_curseqStatusEnum status : E_LN006_贷款分期还款计划_curseqStatusEnum.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
