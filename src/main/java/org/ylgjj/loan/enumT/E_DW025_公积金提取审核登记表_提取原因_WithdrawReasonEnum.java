package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum {

    购房 ("001", "购房",1,""),
    建造翻建 ("002", "建造翻建",2,""),
    大修 ("003", "大修",3,""),
    偿还商业_住房_装修_贷款本息 ("004", "偿还商业(住房/装修)贷款本息",4,""),
    偿还公积金贷款 ("005", "偿还公积金贷款",5,""),


    租房 ("006", "租房",6,""),
    子女上大学 ("007", "子女上大学",7,""),
    重大疾病 ("008", "重大疾病",8,""),
    突发事件 ("009", "突发事件",9,""),
    协助执法扣划账户金额 ("010", "协助执法扣划账户金额",10,""),

    应征入伍 ("011", "应征入伍",11,""),
    享受城镇最低生活保障 ("013", "享受城镇最低生活保障",12,""),

    提取物业费 ("015", "提取物业费",13,""),

    公积金代扣还款_逐月代扣 ("021", "公积金代扣还款(逐月代扣)",14,""),
    约定提取 ("022", "约定提取",15,""),
    装修 ("023", "装修",16,""),

    异地贷款提取 ("024", "异地贷款提取",17,""),
    强制扣划公积金还贷款 ("025", "强制扣划公积金还贷款",18,""),
    柜台还款公积金转账 ("026", "柜台还款公积金转账",19,""),
    其他提取 ("030", "其他提取",20,""),
    离退休 ("101", "离退休",21,""),



    死亡或被宣告死亡 ("102", "死亡或被宣告死亡",22,""),
    出境定居 ("103", "出境定居",23,""),
    调出本市 ("104", "调出本市",24,""),
    完全丧失劳动能力并与单位终止劳动关系 ("105", "完全丧失劳动能力并与单位终止劳动关系",25,""),
    与单位终止劳动关系 ("106", "与单位终止劳动关系",26,""),


    其他 ("107", "其他",27,""),
    零额销户 ("108", "零额销户",28,""),
    异地转移 ("109", "异地转移",29,""),

    异地单位转移 ("111", "异地单位转移",30,""),


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

    private E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum(String statusText, String displayText, Integer id, String helpMessage) {
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

    public static 提取原因_WithdrawReasonEnum_银行 from(String text) {



        E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum typeEnum = E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.fromString(text);
        switch (typeEnum){
            case 购房:
                return 提取原因_WithdrawReasonEnum_银行.购房;
            case 偿还商业_住房_装修_贷款本息:
                return 提取原因_WithdrawReasonEnum_银行.偿还商业_住房_装修_贷款本息;
            case 建造翻建:
            case 大修:
                return 提取原因_WithdrawReasonEnum_银行.建造_翻建_大修住房提取;
            case 租房:
                return 提取原因_WithdrawReasonEnum_银行.房租超出家庭工资收入的规定比例提取;
            case 装修:
                return 提取原因_WithdrawReasonEnum_银行.装修提取;
            case 协助执法扣划账户金额:
                return 提取原因_WithdrawReasonEnum_银行.法院扣划提取;
            case 离退休:
                return 提取原因_WithdrawReasonEnum_银行.离休_退休;
            case 完全丧失劳动能力并与单位终止劳动关系:
                return 提取原因_WithdrawReasonEnum_银行.完全丧失劳动能力_并与单位终止劳动关系;

            case 出境定居:
            case 调出本市:
                return 提取原因_WithdrawReasonEnum_银行.户口迁出所在市_县或出境定居;

            case 与单位终止劳动关系:
            case 零额销户:

                return 提取原因_WithdrawReasonEnum_银行.其他_销户;
            case 异地单位转移:
                return 提取原因_WithdrawReasonEnum_银行.工作调动;
            case 其他:
            case 异地转移:

            case 强制扣划公积金还贷款:
            case 柜台还款公积金转账:
            case 其他提取:
            case 异地贷款提取:
            case 约定提取:
            case 公积金代扣还款_逐月代扣:
            case 享受城镇最低生活保障:
            case 应征入伍:
            case 突发事件:
            case 重大疾病:
            case 子女上大学:
            case 偿还公积金贷款:
                return 提取原因_WithdrawReasonEnum_银行.其他;

            default:
                return 提取原因_WithdrawReasonEnum_银行.其他;

/*
            case 城镇集体企业:
                return 提取原因_WithdrawReasonEnum_银行.户口迁出所在市_县或出境定居;
            case 城镇私营企业:
                return 提取原因_WithdrawReasonEnum_银行.法院执行部分提取;
            case 外资企业:
                return 提取原因_WithdrawReasonEnum_银行.物业管理费提取;
            case 城镇集体企业:
                return 提取原因_WithdrawReasonEnum_银行.错缴;
            case 外资企业:
                return 提取原因_WithdrawReasonEnum_银行.死亡;
            case 城镇私营企业:
                return 提取原因_WithdrawReasonEnum_银行.法院执行销户提取;*/
        }


    }



    public static E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum fromString(String text) {
        for (E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum status : E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum fromInt(Integer text) {
        for (E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum status : E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
