package blog.baiyan.github.designpatterns.single;

/**
 * @author bai
 * @Description 使用静态内部类完成的单例模式
 * @Date 2020/2/23 7:49 PM
 */
public class Singleton {

    private static class SingletonHandler{
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {}

    public static Singleton getInstance(){
        return SingletonHandler.INSTANCE;
    }
}
