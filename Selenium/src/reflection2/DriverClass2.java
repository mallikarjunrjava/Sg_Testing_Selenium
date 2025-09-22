package reflection2;
/*

II. by running static block alone
Class cls = Class.forName(<pkgName.className>);
*/

public class DriverClass2 {
    public static void main(String[] args) {
        try{
            Class.forName("reflection2.TestScript2");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
