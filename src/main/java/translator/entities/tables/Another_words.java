package translator.entities.tables;


import jakarta.persistence.*;

@Entity
@Table(name = "another_words")
public class Another_words {

    public Another_words(){}

    public Another_words(String anotherWord) {
        this.anotherWord = anotherWord;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "another_word_id")
    private long another_word_id;

    public void setAnother_word_id(long another_word_id) {
        this.another_word_id = another_word_id;
    }

    public long getAnother_word_id() {
        return another_word_id;
    }

    @Column(name = "another_word")
    String anotherWord;


    public String getAnotherWord() {
        return anotherWord;
    }

    public void setAnother_word(String another_word) {
        this.anotherWord = another_word;
    }


}
