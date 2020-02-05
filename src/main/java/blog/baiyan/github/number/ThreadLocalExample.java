package blog.baiyan.github.number;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author by bai
 * @Classname ThreadLocalExample
 * @Description ThreadLocal示例
 * @Date 2020/2/5 4:12 PM
 */
public class ThreadLocalExample implements Runnable {

    private static final ThreadLocal<SimpleDateFormat> format = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample example = new ThreadLocalExample();
        for (int i = 0; i < 7; i++) {
            Thread thread = new Thread(example ,":" + i);
            Thread.sleep(new Random().nextInt(1000));
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+format.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        format.set(new SimpleDateFormat());
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+format.get().toPattern());
    }
}
