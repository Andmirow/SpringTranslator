package translator;


import translator.entities.tables.Translater_rules;
import translator.entities.tables.Users;

public class SettingTranslate {

    private static Users users;

    public static Users getUsers() {
        return users;
    }

    public static void setUsers(Users users) {
        users = users;
    }

    public static Translater_rules getTranslater_rules() {
        return translater_rules;
    }

    public static void setTranslater_rules(Translater_rules translater_rules) {
        translater_rules = translater_rules;
    }

    private static Translater_rules translater_rules;
}
