package model;

import javax.persistence.*;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "PRICE")
public class Price extends BaseEntity {
    private Integer id;
    private Integer time;
    private Integer money;
    private Boolean isDelete;

    private AutoType autoType;
    private WorkType workType;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "PRICE_ID", unique = true, nullable = false)
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer priceId) {
        this.id = priceId;
    }

    @Basic
    @Column(name = "TIME", nullable = false)
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Basic
    @Column(name = "MONEY", nullable = false)
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Basic
    @Column(name = "IS_DELETE", nullable = false)
    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }


    @ManyToOne
    @JoinColumn(name = "AUTO_TYPE_ID", nullable = false)
    public AutoType getAutoType() {
        return autoType;
    }

    public void setAutoType(AutoType autoTypeId) {
        this.autoType = autoTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "WORK_TYPE_ID", nullable = false)
    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workTypeId) {
        this.workType = workTypeId;
    }

//    @Override
//    public String getName() {
//        return autoType.getName() + workType.getName();
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (id != price.id) return false;
        if (time != price.time) return false;
        if (money != price.money) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id : 0;
        result = 31 * result + time;
        result = 31 * result + money;
        return result;
    }
}
