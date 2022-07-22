import java.util.*;
public class leetcode003LongestSubstringWithoutRepeatingCharacters {
    private static int lengthOfLongestSubstring_v1(String s) {
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int count = 1;
            set.add(s.charAt(i));
            for(int j = i + 1; j < s.length(); j++) {
                if(!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    count++;
                } else {
                    break;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }

    private static int lengthOfLongestSubstring_v2(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcdeafbdgcbb";
        System.out.println(lengthOfLongestSubstring_v1(s));        
        System.out.println(lengthOfLongestSubstring_v2(s));
    }
}
