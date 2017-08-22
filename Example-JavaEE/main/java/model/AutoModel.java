package model;

import javax.persistence.*;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Entity
@Table(name = "AUTO_MODEL")
@NamedQuery(name = "AutoModel.getAll", query = "SELECT a from AutoModel a")
public class AutoModel extends BaseEntity {

    private Integer id;
    private String name;
    private Boolean isDelete;
    private AutoMarka autoMarka;
    private AutoType autoType;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AUTO_MODEL_ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer autoModelId) {
        this.id = autoModelId;
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
    @JoinColumn(name = "AUTO_MARKA_ID", nullable = false)
    public AutoMarka getAutoMarka() {
        return autoMarka;
    }

    public void setAutoMarka(AutoMarka autoMarka) {
        this.autoMarka = autoMarka;
    }

    @ManyToOne
    @JoinColumn(name = "AUTO_TYPE_ID", nullable = false)
    public AutoType getAutoType() {
        return autoType;
    }

    public void setAutoType(AutoType autoType) {
        this.autoType = autoType;
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
        int result = id != null ? id : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " " + autoMarka != null ? autoMarka.getName() : "" + " " + autoType != null ? autoType.getName() : "";
    }
}
