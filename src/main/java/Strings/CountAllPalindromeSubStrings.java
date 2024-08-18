package Strings;

public class CountAllPalindromeSubStrings {
    public static void main(String[] args) {
        System.out.println(CountPS("abaab", 5));
    }

    public static int CountPS(String S, int N) {
        int palindromes = 0;
        char[] arr = S.toCharArray();
        if (N < 2) {
            return 0;
        }
        for (int i = 0; i < N; i++) {
            palindromes += expandPalindrome(i, i, N, arr);
            palindromes += expandPalindrome(i, i + 1, N, arr);
        }
        return palindromes;
    }

    static int expandPalindrome(int l, int h, int N, char[] arr) {
        int palindromes = 0;
        while (l >= 0 && h < N && arr[l] == arr[h]) {
            if (h - l >= 1) {
                palindromes++;
            }
            l--;
            h++;
        }
        return palindromes;
    }
}
