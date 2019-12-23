package org.ylgjj.loan.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;


@SqlResultSetMapping(
            name="groupDetailsMapping",
            classes={
                    @ConstructorResult(
                            targetClass=PB017公共流水登记簿Dto.class,
                            columns={
                                    @ColumnResult(name="GROUP_ID"),
                                    @ColumnResult(name="USER_ID")
                            }
                    )
            }
    )

  @NamedNativeQuery(name="getGroupDetails", query="SELECT g.*, gm.* FROM group g LEFT JOIN group_members gm ON g.group_id = gm.group_id and gm.user_id = :userId WHERE g.group_id = :groupId", resultSetMapping="groupDetailsMapping")

public class PB017公共流水登记簿Dto {
    private Long count ;
    private String firstName;
    private String lastName;
 
    public PB017公共流水登记簿Dto(Long count ,String firstName, String lastName) {
        this.count = count;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
// getters, equals and hashCode
}