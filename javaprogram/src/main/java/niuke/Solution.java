package niuke;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * created by huyanshi on 2019/2/26
 */
class Solution {

  public int solution(String S, int K) {

    for (int i = 0; i < S.length(); i++) {
      for (int j = 0; j < S.length() - i + 1; j++) {
        char[] arr = S.toCharArray();
        List<Character> characters = new ArrayList<>();
        for(int ll = 0;ll < arr.length;ll++){
          characters.add(arr[ll]);
        }

        int end = j +i;
        for (int p = 0; p < i; p++) {
          characters.remove(j);
        }

        Set<Character> set = new HashSet<>(characters);
        if (set.size() == K) {
          return i;
        }

      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().solution("abaacbca", 2));
    System.out.println(new Solution().solution("aabcabc", 1));
    System.out.println(new Solution().solution("zaaaa", 1));
    System.out.println(new Solution().solution("aaaa", 2));


  }

}
