package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum H_LN101_贷款明细_结算方式 {

    E_1_中心内部 ("1", "中心内部",1,""),
    E_2_现金 ("2", "现金",2,""),
    E_3_支票 ("3", "支票",2,""),
    E_4_委托扣款 ("4", "委托扣款",2,""),
    E_5_电子转账 ("5", "电子转账",2,""),

/*    settlemode		"1-中心内部,
            2-现金,
            3-支票,
            4-委托扣款,
            5-电子转账"	0:不可为空_结算方式*/

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

    private H_LN101_贷款明细_结算方式(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static H_LN101_贷款明细_结算方式 fromString(String text) {
        for (H_LN101_贷款明细_结算方式 status : H_LN101_贷款明细_结算方式.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static H_LN101_贷款明细_结算方式 fromInt(Integer text) {
        for (H_LN101_贷款明细_结算方式 status : H_LN101_贷款明细_结算方式.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
