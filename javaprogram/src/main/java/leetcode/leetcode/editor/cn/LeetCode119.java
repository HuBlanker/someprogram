// 标题:
//      杨辉三角 II

// 描述:
//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组

// 思路:

/**
 * Created by huyanshi on 19009
 * <p>
 * 就是杨辉三角呗,拿到第x行就好了.
 * <p>
 * 拿到完整的杨辉三角, 用的空间为 : 1 + 2 + 3 + ...+ n = O(n2)
 * <p>
 * 但是我们可以不保存中间值, 覆盖掉, 每次只保留上一行和这一行, 每次的下一行使用当前上一行的空间. 这样使用的是 2 * n = O(n)
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.*;

public class LeetCode119 {
    public static void main(String[] args) {
        Solution solution = new LeetCode119().new Solution();
        System.out.println(solution.getRow(3));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            if (rowIndex < 0) {
                return new ArrayList<>();
            }
            return generate(rowIndex + 1);
        }


        public List<Integer> generate(int numRows) {
            if (numRows < 1) return new ArrayList<>();

            if (numRows == 1) {
                return Collections.singletonList(1);
            }

            List<Integer> tmp = new ArrayList<>(2);
            tmp.add(1);
            tmp.add(1);
            if (numRows == 2) return tmp;
            int i = 3;
            while (i <= numRows) {
                List<Integer> integers = get(tmp);
                i++;
                tmp = integers;
            }
            return tmp;
        }

        private List<Integer> get(List<Integer> tmp) {
            if (tmp.size() < 2) return new ArrayList<>();
            List<Integer> ret = new ArrayList<>();
            for (int i = 0, j = 1; j < tmp.size(); i++, j++) {
                ret.add(tmp.get(i) + tmp.get(j));
            }
            ret.add(1);
            ret.add(0, 1);
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
