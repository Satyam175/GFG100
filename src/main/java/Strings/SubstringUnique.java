package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SubstringUnique {
    public static void main(String[] args) {
        String s = "abcad";
        System.out.println(uniqueSubstrings(s));
    }

    public static int uniqueSubstringss(String s){
        int count = 0;
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // Move `left` to the right of the previous occurrence of the current character
                left = Math.max(left, map.get(c) + 1);
            }
            // Calculate the number of unique substrings ending at `i`
            count += i - left + 1;
            // Update the last seen index of the current character
            map.put(c, i);
        }
        return count;
    }

    public static int uniqueSubstrings(String s) {
        int count = 0;

        // Generate all possible substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (areCharactersUnique(s, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    // Helper method to check if characters in substring s[i..j] are unique
    private static boolean areCharactersUnique(String s, int start, int end) {
        HashSet<Character> seenChars = new HashSet<>();
        for (int k = start; k <= end; k++) {
            char c = s.charAt(k);
            if (seenChars.contains(c)) {
                return false;
            }
            seenChars.add(c);
        }
        return true;
    }

}
