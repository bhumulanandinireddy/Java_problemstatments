/* Given a string s, find the length of the longest 
substring without repeating characters.

 
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces. */

import java.util.*;

class lengthOfLongestSubstringSolution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> charSet = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;

        while (right < n) {
            char currentChar = s.charAt(right);

            // Expanding the Window
            if (!charSet.contains(currentChar)) {
                charSet.add(currentChar);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                // Contracting the Window
                charSet.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstringSolution solution = new lengthOfLongestSubstringSolution();
        int result = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result); // Output: 3
    }
}


