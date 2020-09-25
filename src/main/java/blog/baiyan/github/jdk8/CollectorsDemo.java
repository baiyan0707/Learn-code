package blog.baiyan.github.jdk8;

import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author bai
 * @Description 容器测试
 * @Date 2020/7/21 6:47 PM
 * @github https://github.com/baiyan0707
 */
public class CollectorsDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        Hashtable<String, String> hashtable = new Hashtable<>();
        map.put("aa","AA");
        hashtable.put("bb","BB");
        BeanUtils.copyProperties(map,hashtable);
        System.out.println(map);
        System.out.println(hashtable);
    }
}
