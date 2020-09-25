package blog.baiyan.dataframework;

/**
 * @author bai
 * @Description Array 数据结构
 * @Date 2020/9/25 1:56 PM
 */
public class Array {
    private final int[] intArray;

    private int elems;

    private final int length;

    public Array(int max){
        length = max;
        intArray = new int[max];
        elems = 0;
    }

    /**
     * 添加
     * @param val
     */
    private void add(int val){
        if(elems == length){
            System.out.println("error....");
            return;
        }
        intArray[elems] = val;
        elems++;
    }

    /**
     * 查询
     * @param searchKey
     * @return
     */
    private int find(int searchKey){
        int i;
        for (i = 0; i < elems; i++) {
            if(intArray[i] == searchKey){
                break;
            }
        }
        if(elems == i){
            return -1;
        }
        return i;
    }

    /**
     * 删除
     * @param index
     * @return
     */
     private boolean delete(int index){
         int i = find(index);
         if(i == -1){
             return false;
         }
         // 数据前移
         if (elems - 1 - i >= 0) {
             System.arraycopy(intArray, i + 1, intArray, i, elems - 1 - i);
         }
         elems--;
         return true;
     }

    /**
     * 更新数据
     * @param oldVal
     * @param newVal
     * @return
     */
     private boolean update(int oldVal,int newVal){
         int i = find(oldVal);
         if(i == -1){
             return false;
         }
         intArray[i] = newVal;
         return true;
     }

    /**
     * 打印输出
     */
    private void print(){
         for (int i = 0; i < elems; i++) {
             System.out.print(intArray[i] + " ");
         }
         System.out.print("\n");
     }

    /**
     * 冒泡排序
     * 每趟冒出一个最大数/最小数
     * 每次运行数量：总数量-运行的趟数(已冒出)
     */
    private void bubbleSort(){
         for (int i = 0; i < elems -1; i++) {
             System.out.printf("第%d次查询\n",(i+1));
             for (int j = 0; j < elems -i -1; j++) {
                if(intArray[j+1] < intArray[j]){
                    int temp = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = temp;
                }
                 print();
             }
         }
     }

    /***
     * 选择排序
     * 每趟选择一个最大数/最小数
     * 每次运行数量：总数量-运行的趟数(已选出)
     */
    private void selectSort(){
        for (int i = 0; i < elems-1; i++) {
            int min = i;
            for (int j = i+1; j < elems; j++) {
                if(intArray[j] < intArray[min]){
                    min = j;
                }
            }
            if(i != min){
                int temp = intArray[i];
                intArray[i] = intArray[min];
                intArray[min] = temp;
            }
            print();
        }
     }

    /**
     * 插入排序
     * 每趟选择一个待插入的数
     * 每次运行把待插入的数放在比它大/小后面
     */
    private void insertSort(){
        int j;
        for (int i = 1; i < elems; i++) {
            int temp = intArray[i];
            j = i;
            while (temp < intArray[j-1]){
                intArray[j] = intArray[j-1];
                j--;
            }
            intArray[j] = temp;
        }
        print();
    }

    public static void main(String[] args) {
        Array array = new Array(4);
        array.add(1);
        array.add(4);
        array.add(3);
        array.add(2);

        array.bubbleSort();
    }
}
