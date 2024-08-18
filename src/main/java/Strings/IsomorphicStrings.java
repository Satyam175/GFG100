package Strings;

import java.util.HashSet;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("aa", "ab"));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (map1[s.charAt(i)] != map2[t.charAt(i)]) {
                return false;
            }

            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}

