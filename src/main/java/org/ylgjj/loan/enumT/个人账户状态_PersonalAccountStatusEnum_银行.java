package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum 个人账户状态_PersonalAccountStatusEnum_银行 {

    登记 ("00", "登记",0,""),
    正常 ("01", "正常",0,""),
    封存 ("02", "封存",1,""),

    合并销户 ("03","合并销户", 9,""),
    外部转出销户 ("04","外部转出销户", 9,""),
    提取销户 ("05", "提取销户",7,""),
    冻结 ("06", "冻结",7,""),
    其他 ("99", "其他",7,""),

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

    个人账户状态_PersonalAccountStatusEnum_银行(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static 个人账户状态_PersonalAccountStatusEnum_银行 fromString(String text) {
        for (个人账户状态_PersonalAccountStatusEnum_银行 status : 个人账户状态_PersonalAccountStatusEnum_银行.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static 个人账户状态_PersonalAccountStatusEnum_银行 fromInt(Integer text) {
        for (个人账户状态_PersonalAccountStatusEnum_银行 status : 个人账户状态_PersonalAccountStatusEnum_银行.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
