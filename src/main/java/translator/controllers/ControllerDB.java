package translator.controllers;


import com.MMTR.readers.db_reader.ConnectDB;
import com.MMTR.readers.db_reader.DbReader;
import com.MMTR.readers.db_reader.SettingDb;
import com.MMTR.servis.TypeLanguage;
import com.MMTR.servis.UserDAO;
import translator.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import translator.entities.tables.Translater;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerDB {

    private WordRepository wordRepository;

    private UsersRepository usersRepository;


    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Autowired
    public void setWordRepository(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    UserDAO userDAO;

    @GetMapping("/start")
    public String showTest() {
        return "choiseLanguageType";
    }







    @PostMapping("/backToStart")
    public String backToStart() {
        return "redirect:/start";
    }

    @PostMapping("/backToTranslate")
    public String backToTranslate() {
        return "redirect:/translator";
    }

    @PostMapping("/start")
    public String findTest(@RequestParam(value = "Type") String type, @RequestParam(value = "mask") String mask) {
        SettingDb settingDb;
        if (type.equals(TypeLanguage.english.name())){
            settingDb = new SettingDb("flyway.english_words","english_word","flyway.russian_words","russian_word","flyway.english_transtator","english_id","russian_id");
        }else{
            settingDb = new SettingDb("flyway.english_words","english_word","flyway.numeric_words","numeric_word","flyway.numeric_transtator","english_id","numeric_id");
        }
        ConnectDB connectDB = new ConnectDB("postgres","1120697");
        DbReader dbReader = new DbReader(settingDb,connectDB);
        if (mask.equals("")){
            userDAO = new UserDAO(dbReader,mask,connectDB);
        }else
            userDAO = new UserDAO(dbReader,connectDB);
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


    @PostMapping("/find")
    public String find(Model model,@RequestParam(value = "word") String word) {
        model.addAttribute("words", userDAO.find(word));
        return "select";
    }

    @PostMapping("/deleteWord")
    public String delete() {
        return "delete-form";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(Model model,@RequestParam(value = "word") String word) {
        boolean res = userDAO.delite(word);
        if (res){
            return "слово успешно удалено";
        }else
            return "не удалось удалить слово";
    }



    @PostMapping("/selectAll")
    public String selectAll(Model model) {
        List<Translater> list = wordRepository.findAll();
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Translater word: list) {
            sb.append(word.getAnother_word_id().getAnother_word());
            sb.append(" - ");
            sb.append(word.getTranslater_word_id().getTranslater_word());
            words.add(sb.toString());
            sb.delete(0, sb.length());
        }
        model.addAttribute("words", words);

       // model.addAttribute("words", userDAO.selectAll());
        return "select";
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
        System.out.println(userDAO.Add(word,translate));
        return "redirect:/translator";
    }

}
