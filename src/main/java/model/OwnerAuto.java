package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "OWNER_AUTO", schema = "", catalog = "kontur44_AutoService")
public class OwnerAuto extends BaseEntity {
    @JsonProperty("id")
    private int ownerAutoId;
    @JsonProperty
    private String name;
    @JsonProperty
    private String year;
    @JsonProperty
    private String gosNumber;
    @JsonProperty
    private Boolean isDelete;

    @JsonIgnore
    private AutoModel autoModel;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "OWNER_AUTO_ID", unique = true, nullable = false, insertable = true, updatable = true)
    public int getOwnerAutoId() {
        return ownerAutoId;
    }

    public void setOwnerAutoId(int ownerAutoId) {
        this.ownerAutoId = ownerAutoId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "IS_DELETE", nullable = true, insertable = true, updatable = true)
    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @ManyToOne
    @JoinColumn(name = "AUTO_MODEL_ID")
    public AutoModel getAutoModel() {
        return autoModel;
    }

    public void setAutoModel(AutoModel autoModel) {
        this.autoModel = autoModel;
    }

    @Basic
    @Column(name = "YEAR", nullable = false, insertable = true, updatable = true, length = 4)
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Basic
    @Column(name = "GOS_NUMBER", nullable = false, insertable = true, updatable = true, length = 9)
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

        if (ownerAutoId != ownerAuto.ownerAutoId) return false;
        if (name != null ? !name.equals(ownerAuto.name) : ownerAuto.name != null) return false;
        if (year != null ? !year.equals(ownerAuto.year) : ownerAuto.year != null) return false;
        if (gosNumber != null ? !gosNumber.equals(ownerAuto.gosNumber) : ownerAuto.gosNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ownerAutoId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (gosNumber != null ? gosNumber.hashCode() : 0);
        return result;
    }
}
