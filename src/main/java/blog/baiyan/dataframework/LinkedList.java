package blog.baiyan.dataframework;

/**
 * @author bai
 * @Description LinkedList 数据结构
 * @Date 2020/9/25 6:18 PM
 */
public class LinkedList {
    /***
     * 链表通常由一连串节点组成，每个节点包含任意的实例数据（data fields）和一或两个用来指向上一个/或下一个节点的位置的链接（"links"）
     */
    private Node head; //链表头
    private Node tail; //链表尾
    private int size; //节点数

    /**
     * 双端链表
     */
    private static class Node{
        private final Object data;
        private Node prev;  // 上一个
        private Node next;  // 下一个

        public Node(Object data){
            this.data = data;
        }
    }

    public LinkedList(){
        this.tail = null;
        this.head = null;
        this.size = 0;
    }

    /**
     * 向链表头添加数据
     */
    public void addHead(Object obj){
        Node node = new Node(obj);
        if(size == 0){
            head = node;
            tail = node;
        }else {
            head.next = node;
            node.next = node;
            head = node;
        }
        size++;
    }

    /**
     * 删除头
     */
    public void deleteHead(){
        if(size != 0){
            head.prev = null;
            head = head.next;
            size--;
        }
    }

    /**
     * 向链表尾部添加数据
     */
    public void addTail(Object obj){
        Node node = new Node(obj);
        if(size == 0){
            head = node;
            tail = node;
            size++;
        }else {
            node.prev = node;
            tail.next = node;
            tail = node;
            size++;
        }
    }

    /**
     * 删除尾部
     */
    public void deleteTail(){
        if(size != 0){
            tail.next = null;
            tail = tail.prev;
            size--;
        }
    }

    /**
     * 打印
     */
    public void print(){
        Node node = this.head;
        while (size > 0){
            System.out.print("["+node.data+"->");
            node = node.next;
            size--;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addHead("123");
        linkedList.addTail("abc");
        linkedList.print();
        linkedList.deleteHead();
        linkedList.deleteTail();
        linkedList.print();
    }
}
