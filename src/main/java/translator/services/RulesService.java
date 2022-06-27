package translator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import translator.entities.RulesRepository;
import translator.entities.tables.Translater_rules;
import translator.entities.tables.Users;

import java.util.List;

@Service
public class RulesService {

    private RulesRepository rulesRepository;

    @Autowired
    public void setRulesRepository(RulesRepository rulesRepository) {
        this.rulesRepository = rulesRepository;
    }


    public List<Translater_rules> getUsersRule(Users users){
        return rulesRepository.findByUsers(users.getUsername());
    }

    public List<Translater_rules> getAllRules(){
        return rulesRepository.findAll();
    }

    public void deleteRule(Translater_rules translater_rules){
        rulesRepository.delete(translater_rules);
    }

    public void addRule(Translater_rules translater_rules){
        rulesRepository.save(translater_rules);
    }



}
