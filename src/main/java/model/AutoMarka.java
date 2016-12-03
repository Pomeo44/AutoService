package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "AUTO_MARKA", schema = "", catalog = "kontur44_AutoService")
public class AutoMarka extends BaseEntity {
    private int autoMarkaId;
    private String name;

    private Set<AutoModel> autoModels = new HashSet<AutoModel>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AUTO_MARKA_ID", unique = true, nullable = false, insertable = true, updatable = true)
    public int getAutoMarkaId() {
        return autoMarkaId;
    }

    public void setAutoMarkaId(int autoMarkaId) {
        this.autoMarkaId = autoMarkaId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @OneToMany(mappedBy = "autoMarka")
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

        if (autoMarkaId != autoMarka.autoMarkaId) return false;
        if (name != null ? !name.equals(autoMarka.name) : autoMarka.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autoMarkaId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
