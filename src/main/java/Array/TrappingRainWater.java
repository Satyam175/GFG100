package Array;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {7, 4, 0, 9};
        System.out.println(trappingWater(arr, 4));
    }

    //    time O(N^2) space 0(1)
    static long trappingWater(int[] arr, int n) {
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int maxLeft = Integer.MIN_VALUE;
            int maxRight = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(maxLeft, arr[j]);
            }
            for (int k = i; k < n; k++) {
                maxRight = Math.max(maxRight, arr[k]);
            }
            ans = ans + Math.min(maxRight, maxLeft) - arr[i];
        }
        return ans;
    }

//    precalculate maxLeft in suffix[] and maxRight in prefix[]
//    time O(N) & space O(N) as two arrays of length n are needed
    static long trappingWater2(int[] arr, int n) {
        long ans = 0;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                prefix[i] = max;
            } else {
                prefix[i] = max;
            }
        }
        max = arr[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                suffix[i] = max;
            } else {
                suffix[i] = max;
            }
        }
        for (int i = 0; i < n; i++) {
            ans += Math.min(prefix[i], suffix[i]) - arr[i];
        }
        return ans;
    }

    static long trappingWater3(int[] arr, int n) {
        int left = 0;
        int right = n - 1;

        int leftMax = 0;
        int rightMax = 0;

        int ans = 0;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    ans += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    ans += rightMax - arr[right];
                }
                right--;
            }
        }
        return ans;
    }
}
