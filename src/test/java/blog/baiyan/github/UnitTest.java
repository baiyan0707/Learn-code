package blog.baiyan.github;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

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

    private final static Logger LOGGER = LoggerFactory.getLogger(UnitTest.class);

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Test
    public void unitTest(){
        ValueOperations<String,String> ops = redisTemplate.opsForValue();
        ops.set("test","test-01");

        String o = ops.get("test");
        log.info("o:{}",o);
        LOGGER.info("o:{}",o);

        Boolean flag = redisTemplate.delete("test");

        log.warn("result:{}",flag);
    }
}

