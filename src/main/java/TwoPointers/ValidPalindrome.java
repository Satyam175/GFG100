package TwoPointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() -1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++; end--;
            } else if((s.charAt(start)<97 || s.charAt(start) > 122) && (s.charAt(start) < '0' || s.charAt(start) > '9')){
                start++;
            } else if((s.charAt(end)<97 || s.charAt(end) > 122) && (s.charAt(end) < '0' || s.charAt(end) > 9)) {
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
