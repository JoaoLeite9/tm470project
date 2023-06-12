package TM470Project.test;

import TM470Project.Entry;
import TM470Project.EntryType;
import TM470Project.TM470ProjectRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joao
 * @version v1 10/06/2023
 */

public class TestClass {

    private final List<EntryType> entryTypes;
    private final List<Entry> entries;

    public TestClass(){
        entryTypes = new ArrayList<>();
        entries = new ArrayList<>();
    }

    public void runTest(){
        createObjects();
        addToDatabase();
        updateDatabase();
        removeFromDatabase();
    }

    /**
     * Creates objects to be tested
     */
    public void createObjects(){
        //create entry types
        EntryType entryType01 = new EntryType("Run", "Kilometres", 20);
        entryTypes.add(entryType01);
        EntryType entryType02 = new EntryType("Sit Ups", "Sets of 10", 12);
        entryTypes.add(entryType02);
        EntryType entryType03 = new EntryType("Sit Ups", "Sets of 10", 12); //duplicate but ID should be different
        entryTypes.add(entryType03);

        //create entries
        Entry entry01 = new Entry(entryType01, 4);
        entries.add(entry01);
        Entry entry02 = new Entry(entryType02, 3, LocalDate.of(2012, 12, 12));
        entries.add(entry02);
        Entry entry03 = new Entry(entryType03, 3); //duplicate but ID should be different
        entries.add(entry03);
    }


    /**
     * Test adding objects to the database
     */
    public void addToDatabase(){
        //add entry types to database
        for(EntryType type : entryTypes){
            TM470ProjectRunner.getController().addEntryType(type);
        }

        //create and add entries
        for(Entry entry : entries){
            TM470ProjectRunner.getController().addEntry(entry);
        }
    }

    /**
     * Test removal of objects from the database
     */
    public void removeFromDatabase(){
        //remove entries
        for(Entry entry : entries){
            TM470ProjectRunner.getController().removeEntry(entry);
        }

        //remove entry types
        for(EntryType type : entryTypes){
            TM470ProjectRunner.getController().removeEntryType(type);
        }
    }

    public void updateDatabase(){
        //test: should update the first newEntry type and newEntry in the list AND update the value in the database
        EntryType type = new EntryType("Sprint", "Miles", 19); //a mock type with variables with updated info
        TM470ProjectRunner.getController().updateEntryType(entryTypes.get(0), type);

        Entry newEntry = new Entry(type,5, LocalDate.of(2016, 6, 6) ); //a mock newEntry with variables with updated info
        TM470ProjectRunner.getController().updateEntry(entries.get(0), newEntry);
    }
}
