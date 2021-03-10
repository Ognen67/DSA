package com.github.ognen67.exercises.lists;

public class WaterBottles {

    public static int numWaterBottles(int numBottles, int numExchange) {

        int result = numBottles;
        int temp = numBottles;

        while(temp/numExchange != 0) {
            result += temp/numExchange;
            temp = temp%numExchange + temp/numExchange;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(15, 4));
    }
}
