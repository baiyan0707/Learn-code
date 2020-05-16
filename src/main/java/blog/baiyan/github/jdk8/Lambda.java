package blog.baiyan.github.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author bai
 * @Description Lambda表达式
 * @Date 2020/2/7 3:48 PM
 */
public class Lambda {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Optional<String> optional = names.parallelStream().sorted().reduce((a, b) -> a + "#" + b);
        optional.ifPresent(System.out::println);
        System.out.println("-------");

        String str = Stream.of("a", "b", "C", "D", "e", "F").filter(x -> x.compareTo("Z") > 0).reduce("", String::concat);
        System.out.println(str);
        System.out.println("-------");

        System.out.println(String.format("1,%o",2));
        System.out.println("-------");

        Runnable task = () ->{
            String threadName = Thread.currentThread().getName();
            System.out.println("hello "+threadName);
        };
        task.run();
        Thread thread = new Thread(task);
        thread.start();
    }
}
