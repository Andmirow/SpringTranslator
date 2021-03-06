package translator.entities.tables;

import jakarta.persistence.*;


import java.util.Collection;


@Entity
@Table(name = "users")
public class Users {

    public Users(){}

    public Users(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "users_roles",
//    joinColumns = @JoinColumn(name = "user_id"),
//    inverseJoinColumns =  @JoinColumn(name = "rule_id"))
//    private Collection<Role> roles;
}
