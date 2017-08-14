package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "WORK", schema = "", catalog = "kontur44_AutoService")
public class Work extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "WORK_ID", unique = true, nullable = false, insertable = true, updatable = true)
    @JsonProperty
    private Integer id;

    @Basic
    @Column(name = "START_WORK_DATE", nullable = false, insertable = true, updatable = true)
    @JsonProperty
    private Date startWorkDate;

    @Basic
    @Column(name = "END_WORK_DATE", nullable = false, insertable = true, updatable = true)
    @JsonProperty
    private Date endWorkDate;

    @Basic
    @Column(name = "ORDERS_ID", nullable = false, insertable = true, updatable = true)
    @JsonProperty
    private Integer ownerAutoId;

    @Basic
    @Column(name = "WORK_TYPE_ID", nullable = false, insertable = true, updatable = true)
    @JsonProperty
    private Integer workTypeId;

    @Basic
    @Column(name = "LIFT_ID", nullable = true, insertable = true, updatable = true)
    @JsonProperty
    private Integer liftId;

    @Basic
    @Column(name = "MASTER_ID", nullable = true, insertable = true, updatable = true)
    @JsonProperty
    private Integer masterId;

    @Basic
    @Column(name = "DONE", nullable = true, insertable = true, updatable = true)
    @JsonProperty
    private Boolean done;

    @Basic
    @Column(name = "ACTUAL_TIME", nullable = false, insertable = true, updatable = true)
    @JsonProperty
    private Integer actualTime;

    @Basic
    @Column(name = "ACTUAL_MONEY", nullable = false, insertable = true, updatable = true)
    @JsonProperty
    private Integer actualMoney;

    @Override
    public Integer getId() {
        return id;
    }
    public void setId(Integer workId) {
        this.id = workId;
    }

    public Date getStartWorkDate() {
        return startWorkDate;
    }
    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public Date getEndWorkDate() {
        return endWorkDate;
    }
    public void setEndWorkDate(Date endWorkDate) {
        this.endWorkDate = endWorkDate;
    }

    public Integer getOwnerAutoId() {
        return ownerAutoId;
    }
    public void setOwnerAutoId(Integer ordersId) {
        this.ownerAutoId = ordersId;
    }

    public Integer getWorkTypeId() {
        return workTypeId;
    }
    public void setWorkTypeId(Integer workTypeId) {
        this.workTypeId = workTypeId;
    }

    public Integer getLiftId() {
        return liftId;
    }
    public void setLiftId(Integer liftId) {
        this.liftId = liftId;
    }

    public Integer getMasterId() {
        return masterId;
    }
    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public Boolean getDone() {
        return done;
    }
    public void setDone(Boolean done) {
        this.done = done;
    }

    public Integer getActualTime() {
        return actualTime;
    }
    public void setActualTime(Integer actualTime) {
        this.actualTime = actualTime;
    }

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
