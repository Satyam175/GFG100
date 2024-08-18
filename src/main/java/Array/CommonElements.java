package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CommonElements {
    public static void main(String[] args) {
        int[] v1 = {1, 2, 2, 3};
        int[] v2 = {2, 2, 3, 3};
        ArrayList<Integer> result = common_element(v1, v2);
        System.out.println(result);
    }

    public static ArrayList<Integer> common_element(int v1[], int v2[]) {
        // A map to store the frequency of elements in the first array
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Populate the frequency map with elements from v1
        for (int num : v1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // A list to hold common elements
        ArrayList<Integer> result = new ArrayList<>();

        // Check elements in v2 against the frequency map
        for (int num : v2) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                result.add(num);
                // Decrease the count in the frequency map
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        // Sort the result to ensure elements are in sorted order
        Collections.sort(result);
        return result;
    }
}
