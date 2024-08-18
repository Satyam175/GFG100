package Array;

public class PerformOperations {
    public static void main(String[] args) {
        int[] arr = {2,2,3,1,1,0};
        System.out.println(checkArray(arr, 3));
    }

    public static boolean checkArray(int[] nums, int k) {
        int cur = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (cur > nums[i])
                return false;
            nums[i] -= cur;
            cur += nums[i];
            if (i >= k - 1)
                cur -= nums[i - k + 1];
        }
        return cur == 0;
    }
}
