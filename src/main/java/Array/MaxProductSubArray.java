package Array;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 0, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxProduct(arr, arr.length));
    }

//    static long maxProduct(int[] arr, int n) {
//        long result = arr[0];
//        for (int i = 0; i< n; i++){
//            long mul = arr[i];
//            for (int j = i+1; j< n; j ++){
//                result = Math.max(result, mul);
//                mul *= arr[j];
//            }
//            result = Math.max(result, mul);
//        }
//        return result;
//    }

//    static long maxProduct(int[] arr, int n) {
//        long maxSoFar = arr[0];
//        long maxEndingHere = arr[0];
//        long minEndingHere = arr[0];
//
//        for (int i = 1; i < n; i++) {
//            long temp = Math.max(Math.max(arr[i], arr[i] * maxEndingHere), arr[i] * minEndingHere);
//            minEndingHere = Math.min(arr[i], Math.min(arr[i] * maxEndingHere, arr[i] * minEndingHere));
//            maxEndingHere = temp;
//            maxSoFar = Math.max(maxSoFar, maxEndingHere);
//        }
//        return maxSoFar;
//    }

    static long maxProduct(int[] arr, int n) {
        long prefix = 1;
        long suffix = 1;
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix *= arr[i];
            suffix *= arr[n - 1 - i];

            ans = Math.max(Math.max(prefix, suffix), ans);
        }
        return ans;
    }
}