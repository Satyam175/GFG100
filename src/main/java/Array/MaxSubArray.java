package Array;

//Kadane's Algorithm
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] numss = {-2, -3, -4, -1, -2, -1, -5, -3};
        System.out.println(maxSubArray(numss));
    }

    public static int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for (int i : nums) {
            maxEndingHere += i;
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}
