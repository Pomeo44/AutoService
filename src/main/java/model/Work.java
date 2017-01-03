package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "WORK", schema = "", catalog = "kontur44_AutoService")
public class Work extends BaseEntity {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private Date startWorkDate;
    @JsonProperty
    private Date endWorkDate;
    @JsonProperty
    private Integer ownerAutoId;
    @JsonProperty
    private Integer workTypeId;
    @JsonProperty
    private Integer liftId;
    @JsonProperty
    private Integer masterId;
    @JsonProperty
    private Boolean done;
    @JsonProperty
    private Integer actualTime;
    @JsonProperty
    private Integer actualMoney;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "WORK_ID", unique = true, nullable = false, insertable = true, updatable = true)
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer workId) {
        this.id = workId;
    }

    @Basic
    @Column(name = "START_WORK_DATE", nullable = false, insertable = true, updatable = true)
    public Date getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(Timestamp startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    @Basic
    @Column(name = "END_WORK_DATE", nullable = false, insertable = true, updatable = true)
    public Date getEndWorkDate() {
        return endWorkDate;
    }

    public void setEndWorkDate(Date endWorkDate) {
        this.endWorkDate = endWorkDate;
    }

    @Basic
    @Column(name = "ORDERS_ID", nullable = false, insertable = true, updatable = true)
    public Integer getOwnerAutoId() {
        return ownerAutoId;
    }

    public void setOwnerAutoId(Integer ordersId) {
        this.ownerAutoId = ordersId;
    }

    @Basic
    @Column(name = "WORK_TYPE_ID", nullable = false, insertable = true, updatable = true)
    public Integer getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(Integer workTypeId) {
        this.workTypeId = workTypeId;
    }

    @Basic
    @Column(name = "LIFT_ID", nullable = true, insertable = true, updatable = true)
    public Integer getLiftId() {
        return liftId;
    }

    public void setLiftId(Integer liftId) {
        this.liftId = liftId;
    }

    @Basic
    @Column(name = "MASTER_ID", nullable = true, insertable = true, updatable = true)
    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    @Basic
    @Column(name = "DONE", nullable = true, insertable = true, updatable = true)
    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Basic
    @Column(name = "ACTUAL_TIME", nullable = false, insertable = true, updatable = true)
    public Integer getActualTime() {
        return actualTime;
    }

    public void setActualTime(Integer actualTime) {
        this.actualTime = actualTime;
    }

    @Basic
    @Column(name = "ACTUAL_MONEY", nullable = false, insertable = true, updatable = true)
    public Integer getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(Integer actualMoney) {
        this.actualMoney = actualMoney;
    }

    @Override
    public String getName() {
        return id.toString();
    }

    @Override
    public void setIsDelete(Boolean aBoolean) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Work work = (Work) o;

        if (id != work.id) return false;
        if (ownerAutoId != work.ownerAutoId) return false;
        if (workTypeId != work.workTypeId) return false;
        if (actualTime != work.actualTime) return false;
        if (actualMoney != work.actualMoney) return false;
        if (startWorkDate != null ? !startWorkDate.equals(work.startWorkDate) : work.startWorkDate != null) return false;
        if (liftId != null ? !liftId.equals(work.liftId) : work.liftId != null) return false;
        if (masterId != null ? !masterId.equals(work.masterId) : work.masterId != null) return false;
        if (done != null ? !done.equals(work.done) : work.done != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (startWorkDate != null ? startWorkDate.hashCode() : 0);
        result = 31 * result + ownerAutoId;
        result = 31 * result + workTypeId;
        result = 31 * result + (liftId != null ? liftId.hashCode() : 0);
        result = 31 * result + (masterId != null ? masterId.hashCode() : 0);
        result = 31 * result + (done != null ? done.hashCode() : 0);
        result = 31 * result + actualTime;
        result = 31 * result + actualMoney;
        return result;
    }
}
