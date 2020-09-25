package blog.baiyan.github.jdk8;

/**
 * @author bai
 * @Description String test
 * @Date 2020/9/24 10:01 AM
 */
public class StringTest {
    public static void main(String[] args) {
        //stringTest01();
        stringTest02();
    }


    private static void stringTest01(){
        String a1 = new String("AA") + new String("BB");
        System.out.println("a1 == a1.intern() " + (a1 == a1.intern()));     // true
        String test = "ABABCDCD";
        String a2 = new String("ABAB") + new String("CDCD");
        String a3 = "ABAB" + "CDCD";
        System.out.println("a2 == a2.intern() " + (a2 == a2.intern()));     // false
        System.out.println("a2 == a3 " + (a2 == a3));                       // false
        System.out.println("a3 == a2.intern() " + (a3 == a2.intern()));     // true

        //底层进行了三次操作 最终常量池中保存的字符串为： 堆中 -> "AABB"、"CCDD"引用地址、"AABBCCDD"的字面字符
        String a4 = new String("AABB") + new String("CCDD");

        String a = "a";
        String b = "abcd";

        boolean bool = b.startsWith(a);
        System.out.println(bool);
    }

    private static void stringTest02(){
        String splitStr1 = "what,is,,,,";
        String[] strs = splitStr1.split(",", -1);
        for (String str : strs) {
            System.out.println(str);
        }
        System.out.println(strs.length);
    }
}
