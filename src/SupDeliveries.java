import java.time.LocalDate;
import java.util.ArrayList;

public class SupDeliveries {
    //arraylist to hold incoming deliveries
    private ArrayList<Delivery> inComing;

    //creating arraylist incoming in no argument constructor had to do this otherwise id get null exception error
    public SupDeliveries(){
        this.inComing = new ArrayList<>();
    }

    /**
     * adds delivery into incoming arraylist
     * @param delivery is delivery to be added to arraylist
     * @return boolean so true if delivery is added and false otherwise
     */
    public boolean addDelivery(Delivery delivery){
        return inComing.add(delivery);
    }

    /**
     * finds all deliveries that have a date of date entered as parameter
     * @param date being entered in local date format
     * @return arraylist containing all deliveries that have a date of parameter date
     */
    public ArrayList<Delivery> findAllDeliveries(LocalDate date){
        //make new arraylist
        ArrayList<Delivery> allDeliveries = new ArrayList<>();
        //going through arraylist
        for (int i = 0; i < inComing.size(); i++){
            //checking if date parameter matches date of current delivery in incoming arraylist
            if (date.isEqual(inComing.get(i).getDate())){
                //if it does match it is added to alldeliveries arraylist which will be returned
                allDeliveries.add(inComing.get(i));
            }
        }
        return allDeliveries;
    }

    /**
     * Finding all deliveries that match a name
     * @param name being entered as a string to compare to
     * @return arraylist containing all deliveries that have same name to parameter name string
     */
    public ArrayList<Delivery> findAllDeliveries(String name){
        //creating arraylist to be returned
        ArrayList<Delivery> allDeliveries = new ArrayList<>();
        //going through arraylist
        for (int i = 0; i < inComing.size(); i++){
            //checking if name matches, using equals ignore case as if the name matches then casing does not matter, casing doesnt differentiate supplier
            if (name.equalsIgnoreCase(inComing.get(i).getItemRef().getSupplierRef().getSupplierName())){
                //if it matches name it is added to new arraylist
                allDeliveries.add(inComing.get(i));
            }
        }
        //arraylist returned
        return allDeliveries;
    }

    /**
     * deleting all deliveries that match a name
     * @param name being entered as a string
     * @return number of deliveries deleted
     */
    public int deleteDeliveries(String name){
        // making new arraylist
        ArrayList<Delivery> deliveriesToDelete = new ArrayList<>();
        //counter to keep track of how many deliveries are deleted
        int counter = 0;
        for (int i = 0; i < inComing.size(); i++){
            //if name matches the supplier name it is added to new array and counter is updated by 1
            if (name.equalsIgnoreCase(inComing.get(i).getItemRef().getSupplierRef().getSupplierName())){
                deliveriesToDelete.add(inComing.get(i));
                counter++;
            }
        }
        // at end of code, we use remove all method in arraylists to remove all deliveries that are in new arraylist
        inComing.removeAll(deliveriesToDelete);
        //counter is returned to say how many deliveries were deleted.
        return counter;
    }

}
