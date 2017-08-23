package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pomeo on 18.10.2016.
 */
@Entity
@Table(name = "MASTER")
@NamedQuery(name = "Master.getAll", query = "SELECT a from Master a")
public class Master extends BaseEntity {
    private Integer id;
    private String name;
    private Boolean isDelete;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "MASTER_ID", unique = true, nullable = false)
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer masterId) {
        this.id = masterId;
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

        Master master = (Master) o;

        if (id != master.id) return false;
        if (name != null ? !name.equals(master.name) : master.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
