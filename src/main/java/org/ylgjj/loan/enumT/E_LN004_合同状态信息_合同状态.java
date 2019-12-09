package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_LN004_合同状态信息_合同状态 {


    E_00_申请 ("00", "申请",0,""),
    E_01_审批 ("01", "审批",1,""),

    E_02_合同签订 ("02","合同签订", 9,""),
    E_07_贷款担保 ("07", "贷款担保",7,""),
    E_08_放款通知 ("08", "放款通知",7,""),
    E_09_放款 ("09", "放款",7,""),
    E_90_合同终止 ("08", "合同终止",7,""),
    E_98_审批撤销 ("98", "审批撤销",7,""),

    E_99_合同废弃 ("99", "合同废弃",7,""),
    ;

// 00-申请,  01-审批,  02-合同签订,  07-贷款担保,  08-放款通知,  09-放款,  90-合同终止,  98-审批撤销,  99-合同废弃





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

    E_LN004_合同状态信息_合同状态(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static E_LN004_合同状态信息_合同状态 fromString(String text) {
        for (E_LN004_合同状态信息_合同状态 status : E_LN004_合同状态信息_合同状态.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_LN004_合同状态信息_合同状态 fromInt(Integer text) {
        for (E_LN004_合同状态信息_合同状态 status : E_LN004_合同状态信息_合同状态.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
