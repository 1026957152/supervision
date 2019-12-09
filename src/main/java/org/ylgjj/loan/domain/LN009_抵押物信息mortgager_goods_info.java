package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(LN009_key.class)
@Entity

@Table(name = "LN009")

public class LN009_抵押物信息mortgager_goods_info {



    



    @Id
    @Column(name = "loancontrcode")
    private String loancontrcode_不可为空_合同代码;
    
    @Id
    @Column(name = "mortseqnum")
    private String mortseqnum_不可为空_抵押物序号;

    @Id
    @Column(name = "chgnum")
    private String chgnum_不可为空_变更序号;











    @Column(name = "changetype")
    private String changetype_不可为空_变更类型;
/*     "1-增加抵押物,
             2-减少抵押物,
            3-变更抵押物,
            4-变更抵押物信息"_0:*/

    @Column(name = "mortreasontype")
    private String mortreasontype_可为空_抵押物变更原因;
/*    "1-调房,
            2-拆迁,
            3-更名,
            4-损毁、灭失,
            5-产权转移,
            9-其他"_1:*/
    @Column(name = "mortreason")
    private String mortreason_变更的具体原因可为空_抵押物变更具体原因;







    @Column(name = "morttype")
    private String morttype_不可为空_抵押类型; //   _"0-预抵押,1-抵押"_0:



    @Column(name = "mortproperty")
    private String mortproperty_不可为空_抵押物类型_;
/*    "1-自有所购（建、修翻）住房,
            2-自有他处住房,
            3-第三人房产,
            4-土地"_0:*/

    @Column(name = "straddr")
    private String straddr_可为空_行政街号地址;

    @Column(name = "mortfinishdate")
    private String mortfinishdate_可为空_抵押物竣工日期;

    @Column(name = "evalcorpname")
    private String evalcorpname_可为空_评估公司;
    @Column(name = "mortworth")
    private String mortworth_可为空_抵押物评估价值;

    @Column(name = "ceroutdate")
    private String ceroutdate_可为空_出证日期;


    @Column(name = "mortstate")
    private String mortstate_不可为空_抵押状态_;
/*
    "1-待抵押确认,
            2-正常,
            3-待抵押解除,
            4-抵押权解除,
            9-作废"_0:*/


    @Column(name = "mortaddr")
    private String mortaddr;

    @Column(name = "mortarea")
    private String mortarea_可为空_抵押物面积;

    @Column(name = "transdate")
    private LocalDate transdate不可为空交易日期;

    @Column(name = "hostsernum")
    private Integer hostsernum_不可为空_主机流水号;










    @Column(name = "cerrightnum")
    private String cerrightnum_可为空_抵押物产权证号;//抵押物产权证号

    @Column(name = "elsrightnum")
    private String elsrightnum_可为空_抵押物他项权证号;//抵押物他项权证号

    @Column(name = "elsrightdate")
    private String elsrightdate_可为空_他项权证出证日期;//抵押物他项权证号

    @Column(name = "precerrightnum")
    private String precerrightnum_可为空_预告登记证号;//预告登记证号
    @Column(name = "precerdate")
    private String precerdate_可为空_预告登记出证日期;//预告登记证号

    @Column(name = "housestruct")
    private String housestruct_可为空_抵押物房屋结构_;//土地证编号
/*        "1-砖混,
                2-钢混,
            3-框架,
            4-框剪,
            5-砖木,
            6-土木
"_1:
    */











    @Column(name = "landarea")
    private String landarea_可为空_土地面积;
    @Column(name = "landdate")
    private String landdate_可为空_土地证出证日期;
    @Column(name = "guarcreadate")
    private String guarcreadate_可为空_抵押权建立日期;//土地证编号

    @Column(name = "guarreliefdate")
    private String guarreliefdate_可为空_抵押权解除日期;//土地证编号
    @Column(name = "validflag")
    private String validflag_不可为空_有效标志;//土地证编号

    @Column(name = "landrightnum")
    private String landrightnum_可为空_土地证编号;//土地证编号

    @Column(name = "guarcerrightnum")
    private String guarcerrightnum;//抵押权预告登记证号

    public String getLoancontrcode_不可为空_合同代码() {
        return loancontrcode_不可为空_合同代码;
    }

    public void setLoancontrcode_不可为空_合同代码(String loancontrcode_不可为空_合同代码) {
        this.loancontrcode_不可为空_合同代码 = loancontrcode_不可为空_合同代码;
    }

    public String getMortseqnum_不可为空_抵押物序号() {
        return mortseqnum_不可为空_抵押物序号;
    }

    public void setMortseqnum_不可为空_抵押物序号(String mortseqnum_不可为空_抵押物序号) {
        this.mortseqnum_不可为空_抵押物序号 = mortseqnum_不可为空_抵押物序号;
    }

