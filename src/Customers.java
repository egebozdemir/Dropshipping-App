public class Customers {

    DynamicArray<Customer> Customers = new DynamicArray<>();
    public void addCostumer(Customer customer){
        Customers.addItem(customer);
    }
    public Customer getCustomerbyID(String ID) {
        for (int i = 0; i < Customers.getSize(); i++) {
            Customer currentcustomer = Customers.getItem(i);
            if (currentcustomer.getId().equals(ID)){
                return currentcustomer;
            }
        }
        System.out.println("The customer cannot be found.");
        return new Customer();
    }
    public int getSize(){
        return Customers.getSize();
    }
}
