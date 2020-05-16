package blog.baiyan.github.thread;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author by bai
 * @Classname ThreadExecutor
 * @Description 创建线程池
 * @Date 2020/2/5 7:39 PM
 */
public class ThreadExecutor {

    /** 同时运行核心线程数量 **/
    private static final int CORE_POOL_SIZE = 5;
    /** 最大线程数量 **/
    private static final int MAX_POOL_SIZE = 10;
    /** 队列容量，会先判断当前线程是否大于核心线程数量、大于则加入队列 **/
    private static final int QUEUE_CAPACITY = 100;
    /** keep等待时间、当线程数量大于核心线程数量会等待、如果超出设置时间则会被删除线程 **/
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 7; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            MyRunnable runnable = new MyRunnable(" " + i);
            executor.execute(runnable);
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()){
        }
        System.out.println("Finished all threads");
    }
}

/**
 * 这是一个简单的Runnable类，需要大约5秒钟来执行其任务。
 */
class MyRunnable implements Runnable{

    private String command;

    public MyRunnable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
