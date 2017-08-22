package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "WORK")
@NamedQuery(name = "Entity.getAll", query = "SELECT a from Work a")
public class Work extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "WORK_ID", unique = true, nullable = false)
    private Integer id;

    @Basic
    @Column(name = "START_WORK_DATE", nullable = false)
    private Date startWorkDate;

    @Basic
    @Column(name = "END_WORK_DATE", nullable = false)
    private Date endWorkDate;

    @ManyToOne
    @JoinColumn(name = "OWNER_AUTO_ID", nullable = false)
    private OwnerAuto ownerAuto;

    @ManyToOne
    @JoinColumn(name = "WORK_TYPE_ID", nullable = false)
    private WorkType workType;

    @ManyToOne
    @JoinColumn(name = "LIFT_ID")
    private Lift lift;

    @ManyToOne
    @JoinColumn(name = "MASTER_ID", nullable = false)
    private Master master;

    @Basic
    @Column(name = "DONE", nullable = false)
    private Boolean done;

    @Basic
    @Column(name = "ACTUAL_TIME", nullable = false)
    private Integer actualTime;

    @Basic
    @Column(name = "ACTUAL_MONEY", nullable = false)
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

    public OwnerAuto getOwnerAuto() {
        return ownerAuto;
    }
    public void setOwnerAuto(OwnerAuto ownerAuto) {
        this.ownerAuto = ownerAuto;
    }

    public WorkType getWorkType() {
        return workType;
    }
    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }

    public Lift getLift() {
        return lift;
    }
    public void setLift(Lift lift) {
        this.lift = lift;
    }

    public Master getMaster() {
        return master;
    }
    public void setMaster(Master master) {
        this.master = master;
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
        if (actualTime != work.actualTime) return false;
        if (actualMoney != work.actualMoney) return false;
        if (startWorkDate != null ? !startWorkDate.equals(work.startWorkDate) : work.startWorkDate != null) return false;
        if (workType != null ? !workType.equals(work.workType) : work.workType != null) return false;
        if (lift != null ? !lift.equals(work.lift) : work.lift != null) return false;
        if (master != null ? !master.equals(work.master) : work.master != null) return false;
        if (done != null ? !done.equals(work.done) : work.done != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id : 0;
        result = 31 * result + (startWorkDate != null ? startWorkDate.hashCode() : 0);
        result = 31 * result + (workType != null ? workType.hashCode() : 0);
        result = 31 * result + (lift != null ? lift.hashCode() : 0);
        result = 31 * result + (master != null ? master.hashCode() : 0);
        result = 31 * result + (done != null ? done.hashCode() : 0);
        result = 31 * result + actualTime;
        result = 31 * result + actualMoney;
        return result;
    }
}
