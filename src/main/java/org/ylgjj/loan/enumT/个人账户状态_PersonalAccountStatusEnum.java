package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum 个人账户状态_PersonalAccountStatusEnum {


    正常 ("0", "正常",0,""),
    封存 ("1", "封存",1,""),

    销户 ("9","销户", 9,""),
    未知 ("7", "未知",7,""),;






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

    private 个人账户状态_PersonalAccountStatusEnum(String statusText, String displayText, Integer id, String helpMessage) {
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


    public static 个人账户状态_PersonalAccountStatusEnum_银行 from(String text) {



        个人账户状态_PersonalAccountStatusEnum typeEnum = 个人账户状态_PersonalAccountStatusEnum.fromString(text);

        switch (typeEnum){
            case 正常:

                return 个人账户状态_PersonalAccountStatusEnum_银行.正常;

            case 封存:
                return 个人账户状态_PersonalAccountStatusEnum_银行.封存;

            case 销户:

                return 个人账户状态_PersonalAccountStatusEnum_银行.其他;




            default:
                return 个人账户状态_PersonalAccountStatusEnum_银行.其他;


        }


    }

    public static 个人账户状态_PersonalAccountStatusEnum fromString(String text) {
        for (个人账户状态_PersonalAccountStatusEnum status : 个人账户状态_PersonalAccountStatusEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static 个人账户状态_PersonalAccountStatusEnum fromInt(Integer text) {
        for (个人账户状态_PersonalAccountStatusEnum status : 个人账户状态_PersonalAccountStatusEnum.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
