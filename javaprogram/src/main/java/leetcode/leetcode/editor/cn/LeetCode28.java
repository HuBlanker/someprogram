// 标题:
//      实现 strStr()

// 描述:
//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串

// 思路:

/**
 * 双指针, 各指向一个, 当父串与子串的第一个相等, 那就指针同时后移, 逐个比较, 如果遇到不相等的, 则从刚才命中子串首位的地方开始第二次遍历.
 * 比如: helooll ,ll
 * 第一次比较 h l 不相等.
 * 第二次比较 e l 不相等.
 * 第三次比较 l l 相等, 继续比较 o l 不相等.
 * 第四次比较 o l 不相等.
 * 第五次比较 l l 相等. 继续比较 l l 相等. 此时子串遍历完,返回索引下标记了.
 * 注意在这个过程中,父串索引有一个回溯的过程,这个过程怎么保存当前值需要注意.
 * <p>
 * 此外,这个题应该还有个KMP解法? 但是我忘记了. 我们可以明显感觉到上面那种粗暴方法里面, 是有一些浪费的, 比如在第三次比较之后, 第四部是已知不相等的.没必要继续比较, KMP就是节省这个过程.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode28 {
    public static void main(String[] args) {
        Solution solution = new LeetCode28().new Solution();
        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("aaaaaa", "bba"));
        System.out.println(solution.strStr("mississippi", "issip"));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle == null || needle.length() == 0) return 0;
            if (haystack == null || haystack.length() == 0) return -1;
            boolean have = false;
            int i = 0;
            for (; i < haystack.length(); ) {
                int j = 0;
                int tmp = i;
                for (; j < needle.length() && tmp < haystack.length(); ) {
                    if (haystack.charAt(tmp) == needle.charAt(j)) {
                        tmp++;
                        j++;
                    } else {
                        break;
                    }
                }
                if (j == needle.length()) {
                    i = tmp;
                    have = true;
                    break;
                } else {
                    i++;
                }
            }
            return have ? i - needle.length() : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
