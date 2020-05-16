package blog.baiyan.github.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by bai
 * @Classname AtomicInteger
 * @Description 原子类测试
 * @Date 2020/2/5 8:30 PM
 */
public class Atomic {
    public static void main(String[] args) {

        AtomicInteger atomic = new AtomicInteger(1);
        System.out.println("default value: "+ atomic.get());

        atomic.getAndSet(2);
        System.out.println("new value: "+atomic.get());
    }
}
