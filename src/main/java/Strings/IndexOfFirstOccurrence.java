package Strings;

public class IndexOfFirstOccurrence {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }

    public static int strStr(String haystack, String needle) {
        int start = 0;
        int len = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            int end = start + len;
            if (end > haystack.length()){
                return -1;
            }
            if (needle.equals(haystack.substring(start, end))){
                return start;
            } else{
                start++;
            }
        }
        return -1;
    }
}
