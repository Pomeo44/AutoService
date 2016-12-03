package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "WORK_TYPE", schema = "", catalog = "kontur44_AutoService")
public class WorkType {
    private int workTypeId;
    private String name;

    private Set<Price> prices = new HashSet<Price>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "WORK_TYPE_ID", unique = true, nullable = false, insertable = true, updatable = true)
    public int getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(int workTypeId) {
        this.workTypeId = workTypeId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "workType")
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

        if (workTypeId != workType.workTypeId) return false;
        if (name != null ? !name.equals(workType.name) : workType.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workTypeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
