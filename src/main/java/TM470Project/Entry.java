package TM470Project;

import javax.persistence.*;
import java.time.LocalDate;

/**
 *
 * @author Joao
 * v3 02/06/2023
 */

@Entity
@Table(name = "ENTRY")
@NamedQueries({
        @NamedQuery(name = "Entry.findByDate",
                query = "SELECT e FROM Entry e WHERE e.date = :date")})
        @NamedQuery(name = "Entry.findAll",
                query = "SELECT e FROM Entry e")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entry_type_id")
    private EntryType entryType;
    @Column(name = "metric_value")
    private int metricValue;
    @Column(name = "event_date", columnDefinition = "TIMESTAMP")
    private LocalDate date;

    /* static fields, not included in database */
    @Transient
    private static final int MAX_VALUE = 999;
    @Transient
    private static final int MIN_VALUE = 1;

    // void constructor
    public Entry() {
    }

    /**
     * Constructor for class Entry
     * @param aType the EntryType for the Entry
     * @param aValue the input metric value for the Entry
     */
    public Entry(EntryType aType, int aValue){
        entryType = aType;
        metricValue = aValue;
        setDate(); //sets date to system date

        /* Exceptions */

        if(metricValue > MAX_VALUE || metricValue < MIN_VALUE){
            throw new RuntimeException("Metric Value input for " + id + " is outside the legal range (" + MIN_VALUE + " to " + MAX_VALUE + ")");
        }
        // EntryType is not tested as it is assumed from EntryTypeTest that EntryType is correctly initialized
    }

    /**
     * Polymorphic constructor
     * If date field is left blank, uses default date.
     * @param aType
     * @param aValue
     * @param aDate
     */
    public Entry(EntryType aType, int aValue, LocalDate aDate){
        new Entry(aType, aValue);
        this.date = LocalDate.of(aDate.getYear(), aDate.getMonth(), aDate.getDayOfMonth());
    }


    //getter methods for Entry
    /**
     * @return the unique ID for an Entry object
     */
    public long getId() {
        return id;
    }
    
    /**
     * @return the EntryType for an Entry
     */
//    public EntryType getType(){
//        return entryType;
//    }
    
    /**
     * @return the input metric value for an Entry
     */
    public int getMetric(){
        return metricValue;
    }
    
    /**
     * @return the Date value for an Entry
     */
    public LocalDate getDate(){
        return date;
    }
    
    //setter methods for Entry

    /**
     * @param anEntryType the EntryType to be set to the Entry
     */
//    public void setEntryType(EntryType anEntryType){
//        entryType = anEntryType;
//    }
    
    /**
     * @param aValue the metric value for the Entry
     */
    public void setMetric(int aValue){
        metricValue = aValue;
    }
    
    /**
     * @param year the year
     * @param month the month
     * @param day the day 
     */
    public void setDate(int year, int month, int day){
        date = LocalDate.of(year, month, day);
    }
    
    /**
     * If left empty, inputs system date under date variable
     */
    public void setDate(){
        date = LocalDate.now();
    }

    /**
     * @return a String output representing the entry
     */
//    @Override
//    public String toString(){
//        return "Entry ID: " + id +
//                "\nEntry Type: " + entryType.getName() +
//                "\nMetric Value: " + metricValue +
//                "\nDate: " + date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear() + "\n";
//    }
}