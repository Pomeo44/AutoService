package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pomeo on 18.10.2016.
 */
@Entity
@Table(name = "MASTER")
public class Master extends BaseEntity {
    private int masterId;
    private String name;
    private Set<Specialization> specializations = new HashSet<Specialization>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "MASTER_ID", unique = true, nullable = false, insertable = true, updatable = true)
    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name = "MASTER_SPECIALIZATION",
            joinColumns = @JoinColumn(name = "MASTER_ID", referencedColumnName = "MASTER_ID"),
            inverseJoinColumns = @JoinColumn(name = "SPECIALIZATION_ID", referencedColumnName = "SPECIALIZATION_ID")
    )
    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Master master = (Master) o;

        if (masterId != master.masterId) return false;
        if (name != null ? !name.equals(master.name) : master.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = masterId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
