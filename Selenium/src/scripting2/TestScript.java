package scripting2;

import org.openqa.selenium.WebDriver;

public class TestScript extends ReusableMetods {
    public static void main(String[] args) {
            TS_LoginLogout();
            TS_CreateAndDeleteUser();
    }

    public static void TS_LoginLogout(){
            WebDriver oBrowser=null;
        try {
            oBrowser=launchBrowser("chrome");
            boolean bln = navigateURL(oBrowser, "http://localhost/login.do");
            bln=loginToApplication(oBrowser, "admin", "manager");
            bln=logoutFromActiTime(oBrowser);

        } catch (Exception e) {
            System.out.println("Exception in 'TS_LoginLogout() ' Test script");;
        }
        finally {
            oBrowser.quit();
            oBrowser=null;
        }
    }

    public static void TS_CreateAndDeleteUser(){
            WebDriver oBrowser=null;
        try {
            oBrowser=launchBrowser("chrome");
            boolean blnres = navigateURL(oBrowser, "http://localhost/login.do");
            blnres=loginToApplication(oBrowser, "admin", "manager");
            String userName = createUser(oBrowser);
            blnres = deleteUser(oBrowser,userName);
            blnres = logoutFromActiTime(oBrowser);


        } catch (Exception e) {
            System.out.println("Exception in 'TS_CreateAndDeleteUser() ' Test script");;
        }
        finally {
            oBrowser.quit();
            oBrowser=null;
        }
    }
}
