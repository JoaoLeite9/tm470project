package TM470Project.repository;

import TM470Project.EntryType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RepositoryEntryTypeTest {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    RepositoryEntryType repository;

    @BeforeAll
    void setUp() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("EntriesDB");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.repository = new RepositoryEntryType(entityManager);
    }

    @AfterAll
    void tearDown() {
        repository.deleteAllEntryTypes();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void save() {
        EntryType entryTypeExpected = new EntryType("Run", "Kilometres", 20);
        EntryType entryTypeActual = repository.save(entryTypeExpected).orElse(null);
        assertEquals(entryTypeExpected, entryTypeActual);
    }

    @Test
    void remove() {
        EntryType entryType = repository.save(new EntryType("Jog", "Kilometres", 20)).orElse(null);
        repository.remove(entryType);
        assertFalse(entityManager.contains(entryType));
    }

    @Test
    void findById() {
        EntryType entryTypeExpected = new EntryType("Sprint", "Kilometres", 20);
        EntryType entryTypeActual = repository.save(entryTypeExpected).orElse(null);
        assertTrue(repository.findById(entryTypeActual.getId()).isPresent());
        assertEquals(repository.findById(entryTypeActual.getId()).get(), entryTypeExpected);
    }

    @Test
    void findAll() {
        EntryType entryTypeExpected = new EntryType("Running", "Kilometres", 20);
        EntryType entryTypeActual = repository.save(entryTypeExpected).orElse(null);
        assertTrue(repository.findAll().isPresent() && repository.findAll().get().contains(entryTypeActual));
    }

    @Test
    void findByName() {
        EntryType entryTypeExpected = new EntryType("Jogging", "Kilometres", 20);
        EntryType entryTypeActual = repository.save(entryTypeExpected).orElse(null);
        assertTrue(repository.findByName(entryTypeActual.getName()).isPresent());
        assertEquals(repository.findByName(entryTypeActual.getName()).get(), entryTypeExpected);
    }
}