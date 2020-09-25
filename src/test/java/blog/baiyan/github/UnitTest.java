package blog.baiyan.github;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author by bai
 * @Classname blog.baiyan.github.UnitTest
 * @Description 这是一个测试类
 * @Date 2020/2/5 4:12 PM
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UnitTest {

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Test
    public void unitTest01(){
       String str1 = "白";
       String str2 = "白";
       String str3 = "冠心病";
       String str4 = "感冒";
       String str5 = "肥胖";

       List<String> list = new ArrayList<>();
       list.add(str1);
       list.add(str2);
       list.add(str3);
       list.add(str4);
       list.add(str5);
        System.out.println(list);
    }

    @Test
    public void unitTest02() {
        Thread thread1 = new Thread(this::unitTest01);
        // thread.start();
        Thread thread2 = new Thread(this::unitTest03);
        thread2.start();
    }

    @Test
    public void unitTest03(){
        String res = CompletableFuture.supplyAsync(() -> "hello").thenCombine(CompletableFuture.supplyAsync(() -> "world"), (s1, s2) -> s1 + " " + s2).join();

        System.out.println(res);
    }
}

