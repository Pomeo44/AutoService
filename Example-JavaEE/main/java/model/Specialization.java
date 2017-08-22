package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "SPECIALIZATION")
@NamedQuery(name = "Entity.getAll", query = "SELECT a from Specialization a")
public class Specialization extends BaseEntity {
    private Integer id;
    private String name;
    private Boolean isDelete;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "SPECIALIZATION_ID", unique = true, nullable = false)
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer specializationId) {
        this.id = specializationId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "IS_DELETE", nullable = false)
    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialization that = (Specialization) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
