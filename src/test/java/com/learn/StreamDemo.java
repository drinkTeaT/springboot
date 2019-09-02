package com.learn;


import java.util.Arrays;
import java.util.List;

/**
 * Description: null
 * Author: tacbin
 * Date: 2019-09-01 19:21
 **/
public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        StreamDemo demo = new StreamDemo();
        demo.forStyle(nums);
        demo.streamStyle(nums);
    }

    public void streamStyle(List<Integer> nums) {
        int sum = nums.stream().filter(x -> x % 2 == 0).reduce(0, (a, b) -> a + b * b);
        System.out.println(sum);
    }

    public void forStyle(List<Integer> nums) {
        int sum = 0;
        for (int i : nums) {
            if (i % 2 == 0) {
                sum += i * i;
            }
        }
        System.out.println(sum);
    }
}

