package org.pomeo44.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "AUTO_MARKA")
public class AutoMarka extends BaseEntity {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String name;
    @JsonProperty
    private Boolean isDelete;

    @JsonIgnore
    private Set<AutoModel> autoModels = new HashSet<AutoModel>();

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

    @OneToMany(mappedBy = "autoMarka", fetch = FetchType.LAZY)
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

        AutoMarka autoMarka = (AutoMarka) o;

        if (id != autoMarka.id) return false;
        if (name != null ? !name.equals(autoMarka.name) : autoMarka.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
