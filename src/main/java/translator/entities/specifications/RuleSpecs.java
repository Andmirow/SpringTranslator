package translator.entities.specifications;

import org.springframework.data.jpa.domain.Specification;
import translator.entities.tables.Translater_rules;
import translator.entities.tables.Users;

public class RuleSpecs {
    public static Specification<Translater_rules> ruleByUsers(Users user){
        return null;// (Specification<Translater_rules>)
    }

}
