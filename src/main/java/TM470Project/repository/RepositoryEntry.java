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

    private final EntityManager entityManager;

    /**
     * @param entityManager the Entity Manager for Entry
     */
    public RepositoryEntry(EntityManager entityManager) {this.entityManager = entityManager;}

    /**
     * @param entry an entry to be persisted
     */
    public void save(Entry entry){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(entry);
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            //print error message
            e.printStackTrace();
        }
    }

    /**
     * @param entry an entry to be removed
     */
    public void remove(Entry entry){ //probably set to look for and remove by ID?
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Entry.class, entry.getId());
            entityManager.remove(entry);
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            //print error message
            e.printStackTrace();
        }
    }

    public void update(Entry entry, Entry newEntry){
        try {
            entityManager.getTransaction().begin();
            entityManager.find(Entry.class, entry.getId());
            entityManager.merge(entry);
            entry.setMetric(newEntry.getMetric());
            entry.setDate(newEntry.getDate().getYear(), newEntry.getDate().getMonthValue(), newEntry.getDate().getDayOfMonth());
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param id an id to query
     * @return an entry with the associated id or nothing
     */
    public Optional<Entry> findById(long id) {
        Entry entry = entityManager.find(Entry.class, id);
        return entry != null ? Optional.of(entry) : Optional.empty();
    }

    /**
     * @return all entry objects in the database
     */
    public List findAll() {
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
