package blog.baiyan.github.thread;

import io.netty.util.concurrent.FastThreadLocal;

import java.util.Random;

/**
 * @author bai
 * @Description fastThreadLocal demo
 * @Date 2020/6/2 5:02 PM
 * @github https://github.com/baiyan0707
 */
public class FastThreadLocalTest {
    private static final ThreadLocal[] threadLocals = new ThreadLocal[128];
    private static final FastThreadLocal[] fastThreadLocals = new FastThreadLocal[threadLocals.length];
    private static final Random random = new Random();

    public static void main(String[] args) {

    }
}
