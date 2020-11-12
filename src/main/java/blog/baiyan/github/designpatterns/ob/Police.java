package blog.baiyan.github.designpatterns.ob;

/**
 * @author bai
 * @Description 具体的观察者 - 警察
 * @Date 2020/11/12 10:53 AM
 */
public class Police implements Watcher{
    @Override
    public void update() {
        System.out.println("警察的具体类...");
    }
}
