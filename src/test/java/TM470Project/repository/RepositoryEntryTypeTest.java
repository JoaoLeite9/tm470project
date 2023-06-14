package TM470Project.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RepositoryEntryTypeTest {

    private EntityManager entityManager;

    @BeforeAll
    void setUp(){
        RepositoryEntryType typeRepository = new RepositoryEntryType(entityManager);
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
    void findByName() {
    }

    @Test
    void findByEntries() {
    }
}