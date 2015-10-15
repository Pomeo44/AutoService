package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by aantipin on 15/10/2015.
 */
@Entity
@Table(name = "MASTER")
public class Master implements Serializable{

    @Id
    @Column(name = "MASTER_ID")
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "MASTER_SPECIALIZATION",  joinColumns = @JoinColumn(name = "MASTER_ID"), inverseJoinColumns = @JoinColumn(name = "SPECIALIZATION_ID"))
    private Set<Specialization> specializations;

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }
}
