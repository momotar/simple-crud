package momotar.simple.crud.cdis;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import momotar.simple.crud.ejbs.CrudDb;
import momotar.simple.crud.entities.Enwords;

/**
 *
 * @author Natsuki
 */
@Named(value = "backingBean")
@ViewScoped
public class BackingBean implements Serializable {

    @NotNull
    private String word;
    private String meaning;
    private String example;
    private String translate;
    
    @EJB
    CrudDb db;
    
    public String create() {
        Enwords enwords = new Enwords(word, meaning, example, translate);
        try {
            db.create(enwords);
            clear();
        } catch (Exception e) {
            System.out.println(word + "登録エラー ■ " +e.getMessage());
        }
        return null;
    }
    
    public String edit(Enwords enwords) {
        word = enwords.getWord();
        meaning = enwords.getMeaning();
        example = enwords.getExample();
        translate = enwords.getTranslate();
        return null;
    }
    
    public String update() {
        System.out.println("update -> " + word + "::" + meaning + "::" + example + "::" + translate);
        Enwords enwords = new Enwords(word, meaning, example, translate);
        try {
            db.update(enwords);
            clear();
        } catch (Exception e) {
            System.out.println(word + "更新エラー ■ " +e.getMessage());
        }
        return null;
    }
    
    public String delete(Enwords enwords) {
        db.delete(enwords);
        return null;
    }
    
    public String find() {
        Enwords m = db.find(word);
        if (m != null) {
            this.word = m.getWord();
            this.meaning = m.getMeaning();
            this.example = m.getExample();
            this.translate = m.getTranslate();
        }
        return null;
    }
    
    public List<Enwords> getAll() {
        return db.getAll();
    }
    
    public void clear() {
        word = null;
        meaning = null;
        example = null;
        translate = null;
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
