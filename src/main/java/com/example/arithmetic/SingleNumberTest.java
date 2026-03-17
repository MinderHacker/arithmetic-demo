package com.echo.javademo.arithmetic;

/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 22/09/2023 18:02
 */


import java.util.*;

/**
 * 只出现一次的数字
 * 简单
 * 3K
 * 相关企业
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * 示例 1 ：
 * 输入：nums = [2,2,1]
 * 输出：1
 * 示例 2 ：
 * <p>
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * 示例 3 ：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 */
public class SingleNumberTest {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        //int[] nums = {1};
        int singleNumber = singleNumber(nums);
        System.out.println(singleNumber);
    }

    /**
     * 异或运算：同数为零，异数为1
     * 其他元素出现了两次，所以最后会变为0，只出现一次的数会返回
     * @param nums
     * @return
     */
    private static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
            //single =single^num;
        }
        return single;
    }

    /**
     * 使用哈希表来存储键值对，第一次插入，第二次删除，最后的结果只剩下一个元素，就是所要的答案。
     * 随后将哈希表转化为集合，然后用Iterator获取第一个元素即可
     * @param nums
     * @return
     */
//    private static int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (map.containsKey(num)){
//                map.remove(num);
//            } else {
//                map.put(num, 1);
//            }
//        }
//        Set<Integer> set = map.keySet();
//        Iterator<Integer> iterator = set.iterator();
//
//        return iterator.next();
//    }

    /**
     * 给每个数字建立字典
     *
     * @param nums
     * @return
     */
//    private static int singleNumber(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (Integer number : nums) {
//            if (!map.containsKey(number)) {
//                map.put(number, 1);
//            } else {
//                map.put(number, map.get(number) + 1);
//            }
//        }
//
//        for (Map.Entry entry : map.entrySet()) {
//            if (entry.getValue().equals(1)) return (int) entry.getKey();
//        }
//        return 0;
//    }
}
