import java.util.ArrayList;

public class SupOrderBook {
    //creating a private arraylist to hold orders
    private ArrayList<SupOrder> orders;

    //no argument constructor
    public SupOrderBook(){

    }

    /**
     * method using add, so returns true or false depending on if change is made or not. Using this method to add an order to orders arraylist
     * @param order is the order to be added to arraylist
     * @return a true or false using add method if order has been added or not
     */
    public boolean add(SupOrder order){
        return orders.add(order);
    }

    /**
     * adds an arraylist of orders into the orders arraylist, like joining
     * @param list arraylist to be added to orders arraylist
     * @return boolean again so true or false depending on if arraylist is added successfully or not
     */
    public boolean add(ArrayList<SupOrder> list){
        return orders.addAll(list);
    }

}
