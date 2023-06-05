package TM470Project.test;

import TM470Project.Entry;
import TM470Project.EntryType;

import java.util.HashMap;

/**
 *
 * @author Joao
 * v2 18/05/2023
 */
public class TestEntry {
    private static HashMap<String, Entry> entries = new HashMap<>();
    private static HashMap<String, EntryType> entryTypes = new HashMap<>();

    //tests
    
    public static void runEntryTests(){
        testObjectCreation();
        testObjectEditing();
    }

    /*
     * Generates 3 trusted EntryType objects
     */
    public static void createEntryTypes(){

        EntryType entryType01 = new EntryType("run", "distance, km", 90);
        entryTypes.put("entryType01", entryType01);
        EntryType entryType02 = new EntryType("squats", "sets of 10",35);
        entryTypes.put("entryType02", entryType02);
        EntryType entryType03 = new EntryType("walk", "steps", 0.1);
        entryTypes.put("entryType03", entryType03);
    }

    public static void testObjectCreation(){
        createEntryTypes();

        Entry entryTest;

        //personalized tests testing
        //create test variables
        String testId = "test00";
        String testDate = ""; //generate random date;
        int testValue = 0;

        for(int i = 0; i < 20; i++) {
            try {
                //entryTest = new Entry(randomEntryType(), testValue, testDate);
                //entries.put(testId, entryTest);
            } catch (Exception e) {
                System.out.println("Error message");
            } finally {
                testId = testId.substring(0, -1) + i;
                testValue += i * 5; //or generate random
            }
        }
    }

    /*
     * Tests editing existing legal objects into illegal objects
     */
    public static void testObjectEditing(){
        //create legal objects
        //change variables to illegal variants
    }
}
