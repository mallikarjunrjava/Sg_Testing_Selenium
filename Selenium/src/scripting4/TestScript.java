package scripting4;

import org.openqa.selenium.WebDriver;
import reflection3.Datatable;
import scripting3_excelfile.ReusableMetods;

import java.lang.reflect.Method;
import java.util.Map;

public class TestScript extends ReusableMetods {
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
