

package org.ylgjj.loan.domain_zongfu;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "MI007")
@Entity
public class MI007_系统码表 {

  private String centerid;

  @Id
  private long dicid;
  private String itemid;
  private String itemval;
  private long updicid;


  public String getCenterid() {
    return centerid;
  }

  public void setCenterid(String centerid) {
    this.centerid = centerid;
  }


  public long getDicid() {
    return dicid;
  }

  public void setDicid(long dicid) {
    this.dicid = dicid;
  }


  public String getItemid() {
    return itemid;
  }

  public void setItemid(String itemid) {
    this.itemid = itemid;
  }


  public String getItemval() {
    return itemval;
  }

  public void setItemval(String itemval) {
    this.itemval = itemval;
  }


  public long getUpdicid() {
    return updicid;
  }

  public void setUpdicid(long updicid) {
    this.updicid = updicid;
  }

}
