package blog.baiyan.dataframework;

/**
 * @author bai
 * @Description 队列 数据结构
 * @Date 2020/9/25 3:15 PM
 */
public class Queue {

    /***
     * 1.单向队列（Queue）：只能在一端插入数据，另一端删除数据。
     * 2.双向队列（Deque）：每一端都可以进行插入数据和删除数据操作。
     *
     *  与栈不同的是，队列中的数据不总是从数组的0下标开始的
     *  选择的做法是移动队头和队尾的指针。
     *  为了避免队列不满却不能插入新的数据，我们可以让队尾指针绕回到数组开始的位置，这也称为“循环队列”。
     * */

    // 单向循环队列，顺序存储结构实现
    private Object[] objQueue;
    //队列大小
    private int maxSize;
    //顶部
    private int top;
    //底部
    private int bottom;
    //实际元素
    private int item;

    public Queue(int size){
        maxSize = size;
        objQueue = new Object[maxSize];
        top = 0;
        bottom = -1;
        item = 0;
    }

    /**
     * 入队
     */
    public void add(Object obj){
        if(item == maxSize){
            throw new RuntimeException(obj + "add error,queue is full");
        }
        if(bottom == maxSize-1){
            bottom = -1;
        }
        objQueue[++bottom] = obj;
        item++;
    }

    /**
     * 出队
     */
    public Object out(){
        if(item == 0){
            throw new RuntimeException("queue is null");
        }
        Object obj = objQueue[top];
        // 通知 GC 回收此空间
        objQueue[top] = null;
        top++;

        // 重制下标
        if(top == maxSize){
            top = 0;
        }
        item--;
        return obj;
    }

    // 链式队列
    private class NodeQueue<Object>{

        private Object data;

        private NodeQueue next;

        public NodeQueue(Object data,NodeQueue next){
            this.data = data;
            this.next = next;
        }
    }

    // 队列头 出
    private NodeQueue queueTop;

    // 队列尾 进
    private NodeQueue queueBottom;

    // 队列的大小
    private int size;

    public Queue(){
        queueBottom = null;
        queueTop = null;
        size = 0;
    }

    /**
     * 入队
     */
    public void addQueue(Object obj){
        if(size == 0){
            queueTop = new NodeQueue(obj,null);
            // 指向同一地址
            queueBottom = queueTop;
        }else {
            NodeQueue nodeQueue = new NodeQueue(obj, null);
            // 让尾节点的next指向新的节点
            queueBottom.next = nodeQueue;
            // 尾节点指向 新节点
            queueBottom = nodeQueue;
        }
        size++;
    }

    /**
     * 出队
     */
    public Object outQueue(){
        if(size == 0){
            throw new RuntimeException("Queue is null");
        }
        NodeQueue nodeQueue = queueTop;
        queueTop = queueTop.next;
        nodeQueue.next = null;
        size--;
        return nodeQueue.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        for(NodeQueue nodeQueue = queueTop ; nodeQueue != null ; nodeQueue = nodeQueue.next){
            sb.append(nodeQueue.data.toString()).append(" ");
        }
        return sb.toString()+"}";
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.addQueue("123");
        queue.addQueue("abc");
        queue.addQueue("ddd");
        System.out.println(queue);
        queue.outQueue();
        System.out.println(queue);
        queue.outQueue();
        queue.outQueue();
        System.out.println(queue);
    }
}
