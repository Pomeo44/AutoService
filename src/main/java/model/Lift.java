package model;

import javax.persistence.*;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "LIFT", schema = "", catalog = "kontur44_AutoService")
public class Lift {
    private int liftId;
    private int number;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "LIFT_ID", unique = true, nullable = false, insertable = true, updatable = true)
    public int getLiftId() {
        return liftId;
    }

    public void setLiftId(int liftId) {
        this.liftId = liftId;
    }

    @Basic
    @Column(name = "NUMBER", nullable = false, insertable = true, updatable = true)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lift lift = (Lift) o;

        if (liftId != lift.liftId) return false;
        if (number != lift.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = liftId;
        result = 31 * result + number;
        return result;
    }
}
