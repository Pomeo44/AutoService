package model;

import javax.persistence.*;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "OWNER_AUTO")
@NamedQuery(name = "Entity.getAll", query = "SELECT a from OwnerAuto a")
public class OwnerAuto extends BaseEntity {
    private Integer id;
    private String name;
    private String year;
    private String gosNumber;
    private Boolean isDelete;

    private AutoModel autoModel;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "OWNER_AUTO_ID", unique = true, nullable = false)
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer ownerAutoId) {
        this.id = ownerAutoId;
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

    @ManyToOne
    @JoinColumn(name = "AUTO_MODEL_ID", nullable = false)
    public AutoModel getAutoModel() {
        return autoModel;
    }

    public void setAutoModel(AutoModel autoModel) {
        this.autoModel = autoModel;
    }

    @Basic
    @Column(name = "YEAR", length = 4)
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Basic
    @Column(name = "GOS_NUMBER", nullable = false, length = 9)
    public String getGosNumber() {
        return gosNumber;
    }

    public void setGosNumber(String gosNumber) {
        this.gosNumber = gosNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnerAuto ownerAuto = (OwnerAuto) o;

        if (id != ownerAuto.id) return false;
        if (name != null ? !name.equals(ownerAuto.name) : ownerAuto.name != null) return false;
        if (year != null ? !year.equals(ownerAuto.year) : ownerAuto.year != null) return false;
        if (gosNumber != null ? !gosNumber.equals(ownerAuto.gosNumber) : ownerAuto.gosNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (gosNumber != null ? gosNumber.hashCode() : 0);
        return result;
    }
}
