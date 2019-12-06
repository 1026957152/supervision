package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum H公积金开销户登记簿_开销户标志 {
    //ocflag_不可为空_开销户标志; //0-开户,1-销户,2-销户激活,9-撤销	0:不可为空

    开户 ("0", "开户",0,""),
    销户 ("1", "销户",1,""),
    销户激活 ("2", "销户激活",2,""),

    撤销 ("9", "撤销",9,""),

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

    H公积金开销户登记簿_开销户标志(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static H公积金开销户登记簿_开销户标志 fromString(String text) {
        for (H公积金开销户登记簿_开销户标志 status : H公积金开销户登记簿_开销户标志.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static H公积金开销户登记簿_开销户标志 fromInt(Integer text) {
        for (H公积金开销户登记簿_开销户标志 status : H公积金开销户登记簿_开销户标志.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
