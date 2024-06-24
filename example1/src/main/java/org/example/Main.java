package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] a = new int[2];
        for(int i = 0; i < nums.length; i++){
            int c = nums[i];
            int b = target-c;
            if(map.containsKey(b)){
                a[0] = map.get(b);
                a[1] = i;
                map.clear();
                break;
            }else if(!map.containsKey(c)){
                map.put(c, i);
            }
        }
        return a;
    }
}