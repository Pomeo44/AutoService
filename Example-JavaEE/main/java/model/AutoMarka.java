package model;

import javax.persistence.*;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "AUTO_MARKA")
@NamedQuery(name = "AutoMarka.getAll", query = "SELECT a from AutoMarka a")
public class AutoMarka extends BaseEntity {
    private Integer id;
    private String name;
    private Boolean isDelete;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AUTO_MARKA_ID", unique = true, nullable = false)
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer autoMarkaId) {
        this.id = autoMarkaId;
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

        AutoMarka autoMarka = (AutoMarka) o;

        if (id != autoMarka.id) return false;
        if (name != null ? !name.equals(autoMarka.name) : autoMarka.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