    public String getChgnum_不可为空_变更序号() {
        return chgnum_不可为空_变更序号;
    }

    public void setChgnum_不可为空_变更序号(String chgnum_不可为空_变更序号) {
        this.chgnum_不可为空_变更序号 = chgnum_不可为空_变更序号;
    }

    public String getChangetype_不可为空_变更类型() {
        return changetype_不可为空_变更类型;
    }

    public void setChangetype_不可为空_变更类型(String changetype_不可为空_变更类型) {
        this.changetype_不可为空_变更类型 = changetype_不可为空_变更类型;
    }

    public String getMortreasontype_可为空_抵押物变更原因() {
        return mortreasontype_可为空_抵押物变更原因;
    }

    public void setMortreasontype_可为空_抵押物变更原因(String mortreasontype_可为空_抵押物变更原因) {
        this.mortreasontype_可为空_抵押物变更原因 = mortreasontype_可为空_抵押物变更原因;
    }

    public String getMortreason_变更的具体原因可为空_抵押物变更具体原因() {
        return mortreason_变更的具体原因可为空_抵押物变更具体原因;
    }

    public void setMortreason_变更的具体原因可为空_抵押物变更具体原因(String mortreason_变更的具体原因可为空_抵押物变更具体原因) {
        this.mortreason_变更的具体原因可为空_抵押物变更具体原因 = mortreason_变更的具体原因可为空_抵押物变更具体原因;
    }

    public String getMorttype_不可为空_抵押类型() {
        return morttype_不可为空_抵押类型;
    }

    public void setMorttype_不可为空_抵押类型(String morttype_不可为空_抵押类型) {
        this.morttype_不可为空_抵押类型 = morttype_不可为空_抵押类型;
    }

    public String getMortproperty_不可为空_抵押物类型_() {
        return mortproperty_不可为空_抵押物类型_;
    }

    public void setMortproperty_不可为空_抵押物类型_(String mortproperty_不可为空_抵押物类型_) {
        this.mortproperty_不可为空_抵押物类型_ = mortproperty_不可为空_抵押物类型_;
    }

    public String getStraddr_可为空_行政街号地址() {
        return straddr_可为空_行政街号地址;
    }

    public void setStraddr_可为空_行政街号地址(String straddr_可为空_行政街号地址) {
        this.straddr_可为空_行政街号地址 = straddr_可为空_行政街号地址;
    }

    public String getMortfinishdate_可为空_抵押物竣工日期() {
        return mortfinishdate_可为空_抵押物竣工日期;
    }

    public void setMortfinishdate_可为空_抵押物竣工日期(String mortfinishdate_可为空_抵押物竣工日期) {
        this.mortfinishdate_可为空_抵押物竣工日期 = mortfinishdate_可为空_抵押物竣工日期;
    }

    public String getEvalcorpname_可为空_评估公司() {
        return evalcorpname_可为空_评估公司;
    }

    public void setEvalcorpname_可为空_评估公司(String evalcorpname_可为空_评估公司) {
        this.evalcorpname_可为空_评估公司 = evalcorpname_可为空_评估公司;
    }

    public String getMortworth_可为空_抵押物评估价值() {
        return mortworth_可为空_抵押物评估价值;
    }

    public void setMortworth_可为空_抵押物评估价值(String mortworth_可为空_抵押物评估价值) {
        this.mortworth_可为空_抵押物评估价值 = mortworth_可为空_抵押物评估价值;
    }

    public String getCeroutdate_可为空_出证日期() {
        return ceroutdate_可为空_出证日期;
    }

    public void setCeroutdate_可为空_出证日期(String ceroutdate_可为空_出证日期) {
        this.ceroutdate_可为空_出证日期 = ceroutdate_可为空_出证日期;
    }

    public String getMortstate_不可为空_抵押状态_() {
        return mortstate_不可为空_抵押状态_;
    }

    public void setMortstate_不可为空_抵押状态_(String mortstate_不可为空_抵押状态_) {
        this.mortstate_不可为空_抵押状态_ = mortstate_不可为空_抵押状态_;
    }

    public String getMortaddr() {
        return mortaddr;
    }

    public void setMortaddr(String mortaddr) {
        this.mortaddr = mortaddr;
    }

    public String getMortarea_可为空_抵押物面积() {
        return mortarea_可为空_抵押物面积;
    }

    public void setMortarea_可为空_抵押物面积(String mortarea_可为空_抵押物面积) {
        this.mortarea_可为空_抵押物面积 = mortarea_可为空_抵押物面积;
    }

    public LocalDate getTransdate不可为空交易日期() {
        return transdate不可为空交易日期;
    }

    public void setTransdate不可为空交易日期(LocalDate transdate不可为空交易日期) {
        this.transdate不可为空交易日期 = transdate不可为空交易日期;
    }

