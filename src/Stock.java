import java.time.LocalDate;
import java.util.ArrayList;

public class Stock {
    private ArrayList<Item> products;

    //creating the arraylist inside the no argument constructor
    public Stock(){
        this.products = new ArrayList<>();
    }

    /**
     * Add method to add Items to products arraylist
     * @param item item being added to arraylist
     * @return boolean method so returns true if item is added and false otherwise
     */
    public boolean add(Item item){
        return products.add(item);
    }

    /**
     * used to find an item by getting its and comparing it items actual name, which is attained used get name method
     * @param item name of item being searched for
     * @return either the Item or null depending on if item name entered as parameter is the same as an item name
     */
    public Item findItem(String item){
        //going through the entire arraylist using products.size.
        for (int i = 0; i < products.size(); i++){
            // using ignore case as if the spelling is correct then it is referring to the correct item
            if (item.equalsIgnoreCase(products.get(i).getItemName())){
                return products.get(i);
            }
        }
        //returning null if parameter name does not match any product name.
        return null;
    }

    /**
     * a method to find the most expensive item
     * @return the name of the most expensive item, not the actual item.
     */
    public String findDearest(){
        double dearest = 0;
        int counter = 0;
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getUnitCostPrice() > dearest){
                dearest = products.get(i).getUnitCostPrice();
                counter = i;
            }
        }
        return products.get(counter).getItemName();
    }

    /**
     * finding cheapest item
     * @return returning the item that is the cheapest
     */
    public Item findCheapest(){
        //setting cheapest variable to maximum value using Double max value method
        double cheapest = Double.MAX_VALUE;
        // making a counter, set to zero
        int counter = 0;

        for (int i = 0; i < products.size(); i++){
            //going through arraylist
            //if product item is cheaper than cheapest variable, which is max value on first run then cheapest is set to value of that product
            if (products.get(i).getUnitCostPrice() < cheapest){
                cheapest = products.get(i).getUnitCostPrice();
                //counter is set to i
                counter = i;
            }
        }
        // returning the item which is at position of counter in products arraylist
        return products.get(counter);
    }

    /**
     * used to create orders and send them to suppliers
     * @return arraylist of SupOrders
     */
    public ArrayList<SupOrder> createOrder(){

        ArrayList<SupOrder> orders = new ArrayList<>();
        for (int i = 0; i < products.size();i++){
            //check to see if a product in arraylist has a on order flag of false then it is added to new arraylist called orders
            if (!products.get(i).isOnOrderFlag() && products.get(i).getQuantityInStock() <= products.get(i).getReorderLevel()){
                //creating a new SupOrder order to be sent to supplier
                SupOrder order = new SupOrder(products.get(i), LocalDate.now(), products.get(i).getReOrderQuantity());
                orders.add(order);
                products.get(i).setOnOrderFlag(true);
            }
        }
        //returning the orders arraylist which was created in the method.
        return orders;
    }

}
