package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T5189 {
    public static void main(String[] args) {
        int a = new Solution().maxNumberOfBalloons("ballonnnbaloolo");
        System.out.println(a);
    }
}

class Solution {
    /**
     * 5189. “气球” 的最大数量
     * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
     * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
     * @param text
     * @return
     */
    public int maxNumberOfBalloons(String text) {
        if (text == null || text.length() < 7)
            return 0;
        Map<String, Integer> map = new HashMap<>();
        String temp = "";
        for (int i = 0; i < text.length(); i++) {
            temp = text.substring(i, i + 1);
            int num = (map.get(temp) == null) ? 0 : map.get(temp);
            map.put(temp, num + 1);
        }
        //System.out.println(map);
        int min = Integer.MAX_VALUE;
        String[] ballonStr = {"b", "a", "l", "o", "n"};
        for (int i = 0; i < ballonStr.length; i++) {
            int num = (map.get(ballonStr[i]) == null) ? 0 : map.get(ballonStr[i]);
            if (i == 2 || i == 3) {
                if (min > num / 2) {
                    min = num / 2;
                }
            } else if (min > num) {
                min = num;
            }
        }
        return min;
        /**
         * 总结:
         * 没必要用Map,用个Array就行了
         * 没必要记录所有,只记录5个字母就行了
         * 先把记录数处理掉重复比较好
         */
    }
}