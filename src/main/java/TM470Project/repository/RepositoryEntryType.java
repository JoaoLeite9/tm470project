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

    private final EntityManager entityManager;

    /**
     * @param entityManager entity manager
     */
    public RepositoryEntryType(EntityManager entityManager) {this.entityManager = entityManager;}

    /**
     * @param entryType an entry type to be persisted
     * @return an empty optional instance
     */
    public Optional<EntryType> save(EntryType entryType){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(entryType);
            entityManager.getTransaction().commit();
            return Optional.of(entryType);
        }
        catch(Exception e){
            //print error message
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * @param entryType an entry type to be removed
     * @return an empty optional instance
     */
    public Optional<EntryType> remove(EntryType entryType){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(EntryType.class, entryType.getId());
            entityManager.remove(entryType);
            entityManager.getTransaction().commit();
            return Optional.of(entryType);
        }
        catch(Exception e){
            //print error message
            e.printStackTrace();
        }
        return Optional.empty();
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
    public List findAll() {
        return entityManager.createQuery("from EntryType").getResultList();
    }

    /**
     * @param name the name to search for
     * @return a list of EntryType objects that meet the query
     */
    public Optional<EntryType> findByName(String name) {
        EntryType entryType = entityManager.createNamedQuery("EntryType.findByName", EntryType.class)
                .setParameter("name", name)
                .getSingleResult();
        return entryType != null ? Optional.of(entryType) : Optional.empty();
    }
}
