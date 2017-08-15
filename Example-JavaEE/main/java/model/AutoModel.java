package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "AUTO_MODEL", catalog = "kontur44_AutoService")
public class AutoModel extends BaseEntity {

    private Integer id;

    private String name;

    private Boolean isDelete;


    private AutoMarka autoMarka;

    private Integer autoMarkaId;

    private AutoType autoType;

    private Integer autoTypeId;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AUTO_MODEL_ID", unique = true, nullable = false, insertable = true, updatable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer autoModelId) {
        this.id = autoModelId;
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
    @Column(name = "IS_DELETE", nullable = true, insertable = false, updatable = false)
    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @ManyToOne
    @JoinColumn(name = "AUTO_MARKA_ID")
    public AutoMarka getAutoMarka() {
        return autoMarka;
    }

    public void setAutoMarka(AutoMarka autoMarka) {
        this.autoMarka = autoMarka;
    }

    @Basic
    @Column(name = "AUTO_MARKA_ID", nullable = false, insertable = false, updatable = false)
    public Integer getAutoMarkaId() {
        return autoMarkaId;
    }

    public void setAutoMarkaId(Integer autoMarkaId) {
        this.autoMarkaId = autoMarkaId;
    }

    @ManyToOne
    @JoinColumn(name = "AUTO_TYPE_ID")
    public AutoType getAutoType() {
        return autoType;
    }

    public void setAutoType(AutoType autoType) {
        this.autoType = autoType;
    }

    @Basic
    @Column(name = "AUTO_TYPE_ID", nullable = false, insertable = false, updatable = false)
    public Integer getAutoTypeId() {
        return autoTypeId;
    }

    public void setAutoTypeId(Integer autoTypeId) {
        this.autoTypeId = autoTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoModel autoModel = (AutoModel) o;

        if (id != autoModel.id) return false;
        if (name != null ? !name.equals(autoModel.name) : autoModel.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " " + autoMarka != null ? autoMarka.getName() : "" + " " + autoType != null ? autoType.getName() : "";
    }
}
