package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum 提取原因_WithdrawReasonEnum_银行 {

    购房 ("0101", "购买住房提取",1,""),
    偿还商业_住房_装修_贷款本息 ("0102", "偿还商业(住房/装修)贷款本息提取",2,""),


    建造_翻建_大修住房提取 ("0103", "建造、翻建、大修住房提取",2,""),

    房租超出家庭工资收入的规定比例提取 ("0105", "房租超出家庭工资收入的规定比例提取",1,""),


    物业管理费提取 ("0106", "物业管理费提取",1,""),
    装修提取 ("0107", "装修提取",2,""),
    错缴 ("0108", "错缴",1,""),
    法院扣划提取 ("0109", "法院扣划提取",2,""),
    法院执行部分提取 ("0198", "法院执行部分提取",1,""),

    其他 ("0199", "其他（部分）",1,""),

    离休_退休 ("0201", "离休、退休",1,""),
    完全丧失劳动能力_并与单位终止劳动关系 ("0202", "完全丧失劳动能力，并与单位终止劳动关系",1,""),
    户口迁出所在市_县或出境定居 ("0203", "户口迁出所在市_县或出境定居",1,""),
    死亡 ("0204", "死亡",1,""),

    法院执行销户提取 ("0298", "法院执行销户提取",1,""),

    其他_销户 ("0299", "其他（销户）",1,""),


    工作调动 ("0301", "工作调动",1,""),




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

    private 提取原因_WithdrawReasonEnum_银行(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static 提取原因_WithdrawReasonEnum_银行 fromString(String text) {
        for (提取原因_WithdrawReasonEnum_银行 status : 提取原因_WithdrawReasonEnum_银行.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static 提取原因_WithdrawReasonEnum_银行 fromInt(Integer text) {
        for (提取原因_WithdrawReasonEnum_银行 status : 提取原因_WithdrawReasonEnum_银行.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
