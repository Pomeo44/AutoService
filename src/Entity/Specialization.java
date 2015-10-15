package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by aantipin on 15/10/2015.
 */
@Entity
@Table(name = "SPECIALIZATION")
public class Specialization implements Serializable{

    @Id
    @Column(name = "SPECIALIZATION_ID")
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

    private Set<Master> masters;

    public Set<Master> getMasters() {
        return masters;
    }

    public void setMasters(Set<Master> masters) {
        this.masters = masters;
    }
}
