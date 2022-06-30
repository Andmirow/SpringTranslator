package translator.entities.tables;

import jakarta.persistence.*;

@Entity
@Table(name = "translater_words")
public class Translater_words {

    public Translater_words(){}

    public Translater_words(String translaterWord) {
        this.translaterWord = translaterWord;
    }

    @Id
    @GeneratedValue
    @Column(name = "translater_word_id", nullable = false)
    private long translater_word_id;

    public long getTranslater_word_id() {
        return translater_word_id;
    }

    public void setTranslater_word_id(long translater_word_id) {
        this.translater_word_id = translater_word_id;
    }

    public String getTranslater_word() {
        return translaterWord;
    }

    public void setTranslater_word(String translater_word) {
        this.translaterWord = translater_word;
    }

    @Column(name = "translater_word")
    private String translaterWord;



}
