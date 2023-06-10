package TM470Project.test;

import TM470Project.Entry;
import TM470Project.EntryType;
import TM470Project.repository.RepositoryEntry;
import TM470Project.repository.RepositoryEntryType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joao
 * @version v1 10/06/2023
 */

public class TestClass {

    private final RepositoryEntryType typeRepository;
    private final RepositoryEntry entryRepository;
    private List<EntryType> entryTypes;
    private List<Entry> entries;

    public TestClass(){
        // Create entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EntriesDB");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //create repositories
        typeRepository = new RepositoryEntryType(entityManager);
        entryRepository = new RepositoryEntry(entityManager);
    }

    public void runTest(){
        createObjects();
        addToDatabase();
        removeFromDatabase();
    }

    /**
     * Creates objects to be tested
     */
    public void createObjects(){
        //create lists to hold objects
        entryTypes = new ArrayList<>();
        entries = new ArrayList<>();

        //create entryType objects
        EntryType entryType01 = new EntryType("Run", "Kilometres", 20);
        entryTypes.add(entryType01);
        EntryType entryType02 = new EntryType("Sit Ups", "Sets of 10", 12);
        entryTypes.add(entryType02);
        EntryType entryType03 = new EntryType("Sit Ups", "Sets of 10", 12); //duplicate but ID should be different
        entryTypes.add(entryType03);

        //create entry objects
        Entry entry01 = new Entry(entryType01, 4);
        entries.add(entry01);
        Entry entry02 = new Entry(entryType02, 3, LocalDate.of(2012, 12, 12));
        entries.add(entry02);
        Entry entry03 = new Entry(entryType03, 3, LocalDate.of(2012, 12, 12)); //duplicate but ID should be different
        entries.add(entry03);
    }


    /**
     * test adding objects from the database
     */
    public void addToDatabase(){
        boolean success = true; //optimistic testing
        //add entryTypes
        try {
            for(EntryType type : entryTypes){
                //add type to database
                typeRepository.save(type);
            }
        }
        catch(Exception e){
            //error message
            e.printStackTrace();
            success = false;
        }
        finally {
            // after adding entryTypes, add entries
            try {
                for(Entry entry : entries){
                    //add entry to database
                    entryRepository.save(entry);

                }
            }
            catch(Exception e){
                //error message
                e.printStackTrace();
                success = false;
            }
            finally {
                if(!success){
                    System.out.println("An error occurred somewhere in adding objects to the database");
                }
                else {
                    System.out.println("No errors occurred in adding objects to the database");
                }
            }
        }
    }

    /**
     * Test removal of objects from the database
     */
    public void removeFromDatabase(){
        boolean success = true; //optimistic testing
        //remove entries
        try {
            //remove entries from database
        }
        catch(Exception e){
            //error message
            e.printStackTrace();
            success = false;
        }
        finally {
            //remove entryTypes from database
            try{
                //remove entry types from database
            }
            catch(Exception e){
                e.printStackTrace();
                success = false;
            }
            finally {
                if(!success){
                    System.out.println("An error occurred somewhere in removing objects from the database");
                }
                else{
                    System.out.println("No errors occurred in removing objects from the database");
                }
            }
        }
    }
}
