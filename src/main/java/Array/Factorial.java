package Array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorialDigitList(10));
    }

    static double factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    static double factorial2(int n) {
        double ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    static ArrayList<Integer> factorial3(int N) {
        double factorialResult = 1;
        for (int i = 1; i <= N; i++) {
            factorialResult *= i;
        }

        // Convert factorial result to a list of digits
        ArrayList<Integer> digitList = new ArrayList<>();
        while (factorialResult >= 1) {
            digitList.add(0, (int) (factorialResult % 10));  // Add at the beginning of the list
            factorialResult /= 10;
        }

        return digitList;
    }

    public static List<Integer> factorialDigitList(int N) {
        BigInteger factorialResult = BigInteger.valueOf(1);
        for (int i = 1; i <= N; i++) {
            factorialResult = factorialResult.multiply(BigInteger.valueOf(i));
        }

        List<Integer> digitList = new ArrayList<>();
        while (!factorialResult.equals(BigInteger.ZERO)) {
            digitList.add(0, factorialResult.mod(BigInteger.TEN).intValue());
            factorialResult = factorialResult.divide(BigInteger.TEN);
        }

        return digitList;
    }
}
