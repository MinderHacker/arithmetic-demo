package com.example.arithmetic;

import org.python.google.common.collect.Maps;

import java.util.HashMap;

/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 2026/3/18 14:26
 * 某个元素只出现一次以外，其余每个元素均出现两次，找出1次的
 * 输入：nums = [2,2,1]
 * 输出：1
 */
public class SingleNumberTest {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        int singleNumber = singleNumber(nums);
        System.out.println(singleNumber);
    }
    
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
}
