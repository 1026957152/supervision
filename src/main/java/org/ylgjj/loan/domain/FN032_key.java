package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */




public class FN032_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    @Column(name = "accsetid")
    private String accsetid_ACCSETID_不可为空_账套标识;//

    @Column(name = "accvoudate")
    private Date accvoudate_ACCVOUDATE_不可为空_会计凭证日期;//
    @Column(name = "instcode")
    private String instcode_INSTCODE_不可为空_机构代码;//

    @Column(name = "accvoucode")
    private String accvoucode_ACCVOUCODE_不可为空_会计凭证编码;//		凭证ID
    @Column(name = "accvouseqno")
    private long accvouseqno_ACCVOUSEQNO_不可为空_会计凭证序号;//


    public String getAccsetid_ACCSETID_不可为空_账套标识() {
        return accsetid_ACCSETID_不可为空_账套标识;
    }

    public void setAccsetid_ACCSETID_不可为空_账套标识(String accsetid_ACCSETID_不可为空_账套标识) {
        this.accsetid_ACCSETID_不可为空_账套标识 = accsetid_ACCSETID_不可为空_账套标识;
    }

    public Date getAccvoudate_ACCVOUDATE_不可为空_会计凭证日期() {
        return accvoudate_ACCVOUDATE_不可为空_会计凭证日期;
    }

    public void setAccvoudate_ACCVOUDATE_不可为空_会计凭证日期(Date accvoudate_ACCVOUDATE_不可为空_会计凭证日期) {
        this.accvoudate_ACCVOUDATE_不可为空_会计凭证日期 = accvoudate_ACCVOUDATE_不可为空_会计凭证日期;
    }

    public String getInstcode_INSTCODE_不可为空_机构代码() {
        return instcode_INSTCODE_不可为空_机构代码;
    }

    public void setInstcode_INSTCODE_不可为空_机构代码(String instcode_INSTCODE_不可为空_机构代码) {
        this.instcode_INSTCODE_不可为空_机构代码 = instcode_INSTCODE_不可为空_机构代码;
    }

    public String getAccvoucode_ACCVOUCODE_不可为空_会计凭证编码() {
        return accvoucode_ACCVOUCODE_不可为空_会计凭证编码;
    }

    public void setAccvoucode_ACCVOUCODE_不可为空_会计凭证编码(String accvoucode_ACCVOUCODE_不可为空_会计凭证编码) {
        this.accvoucode_ACCVOUCODE_不可为空_会计凭证编码 = accvoucode_ACCVOUCODE_不可为空_会计凭证编码;
    }

    public long getAccvouseqno_ACCVOUSEQNO_不可为空_会计凭证序号() {
        return accvouseqno_ACCVOUSEQNO_不可为空_会计凭证序号;
    }

    public void setAccvouseqno_ACCVOUSEQNO_不可为空_会计凭证序号(long accvouseqno_ACCVOUSEQNO_不可为空_会计凭证序号) {
        this.accvouseqno_ACCVOUSEQNO_不可为空_会计凭证序号 = accvouseqno_ACCVOUSEQNO_不可为空_会计凭证序号;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
