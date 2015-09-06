package momotar.simple.crud.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Enwords implements Serializable {

    @Id
    @NotNull
    private String word;
    private String meaning;
    private String example;
    private String translate;

    public Enwords() {
    }

    public Enwords(String word, String meaning, String example, String translate) {
        this.word = word;
        this.meaning = meaning;
        this.example = example;
        this.translate = translate;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
    
    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }
}
