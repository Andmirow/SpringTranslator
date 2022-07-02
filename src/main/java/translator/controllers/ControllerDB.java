package translator.controllers;


import com.MMTR.readers.db_reader.ConnectDB;
import com.MMTR.readers.db_reader.DbReader;
import com.MMTR.readers.db_reader.SettingDb;
import com.MMTR.servis.TypeLanguage;
import com.MMTR.servis.UserDAO;
import org.dom4j.rule.Mode;
import translator.SettingTranslate;
import translator.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import translator.entities.tables.Translater;
import translator.entities.tables.Translater_rules;
import translator.services.RulesService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerDB {

    private RulesService rulesService;

    @Autowired
    public void setRulesService(RulesService rulesService) {
        this.rulesService = rulesService;
    }

    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    private WordRepository wordRepository;

    @Autowired
    public void setWordRepository(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    UserDAO userDAO;


    @PostMapping("/backToRule")
    public String backToStart(Model model) {
        List<Translater_rules> tr = rulesService.getUsersRule(SettingTranslate.getSettingTranslate().getUsers());
        model.addAttribute("translater_rules", tr);
        return "redirect:user/choiseRule";
    }

    @PostMapping("/backToTranslate")
    public String backToTranslate() {
        return "redirect:/translator";
    }


    @GetMapping("/translator")
    public String getAormTranslator() {
        return "translator";
    }

    @PostMapping("/findWord")
    public String findWord() {
        return "find-form";
    }

    @PostMapping("/deleteWord")
    public String delete() {
        return "delete-form";
    }








    @PostMapping("/addWord")
    public String addWord() {
        System.out.println("AddForm");
        return "redirect:/AddForm";
    }


    @GetMapping("/AddForm")
    public String showForm() {
        return "add-form";
    }

    @PostMapping("/AddForm")
    public String saveForm(@RequestParam(value = "word") String word, @RequestParam(value = "translate") String translate) {
        //System.out.println(userDAO.Add(word,translate));
        return "redirect:/translator";
    }

}
