package TM470Project.repository;

import TM470Project.Entry;
import TM470Project.EntryType;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RepositoryEntryTest {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    RepositoryEntry entryRepository;
    RepositoryEntryType typeRepository;

    @BeforeAll
    void setUp() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("EntriesDB");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entryRepository = new RepositoryEntry(entityManager);
        this.typeRepository = new RepositoryEntryType(entityManager);
    }

    @AfterAll
    void tearDown() {
        entryRepository.deleteAllEntries();
        typeRepository.deleteAllEntryTypes();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void save() {
        EntryType entryType = typeRepository.save(new EntryType("Run", "Kilometres", 20)).orElse(null);
        Entry entryExpected = new Entry(entryType, 15);
        Entry entryActual = entryRepository.save(entryExpected).orElse(null);
        assertEquals(entryExpected, entryActual);
    }

    @Test
    void remove() {
        EntryType entryType = typeRepository.save(new EntryType("Jog", "Kilometres", 20)).orElse(null);
        Entry entry = entryRepository.save(new Entry(entryType, 15)).orElse(null);
        entryRepository.remove(entry);
        assertFalse(entityManager.contains(entry));
    }

    @Test
    void findById() {
        EntryType entryType = typeRepository.save(new EntryType("Sprint", "Kilometres", 20)).orElse(null);
        Entry entryExpected = new Entry(entryType, 15);
        Entry entryActual = entryRepository.save(entryExpected).orElse(null);
        assertTrue(entryRepository.findById(entryActual.getId()).isPresent());
        assertEquals(entryRepository.findById(entryActual.getId()).get(), entryExpected);
    }

    @Test
    void findAll() {
        EntryType entryType = typeRepository.save(new EntryType("Running", "Kilometres", 20)).orElse(null);
        Entry entryExpected = new Entry(entryType, 15);
        Entry entryActual = entryRepository.save(entryExpected).orElse(null);
        assertTrue(entryRepository.findAll().isPresent() && entryRepository.findAll().get().contains(entryActual));
    }

    @Test
    void findByDate() {
        EntryType entryType = typeRepository.save(new EntryType("Jogging", "Kilometres", 20)).orElse(null);
        Entry entryExpected = new Entry(entryType, 15);
        Entry entryActual = entryRepository.save(entryExpected).orElse(null);
        assertTrue(entryRepository.findByDate(entryActual.getDate()).isPresent());
        assertTrue(entryRepository.findByDate(entryActual.getDate()).get().contains(entryActual));
    }

    @Test
    void findByEntryType() {
        EntryType entryType = typeRepository.save(new EntryType("Swimming", "Kilometres", 20)).orElse(null);
        Entry entryExpected = new Entry(entryType, 15);
        Entry entryActual = entryRepository.save(entryExpected).orElse(null);
        assertTrue(entryRepository.findByEntryType(entryActual.getType()).isPresent());
        assertTrue(entryRepository.findByEntryType(entryActual.getType()).get().contains(entryActual));
        assertEquals(entryRepository.findByEntryType(entryActual.getType()).get(), Collections.singletonList(entryExpected));
    }
}