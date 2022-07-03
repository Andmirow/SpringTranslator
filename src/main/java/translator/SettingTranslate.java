package translator;


import translator.entities.tables.Translater_rules;
import translator.entities.tables.Users;

public class SettingTranslate {

    private static SettingTranslate instance;

    private SettingTranslate(){}

    public static SettingTranslate getSettingTranslate(){
        if (instance == null){
            instance = new SettingTranslate();
        }
        return instance;
    }

    private Users users;

    private Translater_rules translater_rules;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Translater_rules getTranslater_rules() {
        return translater_rules;
    }

    public void setTranslater_rules(Translater_rules translater_rules) {
        this.translater_rules = translater_rules;
    }
}
