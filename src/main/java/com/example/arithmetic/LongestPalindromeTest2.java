package com.example.arithmetic;
/**
 * @author ANDY
 * @version 1.0
 * @description: TODO
 * @date 18/9/2023 5:03 pm
 */

/**
 * 5. 最长回文子串
 * 提示
 * 中等
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class LongestPalindromeTest2 {
    public static void main(String[] args) {
//        String s = "baacabad";
//        String s = "bb";
        String s = "babad";
        String longestPalindrome = longestPalindrome(s);
        System.out.println(longestPalindrome);
    }


    /*
    1.使用左右指针，先固定左边；
    2.从右向左移动右指针，看是否与左指针字符相等。若相等，再判断左右指针之间的是否是回文数；若不相等，继续
    3.如果是回文数，记下左右指针位置，并计算长度，并保留，留作以后比较。
    4.重复以上操作。
     */
    private static String longestPalindrome2(String A) {

        // left 表示已经确定下来的回文串左边界
        // right 表示已经确定下来的回文串右边界
        int left = 0, right = 0;

        // 遍历每个字符，将每个字符尝试作为回文串的左边界
        for (int i = 0; i < A.length(); i++) {
            for (int j = A.length() - 1; j > i; j--) {
                // 说明这个i位置为左边界已经找到最大的了，跳出内层循环，去外面执行i++
                if (j - i <= right - left) break;

                // 回文子串，那么i和j对应的字符必须是相等的，但是这里并不能判断就决定是回文子串
                if (A.charAt(i) == A.charAt(j)) {
                    // 写一个辅助方法判断字符的i和j位置的子串是否是回文串，是的话，更新left和right
                    if (isPalidrome(A, i, j)) {
                        left = i;
                        right = j;
                    }
                }
            }
            // 如果末尾位置和当前左边界i位置的长度小于已经确定下来的回文子串长度，那么就不必后续遍历i了
            if (A.length() - 1 - i <= right - left) break;
        }

        return A.substring(left, right + 1);
    }

    private static boolean isPalidrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }


    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extent(s, i, i);
            String s2 = extent(s, i, i + 1);
            if (s1.length() > ans.length()) {
                ans = s1;
            }
            if (s2.length() > ans.length()) {
                ans = s2;
            }
        }
        return ans;
    }

    private static String extent(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }


}
