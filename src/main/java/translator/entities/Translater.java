package translator.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "translater")
public class Translater {

    @Id
    @Column(name = "translater_id", nullable = false)
    private Long translater_id;

    public Long getTranslater_id() {
        return translater_id;
    }

    public void setTranslater_id(Long translater_id) {
        this.translater_id = translater_id;
    }


    @ManyToOne
    @JoinColumn(name = "translater_word_id")
    private Translater_words translater_word_id;


    @ManyToOne
    @JoinColumn(name = "another_word_id")
    private Another_words another_word_id;

    public Translater_words getTranslater_word_id() {
        return translater_word_id;
    }

    public void setTranslater_word_id(Translater_words translater_word_id) {
        this.translater_word_id = translater_word_id;
    }

    public Another_words getAnother_word_id() {
        return another_word_id;
    }

    public void setAnother_word_id(Another_words another_word_id) {
        this.another_word_id = another_word_id;
    }

    @ManyToOne
    @JoinColumn(name = "rule")
    private Translater_rules rule;

    public Translater_rules getRule() {
        return rule;
    }

    public void setRule(Translater_rules rule) {
        this.rule = rule;
    }

}
