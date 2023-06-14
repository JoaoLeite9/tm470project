package TM470Project.repository;

import TM470Project.Entry;
import TM470Project.EntryType;

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
     * @param entry the entry to be persisted
     * @return an Optional containing the persisted entry
     */
    public Optional<Entry> save(Entry entry){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(entry);
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            //print error message
            e.printStackTrace();
        }
        return Optional.of(entry);
    }

    /**
     * @param entry an entry to be removed
     */
    public void remove(Entry entry){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(entry);
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            //print error message
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
    public Optional<List<Entry>> findAll() {
        List<Entry> entries =  entityManager.createNamedQuery("Entry.findAll", Entry.class).getResultList();
        return (entries != null && entries.size() != 0) ? Optional.of(entries) : Optional.empty();
    }

    /**
     * @param date a date to query
     * @return entries with the associated date
     */
    public Optional<Entry> findByDate(LocalDate date) {
        Entry entry = entityManager.createQuery("Entry.findByDate", Entry.class)
                .setParameter("name", date)
                .getSingleResult();
        return entry != null ? Optional.of(entry) : Optional.empty();
    }

    public Optional<List<Entry>> findByEntryType(EntryType aType){
        List<Entry> entries = entityManager.createQuery("Entry.findByEntryType", Entry.class).getResultList();
        return (entries != null && entries.size() != 0) ? Optional.of(entries) : Optional.empty();
    }


}
