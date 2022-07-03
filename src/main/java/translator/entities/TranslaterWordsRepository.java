package translator.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import translator.entities.tables.Translater_words;

public interface TranslaterWordsRepository extends JpaRepository<Translater_words, Long> {

    Translater_words findByTranslaterWord(String word);
}
