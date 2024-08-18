package Strings;

public class SentencePalindrome {
    public static void main(String[] args) {
        System.out.println(sentencePalindrome("OP"));
    }

    //    ASCII 0-9 = 48-57 &  A-Z = 65-90 & a-z = 97-122
    static boolean sentencePalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char leftChar = Character.toLowerCase(s.charAt(l));
            char rightChar = Character.toLowerCase(s.charAt(r));

            if (isAlphanumeric(leftChar) && isAlphanumeric(rightChar)) {
                if (leftChar == rightChar) {
                    l++;
                    r--;
                } else {
                    return false;
                }
            } else {
                if (!isAlphanumeric(leftChar)) {
                    l++;
                }
                if (!isAlphanumeric(rightChar)) {
                    r--;
                }
            }
        }

        return true;
    }

    static boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

}
