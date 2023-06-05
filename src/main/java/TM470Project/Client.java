package TM470Project;


import TM470Project.repository.RepositoryEntry;
import TM470Project.repository.RepositoryEntryType;
import TM470Project.test.TestEntry;
import TM470Project.test.TestEntryType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Joao
 * v1 04/04/2023
 */

public class Client{
    private static boolean setUpComplete = false;

    public static void main(String[] args) {
        // Create entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EntriesDB");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //create repositories
        RepositoryEntryType typeRepository = new RepositoryEntryType(entityManager);
        RepositoryEntry entryRepository = new RepositoryEntry(entityManager);

        //create default entry types
        EntryType run = new EntryType("run", "distance (km)", 24);
        EntryType sitUps = new EntryType("sit ups", "reps (of 10)", 12);

        //create example entry
        Entry run01 = new Entry(run, 2);

    }

    public void start(){
        //opens user interface main window
        if(!setUpComplete){
            firstTimeSetUp();
        }
    }

    public void stop(){
        //closes user interface window(s)
    }

    public void firstTimeSetUp(){
        //initializes database
        //setUpComplete = true;
    }

    public void factoryReset(){
        //removes database
        setUpComplete = false;
    }

    //export/import database?

    //tests
    public static void runTests(){
        TestEntry.runEntryTests();
        TestEntryType.runEntryTypeTests();
    }
}
