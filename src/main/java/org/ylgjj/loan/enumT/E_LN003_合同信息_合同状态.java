package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_LN003_合同信息_合同状态 {


               申请 ("00", "申请",0,""),
    审批 ("01", "审批",1,""),

    合同签订 ("02","合同签订", 9,""),
    放款通知 ("06", "放款通知",7,""),

    贷款担保 ("07", "贷款担保",7,""),
    贷款放行 ("08", "贷款放行",7,""),
    放款 ("09", "放款",7,""),

    放款失败 ("10", "放款失败",7,""),
    划款委贷户成功 ("20", "划款委贷户成功",7,""),
    放款通知备案 ("21", "放款通知备案",7,""),
    合同终止 ("90", "合同终止",7,""),
    合同废弃 ("99", "合同废弃",7,""),
    未知 ("98", "未知",7,""),


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

    E_LN003_合同信息_合同状态(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static E_LN003_合同信息_合同状态 fromString(String text) {
        for (E_LN003_合同信息_合同状态 status : E_LN003_合同信息_合同状态.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_LN003_合同信息_合同状态 fromInt(Integer text) {
        for (E_LN003_合同信息_合同状态 status : E_LN003_合同信息_合同状态.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
