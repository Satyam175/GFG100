package Strings;

public class LongestPalindromicSubstring {
    static int len = Integer.MIN_VALUE;

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("ac"));
    }

    //    time O(N2) & space O(1)
    static String longestPalindrome2(String s) {
        char[] input = s.toCharArray();
        if (s.length() < 2) {
            return s;
        }
        String ans = "";
        for (int i = 0; i < input.length; i++) {
            
            ans = expandPalindrome(input, i, i, ans, s);
            ans = expandPalindrome(input, i, i + 1, ans, s);
        }
        return ans;
    }

    public static String expandPalindrome(char[] arr, int j, int k, String ans, String s) {
        while (j >= 0 && k < arr.length && arr[j] == arr[k]) {
            if (len < k - j) {
                len = k - j;
                ans = s.substring(j, k + 1);
            }
            j--;
            k++;
        }
        return ans;
    }

    //    time O(N3) & space O(1)
    static String longestPalindrome(String s) {
        String longestSubstring = "";
        int length = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String currentSubstring = s.substring(i, j + 1);
                if (isPalindrome(currentSubstring)) {
                    if (currentSubstring.length() > length) {
                        longestSubstring = currentSubstring;
                        length = currentSubstring.length();
                    }
                }
            }
        }

        return longestSubstring;
    }

    static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
