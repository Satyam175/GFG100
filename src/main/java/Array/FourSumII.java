package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FourSumII {
    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}));
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        int n = nums1.length;
        Arrays.sort(nums3);
        Arrays.sort(nums4);

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int sum = nums1[i] + nums2[j];
                int target = -1*sum;

                HashMap<Integer, Integer> map = new HashMap<>();
                for(int k : nums3) {
                    map.put(k, map.getOrDefault(k, 0)+1);
                }

                for(int l : nums4){
                    int diff = target - l;
                    if(map.containsKey(diff)) {
                        count+=map.get(diff);
                    }
                }

            }
        }
        return count;
    }
}
