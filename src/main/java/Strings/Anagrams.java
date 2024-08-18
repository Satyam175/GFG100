package Strings;

import java.util.HashMap;

public class Anagrams {
    public static void main(String[] args) {
        System.out.println(isAnagram("abc", "bac"));
    }

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        for (int i = 0; i < a.length(); i++) {
            freq1[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            freq1[b.charAt(i) - 'a']--;
        }

        for (int i : freq1) {
            if (i != 0) return false;
        }
        return true;
    }
}
