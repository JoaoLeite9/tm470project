package TM470Project.test;

import TM470Project.EntryType;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Joao
 * v2 18/05/2023
 */

public class TestEntryType {
    
    private static HashMap<String, EntryType> entryTypes = new HashMap<>();

    public static void runEntryTypeTests(){
        testEntryTypeCreation();
        testObjectEditing();
    }

    /*
     * tests entryType creation and prints results
     */
    public static void testEntryTypeCreation() {
        createTestObjects();
        //assumes object creation is correct
        boolean nameCheck = true;
        boolean metricCheck = true;
        boolean kcalCheck = true;

        for(Map.Entry<String, EntryType> entry : entryTypes.entrySet()){
            if(entry.getKey().length() > EntryType.getTEXT_MAX_LENGTH() ||
                    entry.getKey().length() < EntryType.getTEXT_MIN_LENGTH()){ //check name length is legal for items in collection
                nameCheck = false;
            }
            if(entry.getValue().getMetric().length() > EntryType.getTEXT_MAX_LENGTH()||
                    entry.getValue().getMetric().length() < EntryType.getTEXT_MIN_LENGTH()){ //check metric name length is legal for items in collection
                metricCheck = false;
            }
            if(entry.getValue().getKcal() >= EntryType.getNUMBER_MAX() ||
                    entry.getValue().getKcal() <= EntryType.getNUMBER_MIN()){ //check kcal value is legal for items in collection
                kcalCheck = false;
            }
        }


        //test return statements

        if(nameCheck && metricCheck && kcalCheck) {
            System.out.println("All checks successful");
        }
        else {
            if (nameCheck) {
                System.out.println("Name check successful");
            } else {
                System.out.println("Name check unsuccessful");
            }

            if (metricCheck) {
                System.out.println("Metric check successful");
            } else {
                System.out.println("Metric check unsuccessful");
            }

            if (kcalCheck) {
                System.out.println("Kcal check successful");
            } else {
                System.out.println("Kcal check unsuccessful");
            }
        }
    }

    /*
     * Generates objects for testing
     */
    public static void createTestObjects(){
        String testId = "test00";
        String testName = "";
        String testMetric = "";
        int testKcal = 0;
        EntryType entryTypeTest;
        System.out.println("""
                
                ---------------
                Uncreated object properties
                ---------------""");
        for(int i = 0; i < 20; i++) {
            //create objects
            try {
                entryTypeTest = new EntryType(testName, testMetric, testKcal);
                entryTypes.put(testName, entryTypeTest);

            }
            catch(Exception e){
                System.out.println("An input is outside of the legal range and was not added. \n" + // prints out details of illegal objects that where caught
                        "test ID: " + testId + "\nname length" + testName.length() + "\nmetric name length: " + testMetric.length()
                + "\nkcal value: " + testKcal + "\n---------------");
            }
            finally{
                testId = testId.substring(0, -1) + i;
                testName += i;
                testMetric += i;
                testKcal += 8;
            }
        }
        System.out.println("""

                ---------------
                Created object properties
                ---------------""");
        for(Map.Entry<String, EntryType> entry : entryTypes.entrySet()){
            System.out.println("name length: " +
                    entry.getKey().length() + "\n metric name length: " + entry.getValue().getMetric().length() +
                    "\n kcal value: " + entry.getValue().getKcal() + "\n---------------");
        }
    }

    /*
     * Tests editing existing legal objects into illegal objects
     */
    public static void testObjectEditing() {
        //create legal objects
        //change variables to illegal variants
    }
}
