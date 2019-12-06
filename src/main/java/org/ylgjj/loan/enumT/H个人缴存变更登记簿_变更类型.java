package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum H个人缴存变更登记簿_变更类型 {

    新增个人 ("1", "新增个人",1,""),
    启封 ("2", "启封",2,""),
   //封存 ("3", "封存",3,""),

    封存 ("4", "封存",4,""),
    基数变更 ("8", "基数变更",8,""),
    比例变更 ("9", "比例变更",9,""),
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

    H个人缴存变更登记簿_变更类型(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static H个人缴存变更登记簿_变更类型 fromString(String text) {
        for (H个人缴存变更登记簿_变更类型 status : H个人缴存变更登记簿_变更类型.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static H个人缴存变更登记簿_变更类型 fromInt(Integer text) {
        for (H个人缴存变更登记簿_变更类型 status : H个人缴存变更登记簿_变更类型.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
