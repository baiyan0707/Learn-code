package blog.baiyan.sort;

import java.util.Arrays;

/**
 * @author bai
 * @Description 二分插入排序,取出第一个元素和每一个元素进行对比再排序
 * @Date 2020/10/19 11:02 AM
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,6,7,3,1,9};
        insertionSort02(arr);
    }

    /**
     * 冒泡排序 交换9次
     * @param arr
     */
    private static void insertionSort01(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1 ; j > 0; j--) {
                if(arr[j-1] >= arr[j]){
                    break;
                }
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    /**
     * toString 交换5次
     * temp 交换6次
     * @param arr
     */
    private static void insertionSort02(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j >= 0 ; j--) {
                if(j > 0 && arr[j - 1] > temp){
                    arr[j] = arr[j - 1];
                    System.out.println("Temp: " + Arrays.toString(arr));
                }else {
                    arr[j] = temp;
                    System.out.println("ToString: " + Arrays.toString(arr));
                    break;
                }
            }
        }
    }
}
