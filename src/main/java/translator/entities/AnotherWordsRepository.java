package translator.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import translator.entities.tables.Another_words;

public interface AnotherWordsRepository extends JpaRepository<Another_words, Long> {

    Another_words findByAnotherWord(String word);
}
