package blog.baiyan.github.designpatterns.ob;

/**
 * @author bai
 * @Description 观察者模式测试类
 * @Date 2020/11/12 10:56 AM
 */
public class Test {
    public static void main(String[] args) {
        Transporter transporter = new Transporter();

        Police police = new Police();
        Security security = new Security();
        Thief thief = new Thief();

        transporter.addWatcher(police);
        transporter.addWatcher(security);
        transporter.addWatcher(thief);

        transporter.notifyWatchers();
    }
}
