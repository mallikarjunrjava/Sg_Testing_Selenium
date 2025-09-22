package POM2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    WebDriver oDriver;
    LoginPage(WebDriver oBrowser){
        this.oDriver = oBrowser;
    }
    public By obj_UserName_Edit = By.xpath("//input[@id='username']");
    public By obj_Password_Edit = By.xpath("//input[@name='pwd']");
    public By obj_Login_Button = By.xpath("//a[@id='loginButton']");
    public By obj_Login_Header = By.id("headerContainer");
    public By obj_Login_Logo_image = By.xpath("//img[contains(@src, 'timer.png')]");
    public By obj_Homepage_Header = By.xpath("//td[@class='pagetitle']");
    public By obj_Logout_Link = By.xpath("//a[@id='logoutLink']");

    public boolean verifyLoginLogoExist(){
        Assert.assertTrue(oDriver.findElement(obj_Login_Logo_image).isDisplayed(), "Failed to locate the Login Logo image");
        return true;
    }


    public boolean verifyLoginHeaderExist(){
        Assert.assertTrue(oDriver.findElement(obj_Login_Header).isDisplayed(), "Failed to locate the Login header");
        Assert.assertEquals(oDriver.findElement(obj_Login_Header).getText(), "Please identify yourself", "Invalid login header text is displayed");
        return true;
    }


    public boolean loginToActiTime(String userName, String password) {
        try {
            oDriver.findElement(obj_UserName_Edit).sendKeys(userName);
            oDriver.findElement(obj_Password_Edit).sendKeys(password);
            oDriver.findElement(obj_Login_Button).click();
            Thread.sleep(2000);
            Assert.assertEquals(oDriver.findElement(obj_Homepage_Header).getText(), "Enter Time-Track", "Failed to login to ActiTime");
            return true;
        }catch (InterruptedException e) {
            System.out.println("Exception in 'loginToActiTime()' method. "+e);
            return false;
        }
    }


    public boolean logoutFromApplication(){
        try{
            oDriver.findElement(obj_Logout_Link).click();
            Thread.sleep(2000);
            Assert.assertTrue(oDriver.findElement(obj_Login_Logo_image).isDisplayed(), "Failed to Logout from the application");
            return true;
        }catch (Exception e) {
            System.out.println("Exception in 'logoutFromApplication()' method. "+e);
            return false;
        }
    }
}
