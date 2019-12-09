package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_担保方式_GuaranteeTypeEnum_HX {


    抵押 ("01", "抵押",0,""),
    质押 ("02", "质押",1,""),

    保证 ("04","保证", 9,""),

    抵押_质押 ("03","抵押+质押", 9,""),
    抵押_保证 ("05","抵押_保证", 9,""),
    质押_保证 ("06","质押_保证", 9,""),
    抵押_质押_保证 ("07","抵押_质押_保证", 9,""),
    其他 ("99","其他", 9,"");







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

    E_担保方式_GuaranteeTypeEnum_HX(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static E_担保方式_GuaranteeTypeEnum_HX fromString(String text) {
        for (E_担保方式_GuaranteeTypeEnum_HX status : E_担保方式_GuaranteeTypeEnum_HX.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_担保方式_GuaranteeTypeEnum_HX fromInt(Integer text) {
        for (E_担保方式_GuaranteeTypeEnum_HX status : E_担保方式_GuaranteeTypeEnum_HX.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
