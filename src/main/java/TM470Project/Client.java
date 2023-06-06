package TM470Project;


import TM470Project.repository.RepositoryEntry;
import TM470Project.repository.RepositoryEntryType;
import TM470Project.test.TestEntry;
import TM470Project.test.TestEntryType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

/**
 * @author Joao
 * v1 04/04/2023
 */

public class Client{

    private static RepositoryEntryType typeRepository;
    private static RepositoryEntry entryRepository;
    private static Config config;

    public static void main(String[] args) {
        // Create entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EntriesDB");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //create repositories
        typeRepository = new RepositoryEntryType(entityManager);
        entryRepository = new RepositoryEntry(entityManager);

        //creates configuration class
        config = new Config();

        //opens application window
        start();
    }

    public static void start(){
        //opens user interface main window

        EntryType entryType01 = new EntryType("Run", "Kilometres", 20);
        EntryType entryType02 = new EntryType("Sit Ups", "Sets of 10", 12);

        Entry entry01 = new Entry(entryType01, 4);
        Entry entry02 = new Entry(entryType02, 3, LocalDate.of(2012, 12, 12));

        typeRepository.remove(entryType01);
        typeRepository.remove(entryType02);

        entryRepository.remove(entry01);
        entryRepository.remove(entry02);

        /*
        notes of test
        - entryType02 is missing its ID when viewed from entries
        - time for date value for entries always set to 00:00:00, otherwise fine
        - running again creates duplicates - expected
         */
    }

    public static void stop(){
        //closes user interface window(s)
    }

    //tests
    public static void runTests(){
        TestEntry.runEntryTests();
        TestEntryType.runEntryTypeTests();
    }
}
