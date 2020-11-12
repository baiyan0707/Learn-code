package blog.baiyan.github.designpatterns.ob;

/**
 * @author by bai on 2020/11/12 10:50 AM
 * @Deprecated 被观察者
 */
public interface Watched {

    void addWatcher(Watcher watcher);

    void removeWatcher(Watcher watcher);

    void notifyWatchers();

}
