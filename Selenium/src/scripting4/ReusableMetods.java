package scripting4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.*;

import static scripting4.ObjectLocator.*;

public class ReusableMetods {

    /************************************************************************
     * Method            : launchBrowser()
     * Purpose           : This method launches the required browsers viz., chrome, firefox and edge
     * Parameters        : String browserName
     * Return Type       : WebDriver
     * Author Name      : Test user1
     * Reviewed By      :
     * Reviewed Date    :
     * Modified by      :
     *************************************************************************/
    public static WebDriver launchBrowser(String browserName){
        WebDriver oDriver = null;
        try{
            switch(browserName.toLowerCase()){
                case "chrome":
                    oDriver = new ChromeDriver();
                    break;
                case "firefox":
                    oDriver = new FirefoxDriver();
                    break;
                case "edge":
                    oDriver = new EdgeDriver();
                    break;
                default:
                    System.out.println("Invalid browser name '"+browserName+"' was mentioned. Please provide the valid browser name");
                    return null;
            }

            if(oDriver!=null){
                oDriver.manage().window().maximize();
                System.out.println("The '"+browserName+"' browser was launched successful");
                return oDriver;
            }else{
                System.out.println("Failed to launch the '"+browserName+"' browser");
                return null;
            }
        }catch(Exception e){
            System.out.println("Exception in the 'launchBrowser()' method. "+ e);
            return null;
        }
    }

    /************************************************************************
     * Method            : navigateURL()
     * Purpose           : This method loads the url
     * Parameters        : WebDriver oBrowser, String strURL
     * Return Type       : boolean
     * Author Name      : Test user
     *************************************************************************/
    public static boolean navigateURL(WebDriver oBrowser, String strURL){
        try{
            oBrowser.navigate().to(strURL);
            Thread.sleep(2000);
            if(oBrowser.getTitle().equalsIgnoreCase("actiTIME - Login")){
                System.out.println("The url '"+strURL+"' is loaded successful");
                return true;
            }else{
                System.out.println("Failed to load the URL '"+strURL+"'");
                return false;
            }
        }catch(Exception e){
            System.out.println("Exception in the 'navigateURL()' method. "+ e);
            return false;
        }
    }

    /************************************************************************
     * Method            : loginToApplication()
     * Purpose           : This method performs login action in actiTime application
     * Parameters        : WebDriver oBrowser, String userName, String password
     * Return Type       : boolean
     * Author Name      : Test user
     *************************************************************************/
    public static boolean loginToApplication(WebDriver oBrowser, String userName, String password){
        try{
            //Login to the application
            oBrowser.findElement(obj_UserName_Edit).sendKeys(userName);
            oBrowser.findElement(obj_Password_Edit).sendKeys(password);
            oBrowser.findElement(obj_Login_Button).click();
            Thread.sleep(2000);

            //VErify login is successful
            if(oBrowser.findElement(obj_SaveChange_Button).isDisplayed()){
                System.out.println("Login to ActiTime is successful");
                if(oBrowser.findElements(obj_ShortCut_Dialog).size() > 0){
                    oBrowser.findElement(getObj_ShortCut_Close_Button).click();
                }
                return true;
            }else{
                System.out.println("Failed to login to actiTime");
                return false;
            }
        }catch(Exception e){
            System.out.println("Exception in the 'loginToApplication()' method. "+ e);
            return false;
        }
    }

    /************************************************************************
     * Method            : createUser()
     * Purpose           : This method creates new user in actiTime
     * Parameters        : WebDriver oBrowser, Map<String, String> data
     * Return Type       : String
     * Author Name      : Test user
     *************************************************************************/

