package TM470Project.repository;

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
     */
    public void save(EntryType entryType){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(entryType);
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            //print error message
            e.printStackTrace();
        }
    }

    /**
     * @param entryType an entry type to be removed
     */
    public void remove(EntryType entryType){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(EntryType.class, entryType.getId());
            entityManager.remove(entryType);
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            //print error message
            e.printStackTrace();
        }
    }

    public void update(EntryType entryType, EntryType newType){
        try {
            entityManager.getTransaction().begin();
            entityManager.find(EntryType.class, entryType.getId());
            entityManager.merge(entryType);
            entryType.setName(newType.getName());
            entryType.setMetric(newType.getMetric());
            entryType.setKcal(newType.getKcal());
            entityManager.getTransaction().commit();;
        }
        catch (Exception e){
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
