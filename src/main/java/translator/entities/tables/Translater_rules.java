package translator.entities.tables;

import jakarta.persistence.*;

@Entity
@Table(name = "translater_rules")
public class Translater_rules {

    @Id
    @GeneratedValue
    @Column(name = "rules_id")
    private Long rules_id;

    public Long getRules_id() {
        return rules_id;
    }

    public void setRules_id(Long rules_id) {
        this.rules_id = rules_id;
    }


    @Column(name = "translater_title")
    private String translater_title;

    public String getTranslater_title() {
        return translater_title;
    }

    public void setTranslater_title(String translater_title) {
        this.translater_title = translater_title;
    }



    @Column(name = "translater_rule")
    private String translater_rule;

    public String getTranslater_rule() {
        return translater_rule;
    }

    public void setTranslater_rule(String translater_rule) {
        this.translater_rule = translater_rule;
    }


    @ManyToOne
    @JoinColumn(name = "users")
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

//    @ManyToOne
//    @JoinColumn(name = "username")
//    private Users users;
//
//    public Users getUsers() {
//        return users;
//    }
//
//    public void setUsers(Users users) {
//        this.users = users;
//    }


}
