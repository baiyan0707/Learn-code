package blog.baiyan.github.jdk8;

/**
 * @author bai
 * @Description
 * @Date 2020/4/23 12:26 PM
 * @github https://github.com/baiyan0707
 */
public class TargetObject {
    private final String value;

    public TargetObject() {
        value = "baiyan";
    }

    public void publicMethod(String s) {
        System.out.println("My name is " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }

    static void staticMethod(String s){
        System.out.println("static method: " + s);
    }
}
