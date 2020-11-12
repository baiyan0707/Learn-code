package blog.baiyan.dataframework;

import java.util.Arrays;

/**
 * @author bai
 * @Description Stack 数据结构
 * @Date 2020/9/25 2:32 PM
 */
public class Stack {

    private Object[] objArray;

    private int maxSize;

    private int top;

    public Stack(){};

    public Stack(int maxSize){
        if(maxSize > 0){
            objArray = new Object[maxSize];
            this.maxSize = maxSize;
            top = -1;
        }else {
            throw new RuntimeException("初始化大小失败...");
        }
    }

    /**
     * 动态扩容
     */
    public void grow(){
        if(top == maxSize-1){
            // << 左移运算符，1表示乘以2的1次方
            maxSize = maxSize<<1;
            objArray = Arrays.copyOf(objArray,maxSize);
        }
    }

    /**
     * 查看栈顶
     */
    public Object top(){
        if(top != -1){
            return objArray[top];
        }else {
            throw new RuntimeException("stack is null");
        }
    }

    /**
     * 入栈
     */
    public void push(Object obj){
        //扩容
        grow();
        //++在前表示先运算再赋值，优先级高，在后表示先赋值再运算，优先级低
        objArray[++top] = obj;
    }

    /**
     * 出栈
     */
    public Object pop(){
        Object obj = top();
        objArray[top--] = null;
        return obj;
    }

    /**基于链式存储，不连续存储的非线性实现**/
    private static class Node<Object>{
        private final Object data;

        private Node next;

        public Node(Object data,Node next){
            this.data = data;
            this.next = next;
        }
    }

    private Node nodeTop;

    private int size;

    public void nodePush(Object obj){
        //栈顶指向新元素，新元素的next指向原栈顶元素
        nodeTop = new Node(obj,nodeTop);
        size++;
    }

    public Object nodePop(){
        Node old = nodeTop;
        // 通知 GC 可以回收该空间
        old.next = null;

        // 栈顶指向下一个元素
        nodeTop = null;
        size--;

        return old.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for(Node node = nodeTop; node != null; node = node.next){
            sb.append(node.data.toString()).append(" ");
        }
        return sb.toString()+"]";
    }

    public static void main(String[] args) {
        /*Stack stack = new Stack(1);
        stack.push("123");
        stack.push("abc");
        stack.push("a8");

        while (stack.top != -1){
            System.out.println(stack.pop());
        }
        System.out.println(stack.top());*/

        Stack stack1 = new Stack();
        stack1.nodePush("111");
        stack1.nodePush("222");
        stack1.nodePush("aaa");
        stack1.nodePush("bbb");

        System.out.println(stack1);

        while (stack1.size > 1){
            System.out.println(stack1.nodePop());
            System.out.println(stack1);
        }
    }
}
