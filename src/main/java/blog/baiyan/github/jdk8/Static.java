package blog.baiyan.github.jdk8;

/**
 * @author bai
 * @Description static 静态化
 * @Date 2020/4/23 12:16 PM
 * @github https://github.com/baiyan0707
 */
public class Static {

    public Static() {
        System.out.print("默认构造方法！--");
    }

    //非静态代码块
    {
        System.out.print("非静态代码块！--");
    }

    //静态代码块
    static {
        System.out.print("静态代码块！--");
    }

    private static void test() {
        System.out.print("静态方法中的内容! --");
        {
            System.out.print("静态方法中的代码块！--");
        }
    }

    public static void main(String[] args) {
        Static aStatic = new Static();
        System.out.println();
        Static.test();
    }
}
