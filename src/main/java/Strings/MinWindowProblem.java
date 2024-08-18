package Strings;

import java.util.HashMap;

public class MinWindowProblem {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = createMap(t);

        int leftMin = 0;
        int rightMin = 0;

        int len = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (isSubstring(s, left, right, tMap)) {
                int currentLength = right - left + 1;
                if (currentLength < len) {
                    len = currentLength;
                    leftMin = left;
                    rightMin = right;
                }
                left++;
            }
        }
        return s.substring(leftMin, rightMin + 1);
    }

    public static boolean isSubstring(String s, int left, int right, HashMap<Character, Integer> tmap) {
        String subString = s.substring(left, right + 1);
        HashMap<Character, Integer> sMap = createMap(subString);

        for (char key : tmap.keySet()) {
            if (!(sMap.containsKey(key) && sMap.get(key) >= tmap.get(key))) {
                return false;
            }
        }
        return true;
    }

    public static HashMap<Character, Integer> createMap(String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        return tmap;
    }
}
