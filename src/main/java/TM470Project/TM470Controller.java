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
    /* add */
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

    /* remove */
    /**
     * Removes an entry type by searching for its ID and removing the associated entry type
     * @param anId the ID of the entry type to be removed
     */
    public void removeEntryType(long anId){
        Optional<EntryType> type = typeRepository.findById(anId);
        type.ifPresent(typeRepository::remove);
    }

    /**
     * Removes an entry by searching for its ID and removing the associated entry
     * @param anId the ID of the entry to be removed
     */
    public void removeEntry(long anId){
        //entryRepository.remove(findEntryById(anId));
        Optional<Entry> entry = entryRepository.findById(anId);
        entry.ifPresent(entryRepository::remove);
    }

    /* update */
    /**
     * @param id the ID of the entry type to be updated
     * @param aType an entry type containing the updated information
     */
    public void updateEntryType(long id, EntryType aType) {
        if(typeRepository.findById(id).isPresent()) {
            //change to make: see where is different and only change where different, switch statement?
            typeRepository.findById(id).get().setName(aType.getName());
            typeRepository.findById(id).get().setMetric(aType.getMetric());
            typeRepository.findById(id).get().setKcal(aType.getKcal());
            typeRepository.findById(id).get().setEntries(aType.getEntries());
        }
    }

    /**
     * @param id the ID of the entry to be updated
     * @param anEntry an entry containing the updated information
     */
    public void updateEntry(long id, Entry anEntry){
        if(entryRepository.findById(id).isPresent()){
            entryRepository.findById(id).get().setDate(anEntry.getDate().getYear(), anEntry.getDate().getMonthValue(), anEntry.getDate().getDayOfMonth());
            entryRepository.findById(id).get().setEntryType(anEntry.getType());
            entryRepository.findById(id).get().setMetric(anEntry.getMetric());
        }
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
