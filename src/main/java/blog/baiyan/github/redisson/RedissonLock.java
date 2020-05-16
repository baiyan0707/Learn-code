package blog.baiyan.github.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author bai
 * @Description redis分布式锁
 * @Date 2020/2/18 5:31 PM
 */
public class RedissonLock {

    private static Logger logger = LoggerFactory.getLogger(RedissonLock.class);
    private static final String LOCKSTR = "LOCK";

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            runRedisLock();
        }
    }

    /**
     * 注册redisson分布式锁
     * @return
     */
    private static RedissonClient registerRedisLock() {
        Config config = new Config();
        config.useSingleServer()
                //设置redis参数。如果没有密码则直接设置ip和端口即可
                .setAddress("redis://127.0.0.1:6379");

        // 注册redisson锁
        return Redisson.create(config);
    }

    /**
     * 运行redisson锁
     */
    private static void runRedisLock() {
        RedissonClient lock = registerRedisLock();
        RLock rLock = lock.getLock(LOCKSTR);
        try {
            //获取到锁的状态。设置超时时间防止死锁
            rLock.tryLock(3,2, TimeUnit.SECONDS);
            if(rLock.isLocked()){
                System.out.println("抢到锁了...");
            }
        } catch (InterruptedException e) {
            logger.error("redisson error");
        }finally {
            //释放锁
            rLock.unlock();
        }
    }
}
