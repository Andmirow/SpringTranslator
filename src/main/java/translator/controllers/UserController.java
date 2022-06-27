package translator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import translator.SettingTranslate;
import translator.entities.tables.Translater_rules;
import translator.entities.tables.Users;
import translator.entities.UsersRepository;
import translator.services.RulesService;
import translator.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private RulesService rulesService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRulesService(RulesService rulesService) {
        this.rulesService = rulesService;
    }


    @GetMapping
    public String choiseUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "choiseUser";
    }

    @PostMapping("/singIn")
    public String afterChoiseUser(Model model, @ModelAttribute(value = "user")Users user) {
        SettingTranslate.setUsers(user);
        List<Translater_rules> tr = rulesService.getUsersRule(user);

        model.addAttribute("translater_rules", tr);
        return "choiseRule";
    }

    @GetMapping("/choiseRule")
    public String choiseRuleTest(Model model) {
        model.addAttribute("translater_rules", rulesService.getAllRules());
        return "choiseRule";
    }



    @PostMapping("/createNewUser")
    public String createNewUser(@ModelAttribute(value = "users")Users users) {
        return "redirect:/translator";
    }

    @PostMapping("/back")
    public String back() {
        return "redirect:/user";
    }


//    @GetMapping("/choiseRule")
//    public String choiseRule(Model model) {
//        model.addAttribute("rules", rulesService.getUsersRule(SettingTranslate.getUsers()));
//        return "choiseRule";
//    }




}
