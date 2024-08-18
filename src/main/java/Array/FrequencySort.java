package Array;

import java.util.*;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();  // Read the number of test cases

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();  // Read the size of the array
            int[] array = new int[N];

            for (int i = 0; i < N; i++) {
                array[i] = scanner.nextInt();  // Read each element into the array
            }

            sortArrayByFrequency(array);

            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void sortArrayByFrequency(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Convert the array to a List of Integer for sorting
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }

        // Sort the list based on frequency and value
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int freqCompare = frequencyMap.get(a).compareTo(frequencyMap.get(b));
                if (freqCompare == 0) {  // If frequencies are the same, compare numbers
                    return b.compareTo(a);
                }
                return freqCompare;
            }
        });

        // Copy the sorted list back to the original array
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
    }
}


