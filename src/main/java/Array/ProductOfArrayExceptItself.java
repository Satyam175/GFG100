package Array;

import java.util.Arrays;

public class ProductOfArrayExceptItself {
    public static void main(String[] args) {
        int[] nums = {10, 3, 5, 6, 2};
        System.out.println(Arrays.toString(productExceptItself2(nums, 5)));

    }

    public static long[] productExceptSelf(int[] nums, int n) {
        long[] products = new long[n];
        for (int i = 0; i < n; i++) {
            long product = 1;
            for (int j = 0; j < n; j++) {
                if (i!=j){
                    product*=nums[j];
                }
            }
            products[i] = product;
        }
        return products;
    }

    public static long[] productExceptItself2(int[] nums, int n){
        long[] products = new long[n];

        // Calculate products of left side
        long leftProduct = 1;
        for (int i = 0; i < n; i++) {
            products[i] = leftProduct; // Store the product of elements on the left side
            leftProduct *= nums[i];    // Update the product for the next element
        }

        // Calculate products of right side and multiply with products array
        long rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            products[i] *= rightProduct; // Multiply with the product of elements on the right side
            rightProduct *= nums[i];      // Update the product for the next element on the right
        }

        return products;
    }
}
