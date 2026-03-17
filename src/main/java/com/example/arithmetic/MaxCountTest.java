package com.echo.javademo.arithmetic;


import org.python.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;

public class MaxCountTest {

    public static void main(String[] args) {
        String[] str = {"aab", "b", "ccc", "aab"};
        String maxCountWord = getMaxCountWord(str);
        System.out.println(maxCountWord);
    }

    /**
     * 求字符串数组中最长的字符串
     * @param s
     * @return
     */
    public static String getMaxCountWord(String[] s) {
        // 入参校验
        if (s.length == 1) return s[0];

        HashMap<String, Integer> map = Maps.newHashMap();
        for (int i = 0; i < s.length; i++) {
            if (!map.containsKey(s[i])) {
                map.put(s[i], 1);
            } else {
                // key为单词，value为单词出现的次数
                map.put(s[i], map.get(s[i]) + 1);
            }
        }

        // 方法二：
        int max = 0;
        String str = null;
        for (Map.Entry m : map.entrySet()) {
            if ((int) m.getValue() > max) {
                max = (int) m.getValue();
                str = (String) m.getKey();
            }
        }
        return str;

        // 方法一：
        // 比较value的大小，返回value最大时返回的key值
//        ArrayList<Integer> list = Lists.newArrayList();
//        HashMap<Integer, String> map2 = Maps.newHashMap();
//        for (Map.Entry m : map.entrySet()) {
//            list.add((Integer) m.getValue());
//            map2.put((Integer) m.getValue(), (String) m.getKey());
//        }
//
//        // 对list排序，找到最大值，然后到map2中作为key取出相应的value
//        Collections.sort(list);
//        // 1,2,3,5
//        // String resultStr = map2.get(list.size()-1);// map2.get(list.get(list.size()-1))
//        String resultStr = map2.get(list.get(list.size()-1));// map2.get(list.get(list.size()-1))

//        return null;
        //return resultStr;
    }


}
