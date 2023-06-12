package TM470Project;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

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
    private long id;    //generates unique ID, primary key
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entry_type_id")
    private EntryType entryType;    //foreign key, eager fetch
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
        this(aType, aValue, null);
        setDate(); //sets date to system date
    }

    /**
     * Polymorphic constructor
     * If date field is left blank, uses default date.
     * @param aType the EntryType for the Entry
     * @param aValue the input metric value for the Entry
     * @param aDate a Date object for the Entry
     */
    public Entry(EntryType aType, int aValue, LocalDate aDate){

//        /* Exceptions */
//        if(aValue > MAX_VALUE || aValue < MIN_VALUE){
//            throw new RuntimeException("Metric Value input for " + id + " is outside the legal range (" + MIN_VALUE + " to " + MAX_VALUE + ")");
//        }

        /* Field definition */
        entryType = aType;
        metricValue = aValue;
        date = aDate;
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
    public EntryType getType(){
        return entryType;
    }
    
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
    public void setEntryType(EntryType anEntryType){
        entryType = anEntryType;
    }
    
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
    @Override
    public String toString(){
        return "Entry ID: " + id +
                "\nEntry Type: " + entryType.getName() +
                "\nMetric Value: " + metricValue +
                "\nDate: " + date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear() + "\n";
    }

    /**
     * @param o the object to be compared to
     * @return boolean for whether the objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return id == entry.id && metricValue == entry.metricValue && Objects.equals(entryType, entry.entryType) && Objects.equals(date, entry.date);
    }
}
