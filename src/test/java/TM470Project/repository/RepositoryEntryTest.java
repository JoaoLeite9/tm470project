package TM470Project.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RepositoryEntryTest {

    private EntityManager entityManager;

    @BeforeAll
    void setUp() {
        RepositoryEntry entryRepository = new RepositoryEntry(entityManager);
    }

    @Test
    void save() {
    }

    @Test
    void remove() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByDate() {
    }

    @Test
    void findByEntryType() {
    }
}