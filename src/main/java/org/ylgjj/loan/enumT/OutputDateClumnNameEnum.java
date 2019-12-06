package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;



/**
 * Created by silence on 2016/1/18.
 */
public enum OutputDateClumnNameEnum {
    序号 ("0", "序号",0,""),
    姓名 ("0", "姓名",1,""),
    身份证号 ("1", "身份证号",2,""),
    单位名称 ("2", "单位名称",3,""),
    单位编号 ("3", "单位编号",4,""),
    贷款金额 ("4", "贷款金额",5,""),



    贷款剩余金额 ("9", "贷款剩余金额",6,""),




    担保方式 ("0", "担保方式",7,""),
    贷款用途 ("1", "贷款用途",8,""),
    贷款期限 ("2", "贷款期限",9,""),
    贷款剩余期限 ("3", "贷款剩余期限",10,""),
    放款时间 ("4", "放款时间",11,""),
    放款标志 ("9", "放款标志",12,""),


    结清标志 ("0", "结清标志",13,""),
    借款人类型 ("1", "借款人类型",14,""),
    借款人公积金帐号 ("2", "借款人公积金帐号",15,""),


    借款人公积金账户开户日期 ("3", "借款人公积金账户开户日期",16,""),
    借款人公积金账户销户日期 ("4", "借款人公积金账户销户日期",17,""),
    借款人公积金账户上笔发生日期 ("9", "借款人公积金账户上笔发生日期",18,""),


    借款人公积金账户上笔提取日期 ("3", "借款人公积金账户上笔提取日期",19,""),
    借款人公积金账户余额 ("4", "借款人公积金账户余额",20,""),
    借款人公积金账户状态 ("9", "借款人公积金账户状态",21,""),


    __借款人公积金帐号状态 ("3", "__借款人公积金帐号状态",22,""),
    __借款人公积金缴存基数 ("4", "__借款人公积金缴存基数",23,""),
    __借款人公积金最后提取日期 ("9", "__借款人公积金最后提取日期",24,""),


    借款人客户号 ("3", "借款人客户号",25,""),
    借款人变更类型 ("4", "借款人变更类型",36,""),
    联系人姓名 ("9", "联系人姓名",27,""),


    联系人身份类型 ("3", "联系人身份类型",28,""),
    联系人身份号码 ("4", "联系人身份号码",29,""),
    联系人电话 ("9", "联系人电话",30,""),

    借款人单位性质 ("3", "借款人单位性质",31,""),
    借款人单位地址 ("4", "借款人单位地址",32,""),
    借款人单位联系人姓名 ("9", "借款人单位联系人姓名",33,""),

    借款人单位联系人电话 ("9", "借款人单位联系人电话",34,""),


    借款人担保贷款数量 ("9", "借款人担保贷款数量",35,""),





    借款人贷款合同号("3", "借款人贷款合同号",36,""),
    借款人贷款总额("3", "借款人贷款总额",37,""),
    借款人贷款笔数("3", "借款人贷款笔数",38,""),




    借款人作为担保人贷款合同号("3", "借款人作为担保人贷款合同号",39,""),
    借款人作为担保人贷款总额("3", "借款人作为担保人贷款总额",40,""),
    借款人作为担保人贷款笔数("3", "借款人作为担保人贷款笔数",41,""),


    借款人该笔贷款逾期次数 ("4", "借款人该笔贷款逾期次数",42,""),
    __借款人该笔贷款逾期次数 ("9", "--借款人该笔贷款逾期次数",43,""),

    __借款人该笔贷款累计欠还次数 ("9", "--借款人该笔贷款累计欠还次数",44,""),
    借款人该笔贷款首次逾期日期 ("9", "--借款人该笔贷款首次逾期日期",45,""),





    打款账户户名("4", "打款账户户名_",46,""),
    打款账户类型 ("9", "打款账户类型",47,""),
    打款账户("4", "打款账户",48,""),
    打款账户身份证号("4", "打款账户身份证号",49,""),

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

    OutputDateClumnNameEnum(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static OutputDateClumnNameEnum fromString(String text) {
        for (OutputDateClumnNameEnum status : OutputDateClumnNameEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static OutputDateClumnNameEnum fromInt(Integer text) {
        for (OutputDateClumnNameEnum status : OutputDateClumnNameEnum.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
