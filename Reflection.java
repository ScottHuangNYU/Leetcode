import Tree.InorderTraversal;
import leetcode.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args){
        Class myInorderTraversal = InorderTraversal.class;
        Class myTest = test.class;

        Method[] methods = myInorderTraversal.getMethods();

//        for(Method method: methods){
//            System.out.println(method);
//        }

        Field[] fields = myTest.getFields();
        Field[] privateFields = myTest.getDeclaredFields();

        for(Field field: fields){
            System.out.println(field);
        }
        System.out.println("----------");
        for(Field field: privateFields){
            System.out.println(field);
        }
    }
}
