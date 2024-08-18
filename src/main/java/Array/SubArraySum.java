package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubArraySum {
    public static void main(String[] args) {

//        int[] nums1 = {1, 2, 3, 4, 5};
//        int target1 = 9;
//        int[] result1 = subarraySum(nums1, target1);
//        System.out.println("[" + result1[0] + ", " + result1[1] + "]");
//
        int[] nums2 = {-1, 2, 3, -4, 5};
        int target2 = 0;
        int result2 = subArray(nums2, target2);
        System.out.println(result2);
//        System.out.println("[" + result2[0] + ", " + result2[1] + "]");
//
//        int[] nums3 = {2, 3, 4, 5, 6};
//        int target3 = 3;
//        int[] result3 = subarraySum(nums3, target3);
//        System.out.println("[" + result3[0] + ", " + result3[1] + "]");
//
//        int[] nums4 = {};
//        int target4 = 0;
//        int[] result4 = subarraySum(nums4, target4);
//        System.out.println("[]");

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 3]
            [0, 3]
            [1, 1]
            []

        */

    }

    public static int[] subarraySum(int[] nums, int target) {
        Map<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1);
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (sumIndex.containsKey(currentSum - target)) {
                return new int[]{sumIndex.get(currentSum - target) + 1, i};
            }
            sumIndex.put(currentSum, i);
        }

        return new int[]{};
    }

    public static List<Integer> removeDuplicates(List<Integer> myList){
        Set<Integer> uniqueSet = new HashSet<>(myList);
        return new ArrayList<>(uniqueSet);
    }

    public static int subArray(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int currentSum = 0;
        int count = 0;

        for(int i=0;i< nums.length;i++){
            currentSum+=nums[i];
            if (map.containsKey(currentSum-k)){
                count+=map.get(currentSum);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

}
