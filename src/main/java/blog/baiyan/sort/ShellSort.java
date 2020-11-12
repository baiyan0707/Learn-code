package blog.baiyan.sort;

import java.util.Arrays;

/**
 * @author bai
 * @Description
 * @Date 2020/10/19 1:54 PM
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,6,7,2,9,8};
        shellSort(arr);
    }

    private static void shellSort(int[] arr){
        int gap = 1, i, j, len = arr.length;
        int temp;
        while (gap < len / 3) {
            // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
            gap = gap * 3 + 1;
        }
        for (; gap > 0; gap /= 3) {
            for (i = gap; i < len; i++) {
                temp = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}
