package blog.baiyan.github.designpatterns.ob;

/**
 * @author bai
 * @Description 具体的观察者 - 保安
 * @Date 2020/11/12 10:50 AM
 */
public class Security implements Watcher{
    @Override
    public void update() {
        System.out.println("保安的具体类...");
    }
}
