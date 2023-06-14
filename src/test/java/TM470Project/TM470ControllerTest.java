package TM470Project;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TM470ControllerTest {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    TM470Controller controller;

    @BeforeAll
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("EntriesDB");
        entityManager = entityManagerFactory.createEntityManager();
        controller = new TM470Controller(entityManager);
    }

    @AfterAll
    void tearDown() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void addEntryType() {
        EntryType entryTypeExpected = new EntryType("Run", "Kilometres", 20);
        EntryType entryTypeActual = controller.saveEntryType(entryTypeExpected);
        assertEquals(entryTypeExpected, entryTypeActual);
    }

    @Test
    void addEntry() {
        EntryType testType = new EntryType("Run", "Kilometres", 20);
        Entry entryExpected = new Entry(testType, 20);
        Entry entryActual = controller.saveEntry(entryExpected);
        assertEquals(entryExpected, entryActual);
    }

    @Test
    void deleteEntryType() {
        EntryType entryType = new EntryType("Run", "Kilometres", 20);
        EntryType entryTypeSaved = controller.saveEntryType(entryType);
        controller.deleteEntryType(entryTypeSaved);
        assertFalse(controller.findAllEntryTypes().contains(entryTypeSaved));
    }

    @Test
    void deleteEntry() {
        EntryType testType = new EntryType("Run", "Kilometres", 20);
        Entry entry = new Entry(testType, 20);
        Entry entrySaved = controller.saveEntry(entry);
        controller.deleteEntry(entrySaved);
        assertFalse(controller.findAllEntries().contains(entry));
    }

    @Test
    void findAllEntryTypes() {
        EntryType entryType01 = new EntryType("Run", "Kilometres", 20);
        EntryType entryType02 = new EntryType("Sit Ups", "Sets of 10", 12);
        EntryType entryType03 = new EntryType("Sit Ups", "Sets of 10", 12);
        controller.saveEntryType(entryType01);
        controller.saveEntryType(entryType02);
        controller.saveEntryType(entryType03);
        assertTrue(controller.findAllEntryTypes().contains(entryType01)
                && controller.findAllEntryTypes().contains(entryType02)
                && controller.findAllEntryTypes().contains(entryType03));
    }

    @Test
    void findAllEntries() {
        EntryType entryType = new EntryType("Run", "Kilometres", 20);
        Entry entry01 = new Entry(entryType, 4);
        Entry entry02 = new Entry(entryType, 3, LocalDate.of(2012, 12, 12));
        Entry entry03 = new Entry(entryType, 3);
        controller.saveEntry(entry01);
        controller.saveEntry(entry02);
        controller.saveEntry(entry03);
        assertTrue(controller.findAllEntries().contains(entry01)
                && controller.findAllEntries().contains(entry02)
                && controller.findAllEntries().contains(entry03));
    }

    @Test
    void findEntryTypeByName() {
        EntryType entryTypeExpected = new EntryType("Run", "Kilometres", 20);
        EntryType entryTypeActual = controller.saveEntryType(entryTypeExpected);
        assertEquals(controller.findEntryTypeByName(entryTypeActual.getName()), entryTypeExpected);
    }

    @Test
    void finedEntryTypeByEntries() {

    }

    @Test
    void findEntryByDate() {
    }

    @Test
    void findEntryByEntryType() {

    }
}