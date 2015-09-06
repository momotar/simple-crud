package momotar.simple.crud.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import momotar.simple.crud.entities.Enwords;

/**
 *
 * @author Natsuki
 */
@Stateless
public class CrudDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create(Enwords enwords) {
        em.persist(enwords);
    }
    
    public void update(Enwords enwords) {
        em.merge(enwords);
    }
    
    public Enwords find(String key) {
        return em.find(Enwords.class, key);
    }
    
    public void delete(Enwords enwords) {
        em.remove(em.merge(enwords));
    }
    
    public List<Enwords> getAll() {
        return em.createQuery("SELECT c FROM Enwords c").getResultList();
    }
}
