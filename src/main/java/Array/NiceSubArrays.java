package Array;

public class NiceSubArrays {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        System.out.println(numberOfSubarrays(nums, 3));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int oddCount = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                oddCount++;
                count = 0;
            }

            while (oddCount == k) {
                if (nums[left] % 2 != 0) oddCount--;
                left++;
                count++;
            }
            result += count;
        }
        return result;
    }
}
