package translator.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import translator.entities.tables.Another_words;
import translator.entities.tables.Translater;
import translator.entities.tables.Translater_rules;
import translator.entities.tables.Translater_words;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Translater, Long> {

    List<Translater> findByRule(Translater_rules rule);

    List<Translater> findByTranslaterWordIdAndRule(Translater_words word,Translater_rules rule);

    List<Translater> findByAnotherWordIdAndRule(Another_words word,Translater_rules rule);

    List<Translater> findByAnotherWordIdAndTranslaterWordIdAndRule(Another_words anotherWords,Translater_words translaterWords,Translater_rules rule);



}


