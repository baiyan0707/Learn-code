package blog.baiyan.github.jdk8;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author bai
 * @Description 动态编译测试
 * @Date 2020/5/26 10:19 PM
 * @github https://github.com/baiyan0707
 */
@Transactional
public class JavaCompilerTest {
    public static void main(String[] args) {
        String code = "public class TargetObject {\n" +
                "    public void publicMethod(String s,Integer i) {\n" +
                "        System.out.println(s + i);\n" +
                "    }\n" +
                "\n" +
                "    private void privateMethod(String s, Integer i) {\n" +
                "        System.out.println(s + i);\n" +
                "    }\n" +
                "}";
        CustomStringJavaCompiler compiler = new CustomStringJavaCompiler(code);
        boolean res = compiler.compiler();
        if (res) {
            System.out.println("编译成功");
            System.out.println("compilerTakeTime：" + compiler.getCompilerTakeTime());
            try {
                compiler.runMainMethod("publicMethod","20",30);
                System.out.println("runTakeTime：" + compiler.getRunTakeTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(compiler.getRunResult());
            System.out.println("诊断信息：" + compiler.getCompilerMessage());
        } else {
            System.out.println("编译失败");
            System.out.println(compiler.getCompilerMessage());
        }
    }
}
