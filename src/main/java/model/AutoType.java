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
@Table(name = "AUTO_TYPE", schema = "", catalog = "kontur44_AutoService")
public class AutoType extends BaseEntity {
    @JsonProperty("id")
    private int autoTypeId;
    @JsonProperty
    private String name;

    @JsonIgnore
    private Set<AutoModel> autoModels = new HashSet<AutoModel>();
    @JsonIgnore
    private Set<Price> prices = new HashSet<Price>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AUTO_TYPE_ID", unique = true, nullable = false, insertable = true, updatable = true)
    public int getAutoTypeId() {
        return autoTypeId;
    }

    public void setAutoTypeId(int autoTypeId) {
        this.autoTypeId = autoTypeId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "autoType")
    public Set<AutoModel> getAutoModels() {
        return autoModels;
    }

    public void setAutoModels(Set<AutoModel> autoModels) {
        this.autoModels = autoModels;
    }

    @OneToMany(mappedBy = "autoType")
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

        AutoType autoType = (AutoType) o;

        if (autoTypeId != autoType.autoTypeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autoTypeId;
        result = 31 * result;
        return result;
    }
}
