package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "SPECIALIZATION", schema = "", catalog = "kontur44_AutoService")
public class Specialization extends BaseEntity {
    private int specializationId;
    private String name;
    private Set<Master> masters = new HashSet<Master>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "SPECIALIZATION_ID", unique = true, nullable = false, insertable = true, updatable = true)
    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "specializations")
    public Set<Master> getMasters() {
        return masters;
    }

    public void setMasters(Set<Master> masters) {
        this.masters = masters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialization that = (Specialization) o;

        if (specializationId != that.specializationId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = specializationId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