    public Integer getHostsernum_不可为空_主机流水号() {
        return hostsernum_不可为空_主机流水号;
    }

    public void setHostsernum_不可为空_主机流水号(Integer hostsernum_不可为空_主机流水号) {
        this.hostsernum_不可为空_主机流水号 = hostsernum_不可为空_主机流水号;
    }

    public String getCerrightnum_可为空_抵押物产权证号() {
        return cerrightnum_可为空_抵押物产权证号;
    }

    public void setCerrightnum_可为空_抵押物产权证号(String cerrightnum_可为空_抵押物产权证号) {
        this.cerrightnum_可为空_抵押物产权证号 = cerrightnum_可为空_抵押物产权证号;
    }

    public String getElsrightnum_可为空_抵押物他项权证号() {
        return elsrightnum_可为空_抵押物他项权证号;
    }

    public void setElsrightnum_可为空_抵押物他项权证号(String elsrightnum_可为空_抵押物他项权证号) {
        this.elsrightnum_可为空_抵押物他项权证号 = elsrightnum_可为空_抵押物他项权证号;
    }

    public String getElsrightdate_可为空_他项权证出证日期() {
        return elsrightdate_可为空_他项权证出证日期;
    }

    public void setElsrightdate_可为空_他项权证出证日期(String elsrightdate_可为空_他项权证出证日期) {
        this.elsrightdate_可为空_他项权证出证日期 = elsrightdate_可为空_他项权证出证日期;
    }

    public String getPrecerrightnum_可为空_预告登记证号() {
        return precerrightnum_可为空_预告登记证号;
    }

    public void setPrecerrightnum_可为空_预告登记证号(String precerrightnum_可为空_预告登记证号) {
        this.precerrightnum_可为空_预告登记证号 = precerrightnum_可为空_预告登记证号;
    }

    public String getPrecerdate_可为空_预告登记出证日期() {
        return precerdate_可为空_预告登记出证日期;
    }

    public void setPrecerdate_可为空_预告登记出证日期(String precerdate_可为空_预告登记出证日期) {
        this.precerdate_可为空_预告登记出证日期 = precerdate_可为空_预告登记出证日期;
    }

    public String getHousestruct_可为空_抵押物房屋结构_() {
        return housestruct_可为空_抵押物房屋结构_;
    }

    public void setHousestruct_可为空_抵押物房屋结构_(String housestruct_可为空_抵押物房屋结构_) {
        this.housestruct_可为空_抵押物房屋结构_ = housestruct_可为空_抵押物房屋结构_;
    }

    public String getLandarea_可为空_土地面积() {
        return landarea_可为空_土地面积;
    }

    public void setLandarea_可为空_土地面积(String landarea_可为空_土地面积) {
        this.landarea_可为空_土地面积 = landarea_可为空_土地面积;
    }

    public String getLanddate_可为空_土地证出证日期() {
        return landdate_可为空_土地证出证日期;
    }

    public void setLanddate_可为空_土地证出证日期(String landdate_可为空_土地证出证日期) {
        this.landdate_可为空_土地证出证日期 = landdate_可为空_土地证出证日期;
    }

    public String getGuarcreadate_可为空_抵押权建立日期() {
        return guarcreadate_可为空_抵押权建立日期;
    }

    public void setGuarcreadate_可为空_抵押权建立日期(String guarcreadate_可为空_抵押权建立日期) {
        this.guarcreadate_可为空_抵押权建立日期 = guarcreadate_可为空_抵押权建立日期;
    }

    public String getGuarreliefdate_可为空_抵押权解除日期() {
        return guarreliefdate_可为空_抵押权解除日期;
    }

    public void setGuarreliefdate_可为空_抵押权解除日期(String guarreliefdate_可为空_抵押权解除日期) {
        this.guarreliefdate_可为空_抵押权解除日期 = guarreliefdate_可为空_抵押权解除日期;
    }

    public String getValidflag_不可为空_有效标志() {
        return validflag_不可为空_有效标志;
    }

    public void setValidflag_不可为空_有效标志(String validflag_不可为空_有效标志) {
        this.validflag_不可为空_有效标志 = validflag_不可为空_有效标志;
    }

    public String getLandrightnum_可为空_土地证编号() {
        return landrightnum_可为空_土地证编号;
    }

    public void setLandrightnum_可为空_土地证编号(String landrightnum_可为空_土地证编号) {
        this.landrightnum_可为空_土地证编号 = landrightnum_可为空_土地证编号;
    }

    public String getGuarcerrightnum() {
        return guarcerrightnum;
    }

    public void setGuarcerrightnum(String guarcerrightnum) {
        this.guarcerrightnum = guarcerrightnum;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
