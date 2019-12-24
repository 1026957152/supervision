package org.ylgjj.loan.domain_flow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Peter Xu on 12/08/2014.
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseDomain implements Serializable {

    @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
   @GeneratedValue

    private Integer id;


   // @JsonIgnore
    @Column(name = "create_by")
    @CreatedBy
    private Integer createBy;
 //   @JsonIgnore
    @Column(name = "modify_by")
    @LastModifiedBy
    private Integer modifyBy;

    @Column(name = "create_date")
    @CreatedDate
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  //  @JsonIgnore
    private LocalDateTime createDate;

    @Column(name = "modify_date")
    @LastModifiedDate
  //  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  //  @JsonIgnore
    private LocalDateTime modifyDate;

    @Column(name = "version")
    @Version
  //  @JsonIgnore
    private Integer version;



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
