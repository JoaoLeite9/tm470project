package TM470Project;


import TM470Project.repository.RepositoryEntry;
import TM470Project.repository.RepositoryEntryType;
import TM470Project.test.LegacyTestEntry;
import TM470Project.test.LegacyTestType;
import TM470Project.test.TestClass;

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
        //config = new Config();

        //opens application window
        start();

        entityManager.close();
        entityManagerFactory.close();
    }

    public static void start(){
        //opens user interface main window
        runTests();
    }

    public static void stop(){
        //closes user interface window(s)
    }

    //tests
    public static void runTests(){
        TestClass testclass = new TestClass();
        testclass.runTest();
    }
}
