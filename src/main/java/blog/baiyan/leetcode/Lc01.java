package blog.baiyan.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * 题意：返回数组中和为给定数的下标
 * 难度：Easy
 * 分类：Array, HashTable
 * 算法：题目说明了数组中一定有解，且解唯一，所以用哈希表记录已遍历的元素即可
 */
public class Lc01 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 17;

        int[] r = twoSum(nums,target);
        System.out.println(r[0]);
        System.out.println(r[1]);
    }

    private static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                res[0] = map.get(nums[i]);
                res[1] = i;
            }
            /**
             *  第一次 put： 15，0
             *  第二次 put： 10，1
             *  第三次 put： 11，2
             */
            map.put(target - nums[i],i);
        }
        return res;
    }
}
