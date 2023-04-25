package com.rollerwinne.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>给你一个字符串数组 <code>names</code> ，和一个由 <strong>互不相同</strong> 的正整数组成的数组 <code>heights</code> 。两个数组的长度均为 <code>n</code> 。</p>
 *
 * <p>对于每个下标 <code>i</code>，<code>names[i]</code> 和 <code>heights[i]</code> 表示第 <code>i</code> 个人的名字和身高。</p>
 *
 * <p>请按身高 <strong>降序</strong> 顺序返回对应的名字数组 <code>names</code> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>names = ["Mary","John","Emma"], heights = [180,165,170]
 * <strong>输出：</strong>["Mary","Emma","John"]
 * <strong>解释：</strong>Mary 最高，接着是 Emma 和 John 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * <strong>输出：</strong>["Bob","Alice","Bob"]
 * <strong>解释：</strong>第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>n == names.length == heights.length</code></li>
 * <li><code>1 &lt;= n &lt;= 10<sup>3</sup></code></li>
 * <li><code>1 &lt;= names[i].length &lt;= 20</code></li>
 * <li><code>1 &lt;= heights[i] &lt;= 10<sup>5</sup></code></li>
 * <li><code>names[i]</code> 由大小写英文字母组成</li>
 * <li><code>heights</code> 中的所有值互不相同</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>字符串</li><li>排序</li></div></div><br><div><li>👍 69</li><li>👎 0</li></div>
 */
class SortThePeople {
    public static void main(String[] args) {
        Solution solution = new SortThePeople().new Solution();
        System.out.println(Arrays.toString(solution.sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            int n = names.length;
            Integer[] indices = new Integer[n];
            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }
            Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);
            String[] res = new String[n];
            for (int i = 0; i < n; i++) {
                res[i] = names[indices[i]];
            }
            return res;
        }
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/sort-the-people/solutions/2242694/an-shen-gao-pai-xu-by-leetcode-solution-p6bk/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * Tree
     */
    class Solution1 {
        public String[] sortPeople(String[] names, int[] heights) {
            Map<Integer, String> map = new TreeMap<>(Comparator.comparingInt(Integer::intValue).reversed());
            for (int i = 0; i < names.length; i++) {
                map.put(heights[i], names[i]);
            }
            return map.values().toArray(new String[0]);
        }
    }

    /**
     * quick sort
     */
    class Solution2 {
        public String[] sortPeople(String[] names, int[] heights) {
            quickSort(names, heights, 0, names.length - 1);
            return names;
        }

        public void quickSort(String[] names, int[] heights, int start, int end) {
            if (start >= end)
                return;
            int i = start, j = end, base = heights[start], temp;
            String baseStr = names[start], tmp;
            while (i < j) {
                while (heights[j] <= base && i < j) {
                    j--;
                }
                while (heights[i] >= base && i < j) {
                    i++;
                }
                temp = heights[i];
                tmp = names[i];
                heights[i] = heights[j];
                names[i] = names[j];
                heights[j] = temp;
                names[j] = tmp;
            }
            heights[start] = heights[i];
            names[start] = names[i];
            heights[i] = base;
            names[i] = baseStr;
            quickSort(names, heights, start, i - 1);
            quickSort(names, heights, i + 1, end);
        }
    }

}