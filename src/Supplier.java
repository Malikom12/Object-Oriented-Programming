public class Supplier {
    private String supplierName;
    private String supplierAddress;
    private double amountOwed;
    private double creditLimit;

    /**
     * No argument default constructor
     */
    public Supplier(){

    }

    /**
     * Parameterised constructor for Supplier class
     * @param supplierName name of supplier
     * @param supplierAddress address of supplier
     * @param amountOwed how much client owes to supplier
     * @param creditLimit how much client can borrow against supplier
     */
    public Supplier(String supplierName, String supplierAddress, double amountOwed, double creditLimit){
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.amountOwed = amountOwed;
        this.creditLimit = creditLimit;
    }


    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    //set name for supplier if instance variable is not null and supplierName parameter is not empty.
    public boolean setSupplierName(String supplierName){
        boolean done = false;
        if (this.supplierName != null && !supplierName.isEmpty()){
            done = true;
            this.supplierName = supplierName;
        }
        return done;
    }

    //same logic as before but for address this time.
    public boolean setSupplierAddress(String supplierAddress){
        boolean done = false;
        if (this.supplierAddress != null && !supplierAddress.isEmpty()){
            done = true;
            this.supplierAddress = supplierAddress;
        }
        return done;
    }

    //allows you to set amount owed to more than zero and less than or equal to credit limit,not allowing you to increase past credit limit.
    public boolean setAmountOwed(double amountOwed){
        boolean done = false;
        if (amountOwed >= 0 && amountOwed <= creditLimit){
            done = true;
            this.amountOwed = amountOwed;
        }
        return done;
    }

    //allows you to increase amount owed if its less than credit limit when added to already owed amount.
    public boolean increaseAmountOwed(double amountOwed){
        boolean done = false;
        if (amountOwed >= 0 && (this.amountOwed + amountOwed) <= creditLimit){
            done = true;
            this.amountOwed = this.amountOwed + amountOwed;
        }
        return done;
    }

    //lets you decrease amount owed if amount owed minus parameter is not less than zero
    public boolean decreaseAmountOwed(double amountOwed){
        boolean done = false;
        if (amountOwed >= 0 && (this.amountOwed - amountOwed) >= 0){
            done = true;
            this.amountOwed = this.amountOwed - amountOwed;
        }
        return done;
    }

    //allows you to set a credit limit if its more than or equal to 0.
    public boolean setCreditLimit(double creditLimit){
        boolean done = false;
        if (creditLimit >= 0){
            done = true;
            this.creditLimit = creditLimit;
        }
        return done;
    }

    @Override
    public String toString(){
        return "Supplier: " + supplierName + " Supplier Address :" + supplierAddress + " Amount Owed: " + amountOwed + "Credit Limit: " + creditLimit;
    }

}
