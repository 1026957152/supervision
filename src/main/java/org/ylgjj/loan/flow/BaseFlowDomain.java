package org.ylgjj.loan.flow;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.ylgjj.loan.util.DateRange;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Peter Xu on 12/08/2014.
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseFlowDomain implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Transient
    DateRange dateRange;
    ;

    public DateRange getDateRange() {
        return dateRange;
    }

    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }

    @Column(name = "agency_id")
    private String agencyId;

    public String getAgencyId() {
        return agencyId;
    }

    @Column(name = "单位经济类型")
    private String agencyId单位经济类型;
    @Column(name = "银行名称")
    private String agencyId银行名称;

    public String getAgencyId银行名称() {
        return agencyId银行名称;
    }

    public void setAgencyId银行名称(String agencyId银行名称) {
        this.agencyId银行名称 = agencyId银行名称;
    }

    public String getAgencyId单位经济类型() {
        return agencyId单位经济类型;
    }

    public void setAgencyId单位经济类型(String agencyId单位经济类型) {
        this.agencyId单位经济类型 = agencyId单位经济类型;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    @Column(name = "create_by")
    @CreatedBy
    private Integer createBy;

    @Column(name = "modify_by")
    @LastModifiedBy
    private Integer modifyBy;

    @Column(name = "create_date")
    @CreatedDate
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    @Column(name = "modify_date")
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyDate;

    @Column(name = "version")
    @Version
    private Integer version;

    @Column(unique = true, name = "uuid"/*, nullable = false*/)
    private String uuid = UUID.randomUUID().toString().toUpperCase();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }



    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }


    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
