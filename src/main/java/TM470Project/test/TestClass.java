package TM470Project.test;

import TM470Project.Entry;
import TM470Project.EntryType;
import TM470Project.TM470Controller;
import TM470Project.TM470ProjectRunner;
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
        addToDatabase();
        //removeFromDatabase();
    }

    /**
     * Creates objects to be tested
     */
    public void createObjects(){

        //create entry objects

    }


    /**
     * Test adding objects from the database
     */
    public void addToDatabase(){
        //create and add entry types
        EntryType entryType01 = new EntryType("Run", "Kilometres", 20);
        TM470ProjectRunner.getController().addEntryType(entryType01);
        EntryType entryType02 = new EntryType("Sit Ups", "Sets of 10", 12);
        TM470ProjectRunner.getController().addEntryType(entryType02);
        EntryType entryType03 = new EntryType("Sit Ups", "Sets of 10", 12); //duplicate but ID should be different
        TM470ProjectRunner.getController().addEntryType(entryType03);

        //create and add entries
        Entry entry01 = new Entry(entryType01, 4);
        TM470ProjectRunner.getController().addEntry(entry01);
        Entry entry02 = new Entry(entryType02, 3, LocalDate.of(2012, 12, 12));
        TM470ProjectRunner.getController().addEntry(entry02);
        Entry entry03 = new Entry(entryType03, 3); //duplicate but ID should be different
        TM470ProjectRunner.getController().addEntry(entry03);
    }

    /**
     * Test removal of objects from the database
     */
    public void removeFromDatabase(){
        //remove entries
    }
}
