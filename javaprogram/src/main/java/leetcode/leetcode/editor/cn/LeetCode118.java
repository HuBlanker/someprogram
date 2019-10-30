// 标题:
//      杨辉三角

// 描述:
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组

// 思路:

/**
 * Created by huyanshi on 191009
 *
 * 单独处理掉第一行和第二行.
 *
 * 之后每一行, 将上一行的两两相加放入列表中, 列表首位和末尾各自添加一个1即可.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import com.google.common.collect.Lists;

import java.util.*;

public class LeetCode118 {
    public static void main(String[] args) {
        Solution solution = new LeetCode118().new Solution();
        System.out.println(solution.generate(5));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            if (numRows < 1) return new ArrayList<>();
            List<List<Integer>> ret = new ArrayList<>();

            ret.add(Collections.singletonList(1));
            if (numRows == 1) {
                return ret;
            }

            List<Integer> tmp = new ArrayList<>(2);
            tmp.add(1);
            tmp.add(1);
            ret.add(tmp);
            if (numRows == 2) return ret;
            int i = 3;
            while (i <= numRows) {
                List<Integer> integers = get(tmp);
                ret.add(integers);
                i++;
                tmp = integers;
            }
            return ret;
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
