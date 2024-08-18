package Strings;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(allSubsequences(0, "acb", "", new ArrayList<>()));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        List<String> arr1 = allSubsequences(0,text1, "", new ArrayList<>());
        List<String> arr2 = allSubsequences(0,text2, "", new ArrayList<>());
        int longestCommon = Integer.MIN_VALUE;
        for (String s : arr1){
            if (arr2.contains(s) && s.length()>longestCommon){
                longestCommon = s.length();
            }
        }
        return longestCommon;
    }

    static List<String> allSubsequences(int i, String s, String f, ArrayList<String> subsequences) {
        if (i == s.length()) {
            subsequences.add(f);
            return subsequences;
        }

        subsequences = (ArrayList<String>) allSubsequences(i + 1, s, f + s.charAt(i), subsequences);
        return allSubsequences(i + 1, s, f, subsequences);
    }
}
