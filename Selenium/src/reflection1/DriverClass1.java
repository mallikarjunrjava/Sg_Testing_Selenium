package reflection1;

import java.lang.reflect.Method;
/*
Reflection:
  It is a process of inspecting OR modifying the runtime behaviour of a class at runtime is k.a., Reflection.
Ex:  methods, classes, interfaces, constructor

Note:
1. One advantage of reflection API in Java is, it can manipulate private members of the class too.
2. Most of the reflection members are checked exception. Hence try catch is required.
3. Reflection belongs to java.lang.reflect package

It can be achieved in 3 ways:

I. By creating object to the class. This is used for instance members
 <className> <obj> = new <Constructor>();
*/


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
