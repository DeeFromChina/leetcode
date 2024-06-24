package org.example;

public class BestExample {

    public static void main(String[] args) {
        exmple1();
    }

    public static void exmple1() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }

    /**
     * 通过二分法插入值，通过将目标值前后的数组下标不断缩小范围，从而找到目标值
     * l：最前的数组下标
     * r：最后的数组下标
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int mid =0;
        while(l<=r){
            mid = (l+r)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                l=mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
}
