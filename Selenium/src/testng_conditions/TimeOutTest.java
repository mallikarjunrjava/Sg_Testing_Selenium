package testng_conditions;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 2000)
    public void createUser(){

        System.out.println("User Created Successful");
    }
}
