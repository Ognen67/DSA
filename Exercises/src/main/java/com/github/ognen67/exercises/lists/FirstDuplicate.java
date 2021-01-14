package com.github.ognen67.exercises.lists;

import java.util.HashSet;

public class FirstDuplicate {

    public int firstDuplicate(int[] nums) {

        HashSet<Integer> map = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(map.contains(nums[i]))
                return nums[i];
            else
                map.add(nums[i]);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 3, 5, 1, 3, 2 };

        FirstDuplicate dup =  new FirstDuplicate();
        int first = dup.firstDuplicate(nums);
        System.out.println(first);
    }
}
