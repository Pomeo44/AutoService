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
@Table(name = "WORK_TYPE")
public class WorkType extends BaseEntity {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String name;
    @JsonProperty
    private Boolean isDelete;

    @JsonIgnore
    private Set<Price> prices = new HashSet<Price>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "WORK_TYPE_ID", unique = true, nullable = false)
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer workTypeId) {
        this.id = workTypeId;
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

    @OneToMany(mappedBy = "workType", fetch = FetchType.LAZY)
    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkType workType = (WorkType) o;

        if (id != workType.id) return false;
        if (name != null ? !name.equals(workType.name) : workType.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
