import java.time.LocalDate;

public class SupOrder {
    private Item itemRef;
    private LocalDate date;
    private int quantity;
    private int uniqueId;
    private static int idCount;

    public SupOrder(){
        uniqueId = idCount;
        idCount++;
    }

    /**
     * Argument Constructor
     * @param itemRef reference to item
     * @param date using local date to give date value
     * @param quantity quantity of item being delivered
     */
    public SupOrder(Item itemRef, LocalDate date, int quantity){
        this.date = date;
        this.quantity = quantity;
        this.itemRef = itemRef;
        uniqueId = idCount;
        idCount++;
    }


    // a getter method to refer to the item
    public Item getItemRef() {
        return itemRef;
    }

    // used to set the item reference
    public boolean setItemRef(Item itemRef) {
        boolean done = false;
        if (itemRef != null) {
            this.itemRef = itemRef;
            done = true;
        }
        return done;
    }

    // used to get the date
    public LocalDate getDate() {
        return date;
    }

    //used to set the date and returns true or false depending on if the change went through or not
    public boolean setDate(LocalDate date){
        boolean done = false;
        if (date != null && !date.isBefore(LocalDate.now())){
            done = true;
            this.date = date;
        }
        return done;
    }

    //gets item quantity
    public int getQuantity() {
        return quantity;
    }

    //allows you to set quantity
    public boolean setQuantity(int quantity) {
        boolean done = false;
        if (quantity >= 0){
            this.quantity = quantity;
            done = true;
        }
        return done;
    }

    //allows you to get uniqueid of item, this is kept unique because of the idcount
    public int getUniqueId() {
        return uniqueId;
    }

    //gets the idcount, the variable is static and so the method is also static
    public static int getIdCount() {
        return idCount;
    }
}
