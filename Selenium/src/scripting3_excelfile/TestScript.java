package scripting3_excelfile;

import org.openqa.selenium.WebDriver;

import java.util.Map;
/*
Scripting3: Parameterization(Using Excel file)- It is a process of placing the test data in the external source viz,
Excel file, properties file, json file, DB etc
write a wrapper method to read the test data and use them script.

Excel File: Map(key and value pair): Single/multiple set of data can be provided.
*/

public class TestScript extends ReusableMetods3 {
    public static void main(String[] args) {

            TS_LoginLogout();
            TS_CreateAndDeleteUser();
    }

    public static void TS_LoginLogout(){
        WebDriver oBrowser=null;
        Map<String, String> data = null;
        try {
            data = getExcelData("TestData", "TestData", "TC_ID_001");
            oBrowser=launchBrowser(data.get("browserName"));
            boolean bln = navigateURL(oBrowser, data.get("url"));
            bln=loginToApplication(oBrowser, data.get("userName"), data.get("password"));
            bln=logoutFromActiTime(oBrowser);

        } catch (Exception e) {
            System.out.println("Exception in 'TS_LoginLogout() ' Test script3_Excelfile");;
        }
        finally {
            oBrowser.quit();
            oBrowser=null;
        }
    }

    public static void TS_CreateAndDeleteUser(){
            WebDriver oBrowser=null;
            Map<String, String> data = null;
        try {
            data = getExcelData("TestData", "TestData", "TC_ID_002");
            oBrowser=launchBrowser(data.get("browserName"));
            boolean blnres = navigateURL(oBrowser, data.get("url"));
            blnres=loginToApplication(oBrowser, data.get("userName"), data.get("password"));

            String userName = createUser(oBrowser, data);
            blnres = deleteUser(oBrowser,userName);
            blnres = logoutFromActiTime(oBrowser);


        } catch (Exception e) {
            System.out.println("Exception in 'TS_CreateAndDeleteUser() ' Test script3_Excelfile");
        }
        finally {
            oBrowser.quit();
            oBrowser=null;
        }
    }
}
