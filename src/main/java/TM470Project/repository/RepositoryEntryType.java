package TM470Project.repository;

import TM470Project.Entry;
import TM470Project.EntryType;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Joao
 * v3 02/06/2023
 */

public class RepositoryEntryType {

    private EntityManager entityManager;

    /**
     * @param entityManager entity manager
     */
    public RepositoryEntryType(EntityManager entityManager) {this.entityManager = entityManager;}

    /**
     * @param entryType the entry type to be persisted
     * @return an Optional containing the persisted entry type
     */
    public Optional<EntryType> save(EntryType entryType){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(entryType);
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            //print error message
            e.printStackTrace();
        }
        return Optional.of(entryType);
    }

    /**
     * @param entryType an entry type to be removed
     */
    public void remove(EntryType entryType){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(entryType);
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            //print error message
            e.printStackTrace();
        }
    }

    /**
     * @param id the ID of the EntryType being searched
     * @return a list of all EntryTypes objects that meet the query
     */
    public Optional<EntryType> findById(long id) {
        EntryType entryType = entityManager.find(EntryType.class, id);
        return entryType != null ? Optional.of(entryType) : Optional.empty();
    }

    /**
     * @return all entry type objects in the database
     */
    public Optional<List<EntryType>> findAll() {
        List<EntryType> entryTypes =  entityManager.createNamedQuery("EntryType.findAll", EntryType.class).getResultList();
        return (entryTypes != null && entryTypes.size() != 0) ? Optional.of(entryTypes) : Optional.empty();
    }

    /**
     * @param name the name to search for
     * @return a list of EntryType objects that meet the query
     */
    public Optional<EntryType> findByName(String name) {
        EntryType entryType = entityManager.createNamedQuery("EntryType.findByName", EntryType.class)
            .setParameter("name", name).getSingleResult();
        return entryType != null ? Optional.of(entryType) : Optional.empty();
    }

    public void deleteAllEntryTypes(){
        try{
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM EntryType").executeUpdate();
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            //print error message
            e.printStackTrace();
        }
    }
}
