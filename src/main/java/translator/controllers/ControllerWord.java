package translator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import translator.SettingTranslate;
import translator.entities.tables.Translater;
import translator.services.WordService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerWord {

    private WordService wordService;

    @Autowired
    public void setWordService(WordService wordService) {
        this.wordService = wordService;
    }

    @PostMapping("/selectAll")
    public String selectAll(Model model) {
        List<Translater> list;
        SettingTranslate settingTranslate = SettingTranslate.getSettingTranslate();
        if (settingTranslate.getTranslater_rules() != null){
            list = wordService.getAllWordByRule(settingTranslate.getTranslater_rules());
        }else{
            list = wordService.getAllWords();
        }
//        List<String> words = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        for (Translater word: list) {
//            sb.append(word.getAnother_word_id().getAnotherWord());
//            sb.append(" - ");
//            sb.append(word.getTranslater_word_id().getTranslater_word());
//            words.add(sb.toString());
//            sb.delete(0, sb.length());
//        }
        model.addAttribute("words", getListWord(list));
        return "select";
    }

    private List<String> getListWord(List<Translater> list){
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Translater word: list) {
            sb.append(word.getAnother_word_id().getAnotherWord());
            sb.append(" - ");
            sb.append(word.getTranslater_word_id().getTranslater_word());
            words.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return words;
    }

    @PostMapping("/find")
    public String find(Model model,@RequestParam(value = "word") String word) {
        model.addAttribute("words",  getListWord(wordService.findWord(word)));
        return "select";
    }

    @PostMapping("/delete")
    public String delete(Model model,@RequestParam(value = "word") String word) {
        wordService.deleteWord(word);
           return selectAll(model);
    }


}
