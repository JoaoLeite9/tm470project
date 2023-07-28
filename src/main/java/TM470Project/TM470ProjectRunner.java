package TM470Project;

import TM470Project.ui.MainFrame;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * The main class and runner for the project
 * @author Joao
 * v3 02/06/2023
 */

public class TM470ProjectRunner {

    public static EntityManagerFactory entityManagerFactory;
    public static EntityManager entityManager;
    public static TM470Controller controller;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("EntriesDB");
        entityManager = entityManagerFactory.createEntityManager();
        controller = new TM470Controller(entityManager);
        MainFrame.run();
    }

    public static TM470Controller getController(){
        return controller;
    }

    public static void closeEntityManager(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
