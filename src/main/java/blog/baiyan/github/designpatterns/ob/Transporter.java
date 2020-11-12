package blog.baiyan.github.designpatterns.ob;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bai
 * @Description 具体的被观察者
 * @Date 2020/11/12 10:54 AM
 */
public class Transporter implements Watched{

    List<Watcher> watcherList = new ArrayList<>();

    @Override
    public void addWatcher(Watcher watcher) {
        watcherList.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        watcherList.remove(watcher);
    }

    @Override
    public void notifyWatchers() {
        for (Watcher watcher : watcherList) {
                watcher.update();
        }
    }
}
