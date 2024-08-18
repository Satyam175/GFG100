package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindPairs {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        /*
            EXPECTED OUTPUT:
            ----------------
            [5, 2]
            [3, 4]
            [1, 6]

        */
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target){
        HashSet<Integer> pairMap = new HashSet<>();
        for (int j : arr1) {
            pairMap.add(target - j);
        }
        List<int[]> ans = new ArrayList<>();
        for(int i : arr2){
            if(pairMap.contains(i)){
                ans.add(new int[]{target -i, i});
            }
        }
        return ans;
    }
}
