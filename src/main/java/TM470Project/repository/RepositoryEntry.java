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
     * @param entry an entry to be persisted
     * @return an empty optional instance
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
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * @param entry an entry to be removed
     * @return an empty optional instance
     */
    public Optional<Entry> remove(Entry entry){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Entry.class, entry.getId());
            entityManager.remove(entry);
            entityManager.getTransaction().commit();
            return Optional.of(entry);
        }
        catch(Exception e){
            //print error message
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * @param id an id to query
     * @return an entry with the associated id or nothing
     */
    public Optional<Entry> findById(Integer id) {
        Entry entry = entityManager.find(Entry.class, id);
        return entry != null ? Optional.of(entry) : Optional.empty();
    }

    /**
     * @return all entry objects in the database
     */
    public List<Entry> findAll() {
        return entityManager.createQuery("from Entry").getResultList();
    }

    /**
     * @param date a date to query
     * @return entries with the associated date
     */
    public Optional<Entry> findByDate(LocalDate date) {
        Entry entry = entityManager.createQuery("SELECT b FROM Entry b WHERE b.date = :date", Entry.class)
                .setParameter("name", date)
                .getSingleResult();
        return entry != null ? Optional.of(entry) : Optional.empty();
    }
}
