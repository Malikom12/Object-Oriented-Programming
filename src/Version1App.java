import java.time.LocalDate;

public class Version1App {
    public static void main(String[] args) {

        // Created Objects for Each Class, Items, Supplier, and Delivery.
        Supplier s1 = new Supplier("Bando", "Big Road 1", 1000, 5000);
        Supplier s2 = new Supplier("Kilo", "Small Road", 500, 1000);
        Supplier s3 = new Supplier("Gram", "Medium Road", 0, 1000);


        //item objects are given a unique id using id count which is a counter in item constructors which increases by one everytime a item object is created.
        Item i1 = new Item("Oranges", 10, 10, 50,1.75 , s1, false);
        Item i2 = new Item("Banana", 5, 7, 45, 0.89, s1, true);
        Item i3 = new Item("Apple", 0, 10, 50, 0.75, s1, false);
        Item i4 = new Item("Grapes", 12, 10, 50, 2.75, s3, false);
        Item i5 = new Item("Kiwi",  55, 0, 0,0.55, s2, false);


        System.out.println(i5.getUniqueId());

        //To give dates to deliveries I used LocalDate of inbuilt method, the now gives it a date of right now.
        Delivery d1 = new Delivery(i1, LocalDate.now(), 50);
        Delivery d2 = new Delivery(i2, LocalDate.of(2023, 10, 15), 45);
        Delivery d3 = new Delivery(i3, LocalDate.of(2023,10,15), 50);
        Delivery d4 = new Delivery(i4, LocalDate.now(), 60);

        //prints out cost of delivery 1 or d1.
        System.out.println("Cost of Delivery1: " + d1.calculateDeliveryCost(i1));

        //gets the date from delivery 1 using getter for date and compares it to date at runtime. If date is same then if statement is run,
        //prints name of item, quantity, and amount owed before and after delivery. Gets cost using calcdeliverymethod created in delivery class.
        //Subsequent if statements use same logic just check other delivery objects e.g. d2, d3

        //deliveries are linked to items and suppliers through instance variable.

        /* Display the cost of d1.
        Display the amount owed to a Supplier and the quantity in stock of an item before and after a delivery of that item is received from that supplier.
         */

        if (d1.getDate().equals(LocalDate.now()) || d1.getDate().isBefore(LocalDate.now())){
            //Prints before and after for stock and amount owed for deliveries d1,d2,d3
            System.out.println("Before delivery quantity of " + d1.getItemRef().getItemName() + " is: " + d1.getItemRef().getQuantityInStock() + " and amount owed to " + d1.getItemRef().getSupplierRef().getSupplierName() + " is :$" + d1.getItemRef().getSupplierRef().getAmountOwed());
            d1.getItemRef().incQuantityStock(d1.getQuantity());
            d1.getItemRef().getSupplierRef().increaseAmountOwed(d1.calculateDeliveryCost(d1.getItemRef()));
            System.out.println("Before delivery quantity of " + d1.getItemRef().getItemName() + " is: " + d1.getItemRef().getQuantityInStock() + " and amount owed to " + d1.getItemRef().getSupplierRef().getSupplierName() + " is :$" + d1.getItemRef().getSupplierRef().getAmountOwed());
        }

        if (d2.getDate().equals(LocalDate.now()) || d2.getDate().isBefore(LocalDate.now())){
            System.out.println("Before delivery quantity of " + d2.getItemRef().getItemName() + " is: " + d2.getItemRef().getQuantityInStock() + " and amount owed to " + d2.getItemRef().getSupplierRef().getSupplierName() + " is :$" + d2.getItemRef().getSupplierRef().getAmountOwed());
            d2.getItemRef().incQuantityStock(d2.getQuantity());
            d2.getItemRef().getSupplierRef().increaseAmountOwed(d2.calculateDeliveryCost(d2.getItemRef()));
            System.out.println("Before delivery quantity of " + d2.getItemRef().getItemName() + " is: " + d2.getItemRef().getQuantityInStock() +  " and amount owed to " + d2.getItemRef().getSupplierRef().getSupplierName() + " is :$" + d2.getItemRef().getSupplierRef().getAmountOwed());
        }

        if (d3.getDate().equals(LocalDate.now()) || d3.getDate().isBefore(LocalDate.now())){
            System.out.println("Before delivery quantity of " + d3.getItemRef().getItemName() + " is: " + d3.getItemRef().getQuantityInStock() + " and amount owed to " + d3.getItemRef().getSupplierRef().getSupplierName() + " is :$" + d3.getItemRef().getSupplierRef().getAmountOwed());
            d3.getItemRef().incQuantityStock(d1.getQuantity());
            d3.getItemRef().getSupplierRef().increaseAmountOwed(d3.calculateDeliveryCost(d3.getItemRef()));
            System.out.println("Before delivery quantity of " + d3.getItemRef().getItemName()+ " is: " + d3.getItemRef().getQuantityInStock() + " and amount owed to " + d3.getItemRef().getSupplierRef().getSupplierName() + " is :$" + d3.getItemRef().getSupplierRef().getAmountOwed());
        }

        if (d4.getDate().equals(LocalDate.now()) || d4.getDate().isBefore(LocalDate.now())){
            System.out.println("Before delivery quantity of " + d4.getItemRef().getItemName() + " is: " + d4.getItemRef().getQuantityInStock() + " and amount owed to " + d4.getItemRef().getSupplierRef().getSupplierName() + " is :$" + d4.getItemRef().getSupplierRef().getAmountOwed());
            d4.getItemRef().incQuantityStock(d1.getQuantity());
            d4.getItemRef().getSupplierRef().increaseAmountOwed(d4.calculateDeliveryCost(d4.getItemRef()));
            System.out.println("Before delivery quantity of " + d4.getItemRef().getItemName() + " is: " + d4.getItemRef().getQuantityInStock() + " and amount owed to " + d4.getItemRef().getSupplierRef().getSupplierName() + " is :$" + d4.getItemRef().getSupplierRef().getAmountOwed());
        }


    }
}
