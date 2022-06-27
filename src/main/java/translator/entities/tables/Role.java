package translator.entities.tables;

import jakarta.persistence.*;


@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "name")
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role() {}

    @Override
    public String toString(){
        return "Role{ id="+ getId() + ", name =" + getName() + "}" ;
    }


}



