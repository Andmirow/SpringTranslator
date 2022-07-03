package translator.entities.tables;

import jakarta.persistence.*;


@Entity
@Table(name = "translater")
public class Translater {

    public Translater(){}

    public Translater(Translater_words translaterWordId, Another_words anotherWordId, Translater_rules rule) {
        this.translaterWordId = translaterWordId;
        this.anotherWordId = anotherWordId;
        this.rule = rule;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Translater_words translaterWordId;


    @ManyToOne
    @JoinColumn(name = "another_word_id")
    private Another_words anotherWordId;

    public Translater_words getTranslater_word_id() {
        return translaterWordId;
    }

    public void setTranslater_word_id(Translater_words translater_word_id) {
        this.translaterWordId = translater_word_id;
    }

    public Another_words getAnother_word_id() {
        return anotherWordId;
    }

    public void setAnother_word_id(Another_words another_word_id) {
        this.anotherWordId = another_word_id;
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
