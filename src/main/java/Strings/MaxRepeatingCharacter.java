package Strings;

public class MaxRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(maxRepeating("aabbbceeeefffffgg"));
    }

    static char maxRepeating(String s) {
        int maxLength = 1;
        int index = 0;
        int maxSoFar = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                maxSoFar++;
                if (maxLength < maxSoFar) {
                    maxLength = maxSoFar;
                    index = i;
                }
            } else {
                maxSoFar = 1;
            }
        }
        return s.charAt(index);
    }

    static int maxRepeatingLength(String s) {
        int maxLength = 1;
        int maxSoFar = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                maxSoFar++;
                if (maxLength < maxSoFar) {
                    maxLength = maxSoFar;
                }
            } else {
                maxSoFar = 1;
            }
        }
        return maxLength;
    }
}
