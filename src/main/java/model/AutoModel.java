package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "AUTO_MODEL", schema = "", catalog = "kontur44_AutoService")
public class AutoModel extends BaseEntity {
    private int autoModelId;
    private String name;

    private AutoMarka autoMarka;
    private AutoType autoType;
    private Set<OwnerAuto> ownerAutos = new HashSet<OwnerAuto>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AUTO_MODEL_ID", unique = true, nullable = false, insertable = true, updatable = true)
    public int getAutoModelId() {
        return autoModelId;
    }

    public void setAutoModelId(int autoModelId) {
        this.autoModelId = autoModelId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "AUTO_MARKA_ID")
    public AutoMarka getAutoMarka() {
        return autoMarka;
    }

    public void setAutoMarka(AutoMarka autoMarka) {
        this.autoMarka = autoMarka;
    }

    @ManyToOne
    @JoinColumn(name = "AUTO_TYPE_ID")
    public AutoType getAutoType() {
        return autoType;
    }

    public void setAutoType(AutoType autoType) {
        this.autoType = autoType;
    }

    @OneToMany(mappedBy = "autoModel")
    public Set<OwnerAuto> getOwnerAutos() {
        return ownerAutos;
    }

    public void setOwnerAutos(Set<OwnerAuto> ownerAutos) {
        this.ownerAutos = ownerAutos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoModel autoModel = (AutoModel) o;

        if (autoModelId != autoModel.autoModelId) return false;
        if (name != null ? !name.equals(autoModel.name) : autoModel.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autoModelId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " " + autoMarka.getName() + " " + autoType.getName();
    }
}
