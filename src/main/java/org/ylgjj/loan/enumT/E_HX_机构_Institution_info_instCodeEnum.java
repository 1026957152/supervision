package org.ylgjj.loan.enumT;

//import com.coalvalue.domain.pojo.ListItem;

import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_HX_机构_Institution_info_instCodeEnum {


    府谷县 ("09120006", "府谷县",0,""),
    横山县 ("09120007", "横山县",1,""),
    绥德县 ("09120013", "绥德县",1,""),
    靖边县管理部 ("09120012", "靖边县管理部",1,""),
    佳县管理部管理部 ("09120008", "佳县管理部管理部",1,""),

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

    E_HX_机构_Institution_info_instCodeEnum(String statusText, String displayText, Integer id, String helpMessage) {
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
    public static List<ListItem> retriveTypese() {
        // String userUrl =  linkTo(methodOn(MobileDistributorController.class).detail(null)).withSelfRel().getHref();

        List<ListItem> list = new ArrayList<ListItem>();
        for (E_HX_机构_Institution_info_instCodeEnum status : E_HX_机构_Institution_info_instCodeEnum.values()) {
            ListItem<String> element = new ListItem<String>(status.getText(), status.getDisplayText(), status.getHelpMessage());
            list.add(element);
        }

        return list;

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



    public static E_HX_机构_Institution_info_instCodeEnum fromString(String text) {
        for (E_HX_机构_Institution_info_instCodeEnum status : E_HX_机构_Institution_info_instCodeEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static E_HX_机构_Institution_info_instCodeEnum fromInt(Integer text) {
        for (E_HX_机构_Institution_info_instCodeEnum status : E_HX_机构_Institution_info_instCodeEnum.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

}
