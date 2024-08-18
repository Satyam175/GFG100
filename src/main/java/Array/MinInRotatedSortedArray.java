package Array;

public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(arr));
    }

    //    binary search on complete array and pick the minimum element
    static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }
            if (nums[low] <= nums[mid]) {
                ans = Math.min(nums[low], ans);
                low = mid + 1;
            } else {
                high = mid - 1;
                ans = Math.min(ans, nums[mid]);
            }
        }
        return ans;
    }
}
