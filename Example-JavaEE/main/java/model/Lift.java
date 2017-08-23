package model;

import javax.persistence.*;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "LIFT")
@NamedQuery(name = "Lift.getAll", query = "SELECT a from Lift a")
public class Lift extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "LIFT_ID", unique = true, nullable = false)
    private Integer id;

    @Basic
    @Column(name = "NUMBER", nullable = false)
    private Integer number;

    @Basic
    @Column(name = "IS_DELETE", nullable = false)
    private Boolean isDelete;

    @Override
    public Integer getId() {
        return id;
    }
    public void setId(Integer liftId) {
        this.id = liftId;
    }


    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }


    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String getName() {
        return number.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lift lift = (Lift) o;

        if (id != lift.id) return false;
        if (number != lift.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id : 0;
        result = 31 * result + number;
        return result;
    }
}
