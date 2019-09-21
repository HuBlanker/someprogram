# 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
#
# 示例 1: 
#
# 输入: "abcabcbb"
# 输出: 3
# 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
# 
#
# 示例 2: 
#
# 输入: "bbbbb"
# 输出: 1
# 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
# 
#
# 示例 3: 
#
# 输入: "pwwkew"
# 输出: 3
# 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
#      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
# 
# Related Topics 哈希表 双指针 字符串 Sliding Window

# ------------------ theory start ---------------


# ------------------ theory  end  ---------------


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # st = {}
        # i, ans = 0, 0
        # for j in range(len(s)):
        #     if s[j] in st:
        #         i = max(st[s[j]], i)
        #     ans = max(ans, j - i + 1)
        #     st[s[j]] = j + 1
        # return ans
        a = {}
        max_len = 0
        for i in range(len(s)):
            num = 0
            for j in range(i, len(s)):
                if s[j] in a[i]:
                    max_len = max(num, max_len)
                else:
                    list1 = a[i]
                    list1.append(s[j])
                    a[i] = list1
                    num += 1

        return max_len
                # leetcode submit region end(Prohibit modification and deletion)
