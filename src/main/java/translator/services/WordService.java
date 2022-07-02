package translator.services;

import translator.SettingTranslate;
import translator.entities.AnotherWordsRepository;
import translator.entities.TranslaterWordsRepository;
import translator.entities.tables.Another_words;
import translator.entities.tables.Translater;
import translator.entities.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import translator.entities.tables.Translater_rules;
import translator.entities.tables.Translater_words;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WordService {

    private WordRepository wordRepository;

    @Autowired
    public void setWordRepository(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }


    private TranslaterWordsRepository translaterWordsRepository;

    @Autowired
    public void setTranslaterWordsRepository(TranslaterWordsRepository translaterWordsRepository) {
        this.translaterWordsRepository = translaterWordsRepository;
    }

    private AnotherWordsRepository anotherWordsRepository;

    @Autowired
    public void setAnotherWordsRepository(AnotherWordsRepository anotherWordsRepository) {
        this.anotherWordsRepository = anotherWordsRepository;
    }

    public Translater_words addTranslateWord(String word){
        Translater_words translaterWords = translaterWordsRepository.findByTranslaterWord(word);
        if (translaterWords != null){
            return translaterWords;
        }
        return translaterWordsRepository.save(new Translater_words(word));
    }

    public Another_words addAnotherWord(String word){
        Another_words anotherWords = anotherWordsRepository.findByAnotherWord(word);
        if (anotherWords != null){
            return anotherWords;
        }
        if (checkRule(word)){
            return anotherWordsRepository.save(new Another_words(word));
        }
        return null;
    }

    private boolean checkRule(String Word){
        Pattern pattern = Pattern.compile(SettingTranslate.getSettingTranslate().getTranslater_rules().getTranslater_rule());
        Matcher matcher = pattern.matcher(Word);
        return matcher.matches();
    }

    public void addTranslater(Translater translater){
        wordRepository.save(translater);
    }



//    public Translater addTranslater(Translater_words translaterWords , Another_words anotherWords){
//        List<Translater> list = wordRepository.findByAnotherWordIdAndTranslaterWordIdAndRule(anotherWords,translaterWords,SettingTranslate.getSettingTranslate().getTranslater_rules());
//        return list.get(0);
//    }

    public List<Translater> getAllWords(){
        return wordRepository.findAll();
    }

    public List<Translater> getAllWordByRule(Translater_rules translater_rules){
        return wordRepository.findByRule(translater_rules);
    }

    public List<Translater> findWord(String word){
        Translater_words translater_words = translaterWordsRepository.findByTranslaterWord(word);
        if (translater_words != null){
            return wordRepository.findByTranslaterWordIdAndRule(translater_words, SettingTranslate.getSettingTranslate().getTranslater_rules());
        }else {
            return wordRepository.findByAnotherWordIdAndRule(anotherWordsRepository.findByAnotherWord(word), SettingTranslate.getSettingTranslate().getTranslater_rules());
        }
    }

    public void deleteWord(String word){
        List<Translater> list = findWord(word);
        for (Translater translater : list){
            deleteTranslater(translater);
        }
    }

    public void deleteTranslater(Translater translater){
        wordRepository.delete(translater);
    }






}
