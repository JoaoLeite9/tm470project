package TM470Project;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Joao
 * v3 02/06/2023
 */

@Entity
@Table(name = "ENTRY_TYPE")
@NamedQueries({
        @NamedQuery(name = "EntryType.findByName",
                query = "SELECT e FROM EntryType e WHERE e.name = :name"),
        @NamedQuery(name = "EntryType.findByEntries",
                query = "SELECT e FROM EntryType e WHERE e.entries = :entries"),
        @NamedQuery(name = "EntryType.findAll", query = "SELECT e FROM EntryType e")})
public class EntryType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;    //generates unique ID, primary key
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "metric_type", nullable = false)
    private String metricType;
    @Column(name = "kcal", nullable = false)
    private double kcal;
    @OneToMany(mappedBy = "entryType", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Entry> entries;    //foreign key, lazy fetch

    /* static fields, not included in database */
    @Transient
    private final static double NUMBER_MAX = 100; //the maximum amount for kcal
    @Transient
    private final static double NUMBER_MIN = 0; //the minimum amount for kcal
    @Transient
    private static final int TEXT_MAX_LENGTH = 15; //the maximum text length for name and metricType
    @Transient
    private static final int TEXT_MIN_LENGTH = 1; //the minimum text length for name and metricType

    // void constructor
    public EntryType() {
    }

    /**
     * constructor for EntryType class
     * @param aName the name of the type of workout.
     * @param aMetric the name of the input metric.
     * @param aKcal the kcal amount equivalent to 1 of the input type.
     */
    public EntryType(String aName, String aMetric, double aKcal){
        this.name = aName;
        this.metricType = aMetric;
        this.kcal = aKcal;
    }

    
    //getter methods for EntryType
    /**
     * @return the unique ID for the entryType
     */
    public long getId() {
        return id;
    }
    
    /**
     * @return a String value for entry type name
     */
    public String getName(){
        return name;
    }
    
    /**
     * @return a String value for metric type
     */
    public String getMetric(){
        return metricType;
    }
    
    /**
     * @return a numerical value for kcal
     */    
    public double getKcal(){
        return kcal;
    }

    /**
     * @return a list of all entries using this entry type
     */
    public List<Entry> getEntries() {
        return entries;
    }

    /**
     * @return the maximum length for String inputs 'name' and 'metricType'
     */
    public static int getTEXT_MAX_LENGTH(){
        return TEXT_MAX_LENGTH;
    }

    /**
     * @return the minimum length for String inputs 'name' and 'metricType'
     */
    public static int getTEXT_MIN_LENGTH(){
        return TEXT_MIN_LENGTH;
    }

    /**
     * @return the maximum double amount for 'kcal'
     */
    public static double getNUMBER_MAX(){
        return NUMBER_MAX;
    }

    /**
     * @return the minimum double amount for 'kcal'
     */
    public static double getNUMBER_MIN(){
        return NUMBER_MIN;
    }

    //setter methods for EntryType
    /**
     * @param aName the name for the entryType
     */
    public void setName(String aName) {
            name = aName;
    }
    
    /**
     * @param aType the type of metric for the entryType
     */
    public void setMetric(String aType){
            metricType = aType;
    }
    
    /**
     * @param aKcal the kcal value per 1 unit of the metric
     */
    public void setKcal(double aKcal){
            kcal = aKcal;
    }

    /**
     * @param entries a list of all entries using this entry type
     */
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    /**
     * @return a String output representing the entryType
     */
    @Override
    public String toString(){
        return "EnTryType ID: " + id +
                "\nName: " + name +
                "\nMetric Type: " + metricType +
                "\nkcal: " + kcal + "\n";
    }

    /**
     * @param o the object to be compared to
     * @return boolean for whether the objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntryType entryType = (EntryType) o;
        return id == entryType.id && Double.compare(entryType.kcal, kcal) == 0 && Objects.equals(name, entryType.name) && Objects.equals(metricType, entryType.metricType) && Objects.equals(entries, entryType.entries);
    }
}
