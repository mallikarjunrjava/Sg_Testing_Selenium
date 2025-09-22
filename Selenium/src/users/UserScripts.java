package users;

import org.testng.annotations.*;

public class UserScripts {
    @Test
    public void createUser(){

        System.out.println("User Created Successful");
    }
    @Test
    public void modifyUser(){

        System.out.println("User Modify Successful");
    }
    @Test
    public void deleteUser(){
        System.out.println("User Delete Successful");
    }

    @BeforeSuite
    public void beforeSuiteDemo(){
        System.out.println("Users @BeforeSuite Example");
    }
    @AfterSuite
    public void afterSuiteDemo(){
        System.out.println(" Users @AfterSuite Example");
    }

    @BeforeTest
    public void beforeTestDemo(){
        System.out.println(" Users @BeforeTest Example");
    }

    @AfterTest
    public void afterTestDemo(){
        System.out.println(" Users @AfterTest Example");
    }

    @BeforeClass
    public void beforeClassDemo(){
        System.out.println(" Users @BeforeClass Example");
    }
    @AfterClass
    public void afterClassDemo(){
        System.out.println(" Users @AfterClass Example");
    }

    @BeforeMethod
    public void beforeMethodDemo(){
        System.out.println(" Users @BeforeMethod Example");
    }
    @AfterMethod
    public void afterMethodDemo(){
        System.out.println(" Users @AfterMethod Example");
    }


}
