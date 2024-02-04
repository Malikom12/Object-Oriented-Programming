import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Version2App {
    public static void main(String[] args) {
        //creating a scanner object
        Scanner sc = new Scanner(System.in);

        // creating some suppliers, copied them over from version 1
        Supplier sp1 = new Supplier("Bando", "Big Road 1", 1000, 5000);
        Supplier sp2 = new Supplier("Kilo", "Small Road", 500, 1000);
        Supplier sp3 = new Supplier("Gram", "Medium Road", 0, 1000);


        //item objects are given a unique id using id count which is a counter in item constructors which increases by one everytime a item object is created.
        Item i1 = new Item("Oranges", 10, 10, 50,1.75 , sp1, false);
        Item i2 = new Item("Banana", 5, 7, 45, 0.89, sp1, true);
        Item i3 = new Item("Apple", 0, 10, 50, 0.75, sp1, false);
        Item i4 = new Item("Grapes", 12, 10, 50, 2.75, sp3, false);
        Item i5 = new Item("Kiwi",  55, 0, 0,0.55, sp2, false);
        Item i6 = new Item("Grapes", 12, 10, 50, 2.75, sp3, false);
        Item i7 = new Item("Kiwi",  55, 0, 0,0.55, sp2, false);


        System.out.println(i5.getUniqueId());

        // adding items to the stock arraylist
        Stock s1 = new Stock();
        s1.add(i1);
        s1.add(i2);
        s1.add(i3);
        s1.add(i4);
        s1.add(i5);
        s1.add(i6);
        s1.add(i7);


        //creating deliveries object
        SupDeliveries deliveries = new SupDeliveries();

        Delivery d1 = new Delivery(i1, LocalDate.now(), 50);
        Delivery d2 = new Delivery(i2, LocalDate.of(2023, 10, 15), 45);
        Delivery d3 = new Delivery(i3, LocalDate.of(2023,12,1), 50);
        //adding deliveries to deliveries arraylist
        deliveries.addDelivery(d1);
        deliveries.addDelivery(d2);
        deliveries.addDelivery(d3);

        System.out.println("Please enter the name of item delivered");
        String delName = sc.nextLine();
        //finding item using name and find item method if it is not null then we get the details of that delivery and quantity from the user
        if (s1.findItem(delName) != null) {
            System.out.println("Please enter the quantity delivered:");
            int quantityDel = sc.nextInt();
            // adding a new delivery into deliveries arraylist using the add method previously created.
            deliveries.addDelivery(new Delivery(s1.findItem(delName), LocalDate.now(), quantityDel));
            //here were increasing the quantity of item using incQuantityStock() method which increases quantity of an item by int put in as parameter
            s1.findItem(delName).incQuantityStock(quantityDel);
            //increasing amount owed to supplier by multiplying unit cost price by quantity
            s1.findItem(delName).getSupplierRef().increaseAmountOwed(s1.findItem(delName).getUnitCostPrice() * quantityDel);
            s1.findItem(delName).setOnOrderFlag(false);
        }
        else {
            System.out.println("The item you entered is not valid, or does not exist");
        }

        //creating orderbook, and filling it using the creatOrders method.
        SupOrderBook orderBook = new SupOrderBook();
        orderBook.add(s1.createOrder());


        //deleting deliveries with the name Joe Smith
        System.out.println("number of Joe Smith deliveries deleted is: "+deliveries.deleteDeliveries("Joe Smith"));

        //finding the cheapest item and storing it in an item called cheapest
        Item cheapest = s1.findCheapest();
        // making sure that cheapest is not null as the arraylist could have null elements
        if (cheapest != null) {
            System.out.println("Cheapest item is: " + cheapest.toString());
            //uses previously overridden tostring method to print out the details about the cheapest item
        }else {
            System.out.println("There is no cheapest item");
        }

        //using finditem and then find dearest to find the most expensive item
        Item dearest = s1.findItem(s1.findDearest());
        //again making sure that it is not null
        if (dearest != null) {
            // using the getitemname method on dearest item to get its name
            System.out.println(dearest.getItemName() + " is the dearest item.");
            // getting the stock and supplier using getquantityinstock method and getsupplierref, getsuppliername
            System.out.println(dearest.getQuantityInStock() + " is the quantity in stock. Supplier name is " + dearest.getSupplierRef().getSupplierName());
        }
        else {
            //else statement in the case that dearest is null
            System.out.println("There is no dearest item.");
        }

        //making an arraylist to hold the results from findall deliveries using local date. The arraylist contents are then displayed using a for loop
        ArrayList<Delivery> datedDelivery = deliveries.findAllDeliveries(LocalDate.of(2023, 12, 1));

        for (int i = 0; i < datedDelivery.size(); i++) {
            System.out.println("Delivery details for date: 1/12/2023: " + datedDelivery.get(i).toString());
        }


        // similar concept except here where finding any items with the name product1 and displaying details regarding said item using a for loop.
        ArrayList<Delivery> datedDelivery2 = deliveries.findAllDeliveries("product1");

        for (int i = 0; i < datedDelivery2.size(); i++) {
            System.out.println("Delivery details for date: 1/12/2023: " + datedDelivery.get(i).toString());
        }

    }



    }
