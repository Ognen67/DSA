package com.github.ognen67.exercises.lists;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int last = nums.length-1;
        int m = nums.length;

        for(int i=0; i<m; i++) {
            if(nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[last];
                nums[last] = temp;
                last--;
                m--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};

        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));

    }
}
