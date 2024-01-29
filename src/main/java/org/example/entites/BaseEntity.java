package org.example.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
abstract class BaseEntity implements Serializable {
    @CreationTimestamp
    @Temporal(TemporalType.TIME)
    @Column(name = "createDate")
    private Time createTime;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "modifiedDate")
    private Date modifiedDate;

    @Column(name = "createBy")
    private String createBy;

    @Column(name = "modifiedBy")
    private String modifiedBy;

}
