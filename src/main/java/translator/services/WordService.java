package translator.services;

import translator.entities.tables.Translater;
import translator.entities.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    private WordRepository wordRepository;

    @Autowired
    public void setWordRepository(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }


    public List<Translater> getAllWords(){
        return wordRepository.findAll();
    }


}
