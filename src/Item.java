public class Item {
    //created instance variables for Item class.
    private String itemName;
    private int uniqueId;
    private int quantityInStock;
    private int reOrderLevel;
    private int reOrderQuantity;
    private double unitCostPrice;
    private Supplier supplierRef;
    private boolean onOrderFlag;

    private static int idCount = 0;

    //Created a no argument constructors, doesnt have parameters. Why i didnt give any values to the instance variables is because,
    //they are given default values unlike local variables.
    public Item() {
        onOrderFlag = false;
        uniqueId = idCount;
        //any time an item is created, id count is increased by one.
        idCount++;
    }
    public Item(String itemName, int quantityInStock, int reorderLevel, int reOrderQuantity, double unitCostPrice, Supplier supplierRef, boolean onOrderFlag){
        this.itemName = itemName;
        uniqueId = idCount;
        this.quantityInStock = quantityInStock;
        this.reOrderLevel = reorderLevel;
        this.reOrderQuantity = reOrderQuantity;
        this.unitCostPrice = unitCostPrice;
        this.supplierRef = supplierRef;
        this.onOrderFlag = onOrderFlag;
        idCount++;
    }

    /**
     *  A getter method to return name of item.
     * @return itemName which is name of item.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * A Mutator method to set the name of an item.
     * @param itemName is a string which is used to set the name of itemName instance variable using "this."
     * @return done to tell you if a change has been made, i.e.if name was set or not.
     * Since instance variable for itemName is a string, its given a value of null by default, so method checks
     * if itemName instance variable was given a value or not using constructor. if its null if statement is not run and name
     * is not changed or set. this is because setting a value to a null variable can cause issues.
     * it also checks that something has been entered as a parameter in itemName string if it has and instance variable is not null
     * then itemName instance variable is set to itemName string and boolean done is changed to true.
     * regardless of if if statement is gone into or not done boolean is returned. If its false then change has not been made
     * if its true then change has been made.
     */

    //checks if something has been entered into instance variable and then checks if itemname parameter is not empty, if both are true then sets instance variable to parameter.
    public boolean setItemName(String itemName) {
        boolean done = false;
        if (this.itemName != null && !itemName.isEmpty()){
            this.itemName = itemName;
            done = true;
        }
        return done;
    }


    //gets unique id of item which should be unique due to idcount setting the unique id.
    public int getUniqueId() {
        return uniqueId;
    }

    public static int getIdCount() {
        return idCount;
    }


    //used to set ids, if statement makes sure you cant set an id which has already been occupied due to counter accounting for it. It also makes sure unique id parameter is more than 0.
    public boolean setUniqueId(int uniqueId) {
        boolean done = false;
        if (uniqueId > idCount && uniqueId >= 0) {
            this.uniqueId = uniqueId;
            idCount = uniqueId;
            done = true;
        }
        return done;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    //if statement to make sure that quantityinstock parameter is not allowed to be negative and has to be 0 or more.
    public boolean setQuantityInStock(int quantityInStock) {
        boolean done = false;
        if (quantityInStock >= 0){
            done = true;
            this.quantityInStock = quantityInStock;
        }
        return done;
    }

    // increases quantity in stock using same logic as previous method. if, if statement is true then instance variable for
    //quantity in stock is increased by parameter.
    public boolean incQuantityStock(int incQuantityInStock){
        boolean done = false;
        if (incQuantityInStock >= 0){
            done = true;
            this.quantityInStock = this.quantityInStock + incQuantityInStock;
        }
        return done;
    }

    // does same as last method but inverse so minuses.
    public boolean decQuantityStock(int decQuantityInStock){
        boolean done = false;
        if (quantityInStock - decQuantityInStock >= 0){
            done = true;
            this.quantityInStock = this.quantityInStock - decQuantityInStock;
        }
        return done;
    }

    public int getReorderLevel() {
        return reOrderLevel;
    }

    public boolean setReorderLevel(int reOrderLevel) {
        boolean done = false;
        if (reOrderLevel > 0){
            done = true;
            this.reOrderLevel = reOrderLevel;
        }
        return done;
    }

    public int getReOrderQuantity() {
        return reOrderQuantity;
    }

    //only allows you to reorder if reorder amount plus quantity in stock totaled are more than reorder level, so that we meet the min needed which is reorder level.
    public boolean setReorderQuantity(int reOrderQuantity) {
        boolean done = false;
        if (reOrderQuantity + quantityInStock >= reOrderLevel){
            done = true;
            this.reOrderQuantity = reOrderQuantity;
        }
        return done;
    }

    public double getUnitCostPrice() {
        return unitCostPrice;
    }

    //if statement to make sure item prices are more than 0 and cant be negative.
    public boolean setUnitCostPrice(double unitCostPrice) {
        boolean done = false;
        if (unitCostPrice > 0){
            done = true;
            this.unitCostPrice = unitCostPrice;
        }
        return done;
    }

    //returns supplier from supplier class
    public Supplier getSupplierRef() {
        return supplierRef;
    }

    //allows you to set a different supplier if instance variable for supplier ref is not null.
    public boolean setSupplierRef(Supplier supplierRef) {
        boolean done = false;
        if (supplierRef != null){
            done = true;
            this.supplierRef = supplierRef;
        }
        return done;
    }

    // order flag tells you if item is on order, set to false by default
    public boolean isOnOrderFlag() {
        return onOrderFlag;
    }

    //flag is changed to true if reorderquantity is more than zero signifying that an order has been placed.
    public boolean setOnOrderFlag(boolean onOrderFlag) {
        boolean done = false;
        if (reOrderQuantity > 0){
            done = true;
            this.onOrderFlag = onOrderFlag;
        }
        return done;
    }

    @Override
    public String toString(){
        return "item name: " + itemName + " unique id: " + uniqueId + " quantity in stock: " + quantityInStock + " reorder level " + reOrderLevel + " reorder quantity: " + reOrderQuantity + " unit cost price: " + unitCostPrice + " supplier reference: " + supplierRef + " order status: " + onOrderFlag;
    }

}
