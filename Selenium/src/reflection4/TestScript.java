package reflection4;

import org.openqa.selenium.WebDriver;
import scripting4.ReusableMetods4;

import java.lang.reflect.Method;
import java.util.Map;

/*
Scripting4: Parameterization(Using Excel file) and Object Mapping(Using objectLocator interface)-
            Parameterization(Using Excel file): It is a process of placing the test data in the external source viz,
Excel file, properties file, json file, DB etc
write a wrapper method to read the test data and use them script.
Excel File: Map(key and value pair): Single/multiple set of data can be provided.

Object Mapping(Using objectLocator interface): It is used to map the web elements locator mapping.
*/
public class TestScript extends ReusableMetods4 {

    // Using Reflection Concept:
/*

    public static void main(String[] args) {

        String filePath = null;
        Class cls = null;
        Object obj = null;
        Method script = null;
        try{
            filePath = System.getProperty("user.dir")+"\\Runner\\RunController.xlsx";
            int rowCount = reflection3.Datatable.getRowCount(filePath, "Runner");
            for(int i=0; i<=rowCount; i++){
                String scriptName = reflection3.Datatable.getCellData(filePath, "Runner", "TestScript", i);
                String packageName = reflection3.Datatable.getCellData(filePath, "Runner", "packageName", i);
                String executeTest = Datatable.getCellData(filePath, "Runner", "ExecuteTest", i);

                if(executeTest.equalsIgnoreCase("Yes")){
                    cls = Class.forName(packageName);
                    obj = cls.getDeclaredConstructor().newInstance();
                    script = obj.getClass().getMethod(scriptName);
                    script.invoke(obj);
                }
            }
        }catch(Exception e){
            System.out.println("Exception in main method: "+e);
        }
    }

*/

/*

    @DataProvider(name="testData", parallel = true)
    public Object[][] data(){
        return new Object[][] {{"Chrome", "http://localhost/login.do", "admin", "manager"},
                {"Edge", "http://localhost/login.do", "admin", "manager"},
                {"FireFox", "http://localhost/login.do", "admin", "manager"},
                {"Chrome", "http://localhost/login.do", "admin", "manager"},
                {"Edge", "http://localhost/login.do", "admin", "manager"},
                {"FireFox", "http://localhost/login.do", "admin", "manager"}};
    }

    @Test(dataProvider ="testData")
    public static void TS_LoginLogoutDataProvider(String browser, String appURL, String userName, String password ){
        WebDriver oBrowser=null;
        try {
            oBrowser=launchBrowser(browser);
            boolean bln = navigateURL(oBrowser,appURL);
            bln=loginToApplication(oBrowser, userName, password);
            bln=logoutFromActiTime(oBrowser);

        } catch (Exception e) {
            System.out.println("Exception in 'TS_LoginLogoutDataProvider() ' Test script3_Excelfile");;
        }
        finally {
            oBrowser.quit();
            oBrowser=null;
        }
    }
*/

   /* @Parameters(value = {"browser","appURL","userName","password"})
    @Test
    public static void TS_LoginLogoutParameter(String browser, String appURL, String userName, String password ){
        WebDriver oBrowser=null;
        try {
            oBrowser=launchBrowser(browser);
            boolean bln = navigateURL(oBrowser,appURL);
            bln=loginToApplication(oBrowser, userName, password);
            bln=logoutFromActiTime(oBrowser);

        } catch (Exception e) {
            System.out.println("Exception in 'TS_LoginLogoutParameter() ' Test script3_Excelfile");;
        }
        finally {
            oBrowser.quit();
            oBrowser=null;
        }
    }

    @Test
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

    @Test
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
    }*/
/*
    @Test
    public static void TS_LoginLogout1(){
        WebDriver oBrowser=null;
        Map<String, String> data = null;
        try {
            data = getExcelData("TestData", "TestData", "TC_ID_001");
            oBrowser=launchBrowser(data.get("browserName"));
            boolean bln = navigateURL(oBrowser, data.get("url"));
            bln=loginToApplication(oBrowser, data.get("userName"), data.get("password"));
            bln=logoutFromActiTime(oBrowser);

        } catch (Exception e) {
            System.out.println("Exception in 'TS_LoginLogout1() ' Test script3_Excelfile");;
        }
        finally {
            oBrowser.quit();
            oBrowser=null;
        }
    }
    @Test
    public static void TS_LoginLogout2(){
        WebDriver oBrowser=null;
        Map<String, String> data = null;
        try {
            data = getExcelData("TestData", "TestData", "TC_ID_001");
            oBrowser=launchBrowser(data.get("browserName"));
            boolean bln = navigateURL(oBrowser, data.get("url"));
            bln=loginToApplication(oBrowser, data.get("userName"), data.get("password"));
            bln=logoutFromActiTime(oBrowser);

        } catch (Exception e) {
            System.out.println("Exception in 'TS_LoginLogout2() ' Test script3_Excelfile");;
        }
        finally {
            oBrowser.quit();
            oBrowser=null;
        }
    }
    @Test
    public static void TS_LoginLogout3(){
        WebDriver oBrowser=null;
        Map<String, String> data = null;
        try {
            data = getExcelData("TestData", "TestData", "TC_ID_001");
            oBrowser=launchBrowser(data.get("browserName"));
            boolean bln = navigateURL(oBrowser, data.get("url"));
            bln=loginToApplication(oBrowser, data.get("userName"), data.get("password"));
            bln=logoutFromActiTime(oBrowser);

        } catch (Exception e) {
            System.out.println("Exception in 'TS_LoginLogout3() ' Test script3_Excelfile");;
        }
        finally {
            oBrowser.quit();
            oBrowser=null;
        }
    }
    @Test
    public static void TS_LoginLogout4(){
        WebDriver oBrowser=null;
        Map<String, String> data = null;
        try {
            data = getExcelData("TestData", "TestData", "TC_ID_001");
            oBrowser=launchBrowser(data.get("browserName"));
            boolean bln = navigateURL(oBrowser, data.get("url"));
            bln=loginToApplication(oBrowser, data.get("userName"), data.get("password"));
            bln=logoutFromActiTime(oBrowser);

        } catch (Exception e) {
            System.out.println("Exception in 'TS_LoginLogout4() ' Test script3_Excelfile");;
        }
        finally {
            oBrowser.quit();
            oBrowser=null;
        }
    }
    @Test
    public static void TS_LoginLogout5(){
        WebDriver oBrowser=null;
        Map<String, String> data = null;
        try {
            data = getExcelData("TestData", "TestData", "TC_ID_001");
            oBrowser=launchBrowser(data.get("browserName"));
            boolean bln = navigateURL(oBrowser, data.get("url"));
            bln=loginToApplication(oBrowser, data.get("userName"), data.get("password"));
            bln=logoutFromActiTime(oBrowser);

        } catch (Exception e) {
            System.out.println("Exception in 'TS_LoginLogout5() ' Test script3_Excelfile");;
        }
        finally {
            oBrowser.quit();
            oBrowser=null;
        }
    }*/
}
