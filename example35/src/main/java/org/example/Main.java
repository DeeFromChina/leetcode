package org.example;

/**
 * <pre>
 * 题目链接：<a>https://leetcode.cn/problems/search-insert-position/description/</a>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 提示:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        //exmple1();
        //exmple2();
        //exmple3();
        //testExmple1();
        //testExmple2();
        //testExmple3();
        testExmple4();
    }

    public static void exmple1() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }

    public static void exmple2() {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }

    public static void exmple3() {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

    public static void testExmple1() {
        int[] nums = {1};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }

    public static void testExmple2() {
        int[] nums = {1,3};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }

    public static void testExmple3() {
        int[] nums = {1,3,5};
        int target = 6;
        System.out.println(searchInsert(nums, target));
    }

    public static void testExmple4() {
        int[] nums = {1,4999};
        int target = 5488;
        System.out.println(searchInsert(nums, target));
    }

    /**
     * <pre>
     *     解题思路:
     *     由于是有序数组，
     *     1、使用二分法减少循环次数
     *  </>
     */
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        else if(len == 1){
            if(nums[0] >= target){
                return 0;
            }else {
                return 1;
            }
        }
        int midNum = len/2;
        //中位数大于target，取前半截
        if(nums[midNum] > target){
            int prefix_Len = 0;
            int midNum2 = midNum/2;
            return splitNums(nums, prefix_Len, midNum2, target);
        }
        //中位数小于target，取后半截
        else if(nums[midNum] < target) {
            int prefix_Len = midNum;
            int midNum2 = midNum/2;
            if(midNum2 == 0){
                midNum2 = 1;
            }
            return splitNums(nums, prefix_Len, midNum2, target);
        }
        //中位数等于target，取前半截长度
        else {
            return midNum;
        }
    }

    /**
     * 1、一直取前半截
     * 2、一直取后半截
     * 3、先取前半截，再取后半截
     * 4、先取后半截，再取前半截
     */



    //注意无限循环
    //如果一直取后半截也取不到，可能是最后的
    public static int splitNums(int[] nums, int prefix_Len, int midNum, int target) {
        if(midNum <= 3){
            //1、最后一段的前半截
            //2、最后一段的后半截
            for(int i = 0; i <= midNum*2+1; i++){
                if((prefix_Len + i) >= nums.length){
                    return nums.length;
                }
                if(nums[prefix_Len + i] >= target){
                    return prefix_Len + i;
                }
            }
        }
        //中位数大于target，取前半截
        if(nums[prefix_Len + midNum] > target){
            int midNum2 = midNum/2;
            int prefix_Len2 = prefix_Len;
            return splitNums(nums, prefix_Len2, midNum2, target);
        }
        //中位数小于target，取后半截
        else if(nums[prefix_Len + midNum] < target) {
            int prefix_Len2 = prefix_Len + midNum;
            int midNum2 = midNum/2;
            if(midNum2 == 0){
                midNum2 = 1;
            }
            return splitNums(nums, prefix_Len2, midNum2, target);
        }
        //中位数等于target，取前半截长度
        else {
            return prefix_Len + midNum;
        }
    }

}