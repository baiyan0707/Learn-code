package blog.baiyan.github.jdk8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author bai
 * @Description 反射
 * @Date 2020/4/23 12:21 PM
 * @github https://github.com/baiyan0707
 */

public class Reflection {
    public static void main(String[] args) throws Exception {
        /** 获取到目标类的Class对象并创建实例 **/
        Class<?> targetClass = Class.forName("blog.baiyan.github.jdk8.TargetObject");
        /** 第二种获取类对象
        Class<TargetObject> targetClass = TargetObject.class; **/
        /** 第三种获取类对象
        TargetObject targetObject = new TargetObject();
        Class<? extends TargetObject> targetClass = targetClass.getClass(); **/
        TargetObject targetObject = (TargetObject) targetClass.newInstance();
        /** 获取到所有方法 **/
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        /**
         * 修改参数
         */
        Field field = targetClass.getDeclaredField("value");
        field.setAccessible(true);
        field.set(targetObject,"BaiYan");

        /**
         * 公共方法
         */
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject,"BaiYan");

        /**
         * 私有方法
         */
        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);

        /**
         * 静态方法
         */
        Method staticMethod = targetClass.getDeclaredMethod("staticMethod",String.class);
        staticMethod.setAccessible(true);
        staticMethod.invoke(targetObject,"static");
    }
}

