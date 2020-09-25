package blog.baiyan.github.thread;

import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author bai
 * @Description 多线程 demo
 * @Date 2020/6/2 4:43 PM
 * @github https://github.com/baiyan0707
 */
@Slf4j
public class ThreadTest {

    private static final ThreadLocal<Integer> THREAD_LOCAL = new ThreadLocal<Integer>();

    public static void main01(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < 4; i++) {
                    THREAD_LOCAL.set(i);
                    System.out.println(Thread.currentThread().getName() + "----" + THREAD_LOCAL.get());
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                THREAD_LOCAL.remove();
            }
        }, "thread-01").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 4; i++) {
                    System.out.println(Thread.currentThread().getName() + "----" + THREAD_LOCAL.get());
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                THREAD_LOCAL.remove();
            }
        }, "thread-02").start();
    }

    public static void main(String[] args) {
        // 获取 Java 线程管理的 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }
}

