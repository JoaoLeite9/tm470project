package TM470Project;

import TM470Project.repository.RepositoryEntry;
import TM470Project.repository.RepositoryEntryType;
import TM470Project.ui.MainFrame;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Joao
 * v1 04/04/2023
 */

public class TM470Controller {

    private RepositoryEntryType typeRepository;
    private RepositoryEntry entryRepository;
    //private Config config;

    /**
     * Constructor for controller class
     */
    public TM470Controller(EntityManager entityManager) {
        //create repositories
        this.typeRepository = new RepositoryEntryType(entityManager);
        this.entryRepository = new RepositoryEntry(entityManager);
        //config = new Config();
    }

    /**
     * Starts the application
     */
    public void start(){
        try {
            //creates configuration class
            //config = new Config();
            
            //opens user interface main window
//            MainFrame.run();

        }
        catch(Exception e){
            //print error
            //System.out.println();
            e.printStackTrace();
        }
    }

    /**
     * Stops the application
     */
    public void stop(){
        //closes entity manager and factory
        TM470ProjectRunner.closeEntityManager();
    }

    /* data manipulation */
    /* add methods */
    /**
     * Adds entry type to the database
     * @param aType the entry type to ba added
     * @return the entry type to be saved
     */
    public EntryType saveEntryType(EntryType aType){
        return typeRepository.save(aType).orElse(null);
    }

    /**
     * Adds entry to the database
     * @param anEntry the entry to be added
     * @return the entry to be saved
     */
    public Entry saveEntry(Entry anEntry){
        return entryRepository.save(anEntry).orElse(null);
    }

    /* remove methods */
    /**
     * Removes an entry type by searching for its ID and removing the associated entry type
     *
     * @param aType the entry type to be removed
     */
    public void deleteEntryType(EntryType aType){
        Optional<EntryType> type = typeRepository.findById(aType.getId());
        type.ifPresent(typeRepository::remove);
    }

    /**
     * Removes an entry by searching for its ID and removing the associated entry
     * @param anEntry the entry to be removed
     */
    public void deleteEntry(Entry anEntry){
        entryRepository.remove(anEntry);
    }

    /* queries */
    /* find all */
    /**
     * Finds all entry types in the database
     * @return a list of all entry types or null
     */
    public List<EntryType> findAllEntryTypes(){
        return typeRepository.findAll().orElse(null);
    }

    /**
     * Finds all entry in the database
     * @return a list of all entries or null
     */
    public List<Entry> findAllEntries(){
        return entryRepository.findAll().orElse(null);
    }

    /* find by input */
    /**
     * Searches for entry types bases on name
     * @param aName the name of the entry type
     * @return the queried entry type or null
     */
    public EntryType findEntryTypeByName(String aName){
        return typeRepository.findByName(aName).orElse(null);
    }

    /**
     * Searches for entries by date
     * @param aDate the date of the entry
     * @return the queried entry or null
     */
    public List<Entry> findEntryByDate(LocalDate aDate){
        return entryRepository.findByDate(aDate).orElse(null);
    }

    /**
     * @param aType the type of the entries
     * @return a list of entries with the associated type
     */
    public List<Entry> findEntryByEntryType(EntryType aType){
        return entryRepository.findByEntryType(aType).orElse(null);
    }


    /* database reset */
    public void deleteAllEntries(){
        entryRepository.deleteAllEntries();
    }

    public void deleteAllEntryTypes(){
        typeRepository.deleteAllEntryTypes();
    }
}
