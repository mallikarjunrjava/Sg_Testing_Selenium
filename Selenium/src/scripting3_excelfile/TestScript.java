package scripting3_excelfile;

import org.openqa.selenium.WebDriver;

import java.util.Map;

public class TestScript extends ReusableMetods {
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
