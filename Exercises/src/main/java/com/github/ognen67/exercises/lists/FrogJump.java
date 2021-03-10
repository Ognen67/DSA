package com.github.ognen67.exercises.lists;

public class FrogJump {

    public boolean canCross(int[] stones) {

        int frogPos = 0;
        int frogJump = 1;

        for (int i = 0; i < stones.length; i++) {
            for (int j = stones.length-1; j >= i+1 ; j--) {
                if(stones[j] - stones[frogPos] <= frogJump) {
                    frogJump = stones[j] - stones[frogPos];
                    frogPos = j;
                    break;
                }
            }
        }

        return frogPos==stones.length-1;

    }

    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        System.out.println(frogJump.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }
}
