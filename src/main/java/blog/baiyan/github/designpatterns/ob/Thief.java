package blog.baiyan.github.designpatterns.ob;

/**
 * @author bai
 * @Description 具体的观察者 - 强盗
 * @Date 2020/11/12 10:52 AM
 */
public class Thief implements Watcher {
    @Override
    public void update() {
        System.out.println("强盗的具体类...");
    }
}
