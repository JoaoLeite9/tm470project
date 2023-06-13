package TM470Project;

import TM470Project.repository.RepositoryEntry;
import TM470Project.repository.RepositoryEntryType;
import TM470Project.test.TestClass;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Joao
 * v1 04/04/2023
 */

public class TM470Controller {

    private final RepositoryEntryType typeRepository;
    private final RepositoryEntry entryRepository;
    //private Config config;

    /**
     * Constructor for controller class
     */
    public TM470Controller() {
        //create repositories
        typeRepository = new RepositoryEntryType(TM470ProjectRunner.getEntityManager());
        entryRepository = new RepositoryEntry(TM470ProjectRunner.getEntityManager());
        //config = new Config();
    }

    /**
     * Starts the application
     */
    public void start(){
        try {
            //creates configuration class
            //config = new Config();

            //opens application window
            //opens user interface main window

            TestClass testClass = new TestClass();
            testClass.runTest();
        }
        catch(Exception e){
            //print error
            System.out.println();
            e.printStackTrace();
        }
    }

    /**
     * Stops the application
     */
    public void stop(){
        //closes user interface window(s)

        //closes entity manager and factory
        TM470ProjectRunner.closeEntityManager();
    }

    /* data manipulation */
    /* add methods */
    /**
     * Adds entry type to the database
     * @param aType the entry type to ba added
     */
    public void addEntryType(EntryType aType){
        typeRepository.save(aType);
    }

    /**
     * Adds entry to the database
     * @param anEntry the entry to be added
     */
    public void addEntry(Entry anEntry){
        entryRepository.save(anEntry);
    }

    /* remove methods */
    /**
     * Removes an entry type by searching for its ID and removing the associated entry type
     *
     * @param aType the entry type to be removed
     */
    public void removeEntryType(EntryType aType){
        Optional<EntryType> type = typeRepository.findById(aType.getId());
        type.ifPresent(typeRepository::remove);
    }

    /**
     * Removes an entry by searching for its ID and removing the associated entry
     * @param anEntry the entry to be removed
     */
    public void removeEntry(Entry anEntry){
        Optional<Entry> entry = entryRepository.findById(anEntry.getId());
        entry.ifPresent(entryRepository::remove);
    }

    /* update methods */
    /**
     * @param aType the entry type to be updated
     * @param newType an entry type containing the updated information
     */
    public void updateEntryType(EntryType aType, EntryType newType) {
        typeRepository.update(aType, newType);
    }

    /**
     * @param anEntry the entry to be updated
     * @param newEntry an entry containing the updated information
     */
    public void updateEntry(Entry anEntry, Entry newEntry){
        entryRepository.update(anEntry, newEntry);
    }

    /* queries */
    /* find all */
    /**
     * Finds all entry types in the database
     * @return a list of all entry types
     */
    public List findAllEntryTypes(){
        return typeRepository.findAll();
    }

    /**
     * Finds all entry in the database
     * @return a list of all entries
     */
    public List findAllEntries(){
        return entryRepository.findAll();
    }

    /* find by input */
    /**
     * Searches for entry types bases on name
     * @param aName the name of the entry type
     * @return the entry type(s)
     */
    public Optional<EntryType> findEntryTypeByName(String aName){
        return typeRepository.findByName(aName);
    }

    /**
     * Searches for entries by date
     * @param aDate the date of the entry
     * @return en entry(s)
     */
    public Optional<Entry> findEntryByDate(LocalDate aDate){
        return entryRepository.findByDate(aDate);
    }
}
