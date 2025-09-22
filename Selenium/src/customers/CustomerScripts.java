package customers;

import org.testng.annotations.Test;

public class CustomerScripts {
    @Test
    public void createCustomer(){
        System.out.println("Customer Created Successful");
    }
    @Test
    public void modifyCustomer(){
        System.out.println("Customer Modify Successful");
    }
    @Test
    public void deleteCustomer(){
        System.out.println("Customer Delete Successful");
    }
}
