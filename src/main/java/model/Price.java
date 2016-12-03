package model;

import javax.persistence.*;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "PRICE", schema = "", catalog = "kontur44_AutoService")
public class Price {
    private int priceId;
    private int time;
    private int money;

    private AutoType autoType;
    private WorkType workType;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "PRICE_ID", unique = true, nullable = false, insertable = true, updatable = true)
    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    @Basic
    @Column(name = "TIME", nullable = false, insertable = true, updatable = true)
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Basic
    @Column(name = "MONEY", nullable = false, insertable = true, updatable = true)
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    @ManyToOne
    @JoinColumn(name = "AUTO_TYPE_ID")
    public AutoType getAutoType() {
        return autoType;
    }

    public void setAutoType(AutoType autoTypeId) {
        this.autoType = autoTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "WORK_TYPE_ID")
    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workTypeId) {
        this.workType = workTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (priceId != price.priceId) return false;
        if (time != price.time) return false;
        if (money != price.money) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = priceId;
        result = 31 * result + time;
        result = 31 * result + money;
        return result;
    }
}
