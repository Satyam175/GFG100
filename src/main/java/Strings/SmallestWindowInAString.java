package Strings;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowInAString {
    public static void main(String[] args) {
        System.out.println(smallestWindow("ab", "a"));
    }

    static String smallestWindow(String s, String t) {
        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();
        String result = "";
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mp1.put(c, mp1.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {
                int currentLength = j - i + 1;
                // Update frequency map for the current substring
                char currentChar = s.charAt(j);

                mp2.put(currentChar, mp2.getOrDefault(currentChar, 0) + 1);

                if (currentLength<t.length()){
                    continue;
                }

                if (containsAll(mp1, mp2)) {
                    if (currentLength < minLen) {
                        minLen = currentLength;
                        result = s.substring(i, j + 1);
                    }
                }
            }
            mp2.clear();
        }
        return result;
    }

    static boolean containsAll(Map<Character, Integer> mp1, Map<Character, Integer> mp2) {
        for (char c : mp1.keySet()) {
            int value = mp1.get(c);
            if (!mp2.containsKey(c) || mp2.get(c) < value) {
                return false;
            }
        }
        return true;
    }
}
