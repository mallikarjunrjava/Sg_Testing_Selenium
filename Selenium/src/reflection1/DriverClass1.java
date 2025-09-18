package reflection1;

import java.lang.reflect.Method;

public class DriverClass1 {
    public static void main(String[] args) {
        TestScript1 test = null;
        try{
            test = new TestScript1();
            Method[] scripts = test.getClass().getMethods();
            for(int i=0; i<scripts.length; i++){
                if(scripts[i].getName().contains("User")){
                    scripts[i].invoke(test);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
