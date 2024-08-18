package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(longestSubstring3("abba"));
    }

    //    time O(N2) & space O(N)
    static int longestSubstring(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> characters = new HashSet<>();
            int maxTillNow = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (characters.contains(c)) {
                    result = Math.max(result, maxTillNow);
                    break;
                }
                characters.add(c);
                maxTillNow++;
            }
            result = Math.max(result, maxTillNow);
        }
        return result;
    }

    //    time O(2N) and space 0(N) two pointer approach
    static int longestSubstring2(String s) {
        int ans = Integer.MIN_VALUE;
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int l = 0;
        Set<Character> characters = new HashSet<>();
        for (int r = 0; r < s.length(); r++) {
            if (characters.contains(s.charAt(r))) {
                while (l <= r && characters.contains(s.charAt(r))) {
                    characters.remove(s.charAt(l));
                    l++;
                }
            }
            characters.add(s.charAt(r));
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    //    time O(N) and space O(N)
    static int longestSubstring3(String s) {
        int ans = Integer.MIN_VALUE;
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int l = 0;
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            if (characterIntegerHashMap.containsKey(s.charAt(r))) {
                l = Math.max(characterIntegerHashMap.get(s.charAt(r)) + 1, l);
            }
            characterIntegerHashMap.put(s.charAt(r), r);
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

}
