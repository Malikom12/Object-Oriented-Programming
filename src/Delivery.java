import java.time.LocalDate;

public class Delivery {
    private Item itemRef;
    private LocalDate date;
    private int quantity;

    /**
     * no argument constructor for Delivery class.
     */
    public Delivery(){

    }

    /**
     *argument constructor for delivery
     * @param itemRef Used to reference Item from Item class
     * @param date The delivery date using LocalDate method
     * @param quantity Quantity of items in delivery
     */
    public Delivery (Item itemRef, LocalDate date, int quantity){
        this.quantity = quantity;
        this.date = date;
        this.itemRef = itemRef;
    }

    // returning the item, used to reference to item
    public Item getItemRef(){
        return itemRef;
    }

    public LocalDate getDate(){
        return date;
    }
    public int getQuantity(){
        return quantity;
    }

    // validation to make sure date is not null and is valid
    public boolean setDate(LocalDate date){
        boolean done = false;
        if (date != null){
            done = true;
            this.date = date;
        }
        //if date is not valid then false is returned
        return done;
    }

    public boolean setQuantity(int quantity){
        boolean done = false;
        //we check quantity parameter is valid and not less than zero as you cant have negative quantity of an item and set quantity instance variable as it if its more than or wequal to zero.
        if (quantity >= 0){
            done = true;
            this.quantity = quantity;
        }
        return done;
    }

    /**
     * Used to calculate delivery costs using price stored in instance variable of item, we obtain using getUnitCostPrice method.
     * @param j1 The object in Item Class
     * @return delivery cost as a double
     */

    public double calculateDeliveryCost(Item j1){
        double deliveryCost = 0;
        //we check if price of item in delivery is not 0, as 0 is default value of a double if its higher then we go into if statement.
        // we get unit price of item (object) in item and multiply it by quantity of item in delivery and return that value as a double.
        if (j1.getUnitCostPrice() != 0){
            deliveryCost = quantity * j1.getUnitCostPrice();
        }
        return deliveryCost;
    }

    /**
     * just an overridden toString method to print out a custom string.
     * @return A string.
     */
    @Override
    public String toString(){
        return " item reference: " + itemRef + " local date: " + date + " quantity: " + quantity;
    }
}
