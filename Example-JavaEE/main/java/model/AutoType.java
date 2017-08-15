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
@Table(name = "AUTO_TYPE", catalog = "kontur44_AutoService")
public class AutoType extends BaseEntity {

    private Integer id;

    private String name;

    private Boolean isDelete;


    private Set<AutoModel> autoModels = new HashSet<AutoModel>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AUTO_TYPE_ID", unique = true, nullable = false, insertable = true, updatable = true)
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer autoTypeId) {
        this.id = autoTypeId;
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

    @OneToMany(mappedBy = "autoType")
    public Set<AutoModel> getAutoModels() {
        return autoModels;
    }

    public void setAutoModels(Set<AutoModel> autoModels) {
        this.autoModels = autoModels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoType autoType = (AutoType) o;

        if (id != autoType.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result;
        return result;
    }
}
