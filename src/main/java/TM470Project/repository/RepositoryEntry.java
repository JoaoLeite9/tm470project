package TM470Project.repository;

import TM470Project.Entry;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Joao
 * v3 02/06/2023
 */

public class RepositoryEntry {

    private EntityManager entityManager;

    /**
     * @param entityManager
     */
    public RepositoryEntry(EntityManager entityManager) {this.entityManager = entityManager;}

    /**
     * @param entry
     * @return
     */
    public Optional<Entry> save(Entry entry){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(entry);
            entityManager.getTransaction().commit();
            return Optional.of(entry);
        }
        catch(Exception e){
            //print error message
        }
        return Optional.empty();
    }

    /**
     * @param id
     * @return
     */
    public Optional<Entry> findById(Integer id) {
        Entry entry = entityManager.find(Entry.class, id);
        return entry != null ? Optional.of(entry) : Optional.empty();
    }

    /**
     * @return
     */
    public List<Entry> findAll() {
        return entityManager.createQuery("from Entry").getResultList();
    }

    /**
     * @param date
     * @return
     */
    public Optional<Entry> findByDate(LocalDate date) {
        Entry entry = entityManager.createQuery("SELECT b FROM Entry b WHERE b.date = :date", Entry.class)
                .setParameter("name", date)
                .getSingleResult();
        return entry != null ? Optional.of(entry) : Optional.empty();
    }

    public Optional<Entry> findByNameNamedQuery(LocalDate date) {
        Entry entry = entityManager.createNamedQuery("Entry.findByDate", Entry.class)
                .setParameter("date", date)
                .getSingleResult();
        return entry != null ? Optional.of(entry) : Optional.empty();
    }
}
