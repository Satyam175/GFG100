package Strings;

public class Subsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("acb", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        int first = 0;
        int second = 0;
        if(s.isEmpty()) return true;
        if(s.length() > t.length()) return false;

        if (s.length() == t.length()){
            return s.equals(t);
        }

        while(first < s.length() && second < t.length()){
            if(s.charAt(first) == t.charAt(second)){
                first++;
            }
            second++;
        }

        if(first < s.length() -1 ){
            return false;
        }
        return true;
    }
}