    public static String createUser(WebDriver oBrowser, Map<String, String> data){
        String userName = null;
        try{
            oBrowser.findElement(obj_USERS_Menu).click();
            Thread.sleep(2000);

            oBrowser.findElement(obj_AddUser_Button).click();
            Thread.sleep(2000);

            oBrowser.findElement(obj_User_FirstName_Edit).sendKeys(data.get("user_FirstName"));
            oBrowser.findElement(obj_User_LastName_Edit).sendKeys(data.get("user_lastName"));
            oBrowser.findElement(obj_User_Email_Edit).sendKeys(data.get("user_email"));
            oBrowser.findElement(obj_User_UserName_Edit).sendKeys(data.get("user_userName"));
            oBrowser.findElement(obj_User_Password_Edit).sendKeys(data.get("user_password"));
            oBrowser.findElement(obj_User_retypePassword_Edit).sendKeys(data.get("user_retypePassword"));

            oBrowser.findElement(obj_CreateUser_Button).click();
            Thread.sleep(2000);
            userName = data.get("user_lastName")+", "+data.get("user_FirstName");

            //VErify user is created successful
            if(oBrowser.findElement(By.xpath(String.format(obj_UserName_Link, userName))).isDisplayed()){
                System.out.println("The new user is created successful");
                return userName;
            }else{
                System.out.println("Failed to create the new user");
                return null;
            }
        }catch(Exception e){
            System.out.println("Exception in the 'createUser()' method. "+ e);
            return null;
        }
    }


    /************************************************************************
     * Method            : deleteUser()
     * Purpose           : This method deletes the user in actiTime
     * Parameters        : WebDriver oBrowser, String userName
     * Return Type       : boolean
     * Author Name       : Test user
     *************************************************************************/
    public static boolean deleteUser(WebDriver oBrowser, String userName){
        try{
            oBrowser.findElement(By.xpath("//div[@class='name']/span[text()='"+userName+"']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//button[contains(text(), 'Delete User')]")).click();
            Thread.sleep(2000);
            oBrowser.switchTo().alert().accept();
            Thread.sleep(2000);


            //VErify user is deleted
            if(oBrowser.findElements(By.xpath("//div[@class='name']/span[text()='"+userName+"']")).size() > 0){
                System.out.println("Failed to delete the user");
                return false;
            }else{
                System.out.println("User is deleted successful");
                return true;
            }
        }catch(Exception e){
            System.out.println("Exception in the 'deleteUser()' method. "+ e);
            return false;
        }
    }


    /************************************************************************
     * Method            : logoutFromActiTime()
     * Purpose           : This method logsout from the actiTime
     * Parameters        : WebDriver oBrowser
     * Return Type       : boolean
     * Author Name       : Test user
     *************************************************************************/
    public static boolean logoutFromActiTime(WebDriver oBrowser){
        try{
            oBrowser.findElement(obj_Logout_Link).click();
            Thread.sleep(2000);

            //VErify logout is successful
            if(oBrowser.findElement(obj_LoginPage_Header).getText().equals("Please identify yourself")){
                System.out.println("Logout from the actiTime is successful");
                return true;
            }else{
                System.out.println("Failed to logout form the actiTime");
                return false;
            }
        }catch(Exception e){
            System.out.println("Exception in the 'logoutFromActiTime()' method. "+ e);
            return false;
        }
    }

    /************************************************************************
     * Method            : getPropData()
     * Purpose           : This method reads the testdata from the Prop file in the for of Map<String, String>
     * Parameters        : String propFileName
     * Return Type       : Map<String, String>
     * Author Name       :
     *************************************************************************/
    public static Map<String, String> getPropData(String propFileName){
        FileInputStream fin = null;
        Properties prop = null;
        Map<String, String> objMap = null;
        try{
            objMap = new HashMap<String, String>();
            fin = new FileInputStream(System.getProperty("user.dir")+"\\testData\\"+propFileName+".properties");
            prop = new Properties();
            prop.load(fin);

            Set<Map.Entry<Object, Object>> oData = prop.entrySet();
            Iterator<Map.Entry<Object, Object>> it = oData.iterator();
            while(it.hasNext()){
                Map.Entry<Object, Object> mp = it.next();
                objMap.put(mp.getKey().toString(), mp.getValue().toString());
            }
            return objMap;
        }catch(Exception e){
            System.out.println("Exception in the 'getPropData()' method. "+ e);
            return null;
        }finally
        {
            try{
                fin.close();
                fin = null;
                prop = null;
            }catch(Exception e){}
        }
    }

}
