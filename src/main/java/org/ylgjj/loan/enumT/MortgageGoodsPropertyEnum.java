package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum MortgageGoodsPropertyEnum {


    自有所购_建_修翻_住房 ("1", "自有所购（建、修翻）住房",0,""),
    自有他处住房 ("2", "自有他处住房",1,""),
    第三人房产 ("3", "第三人房产",1,""),
    土地 ("4", "土地",1,""),

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

    private MortgageGoodsPropertyEnum(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static MortgageGoodsPropertyEnum fromString(String text) {
        for (MortgageGoodsPropertyEnum status : MortgageGoodsPropertyEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }

        throw new RuntimeException("no customer status " + text);
    }

    public static MortgageGoodsPropertyEnum fromInt(Integer text) {
        for (MortgageGoodsPropertyEnum status : MortgageGoodsPropertyEnum.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
