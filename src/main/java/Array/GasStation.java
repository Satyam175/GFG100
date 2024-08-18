package Array;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit2(gas, cost));
    }

    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int totalDiff = 0; // Total difference between gas and cost
        int currentDiff = 0; // Current difference between gas and cost
        int startStation = 0; // Starting station index

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalDiff += diff;
            currentDiff += diff;

            if (currentDiff < 0) {
                // If current difference becomes negative, update startStation to the next station
                startStation = i + 1;
                currentDiff = 0;
            }
        }

        // If total difference is negative, it means it's not possible to complete the circuit
        return totalDiff >= 0 ? startStation : -1;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (!(gas[i] - cost[i] < 0)) {
                if (canTravel(i, gas, cost)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean canTravel(int start, int[] gas, int[] cost) {
        int temp = start;
        int startFuel = gas[start];
        boolean firstIteration = false;
        while (true) {
            start = start % gas.length;
            int next = (start + 1) % gas.length;
            if (temp == start && firstIteration) {
                return true;
            }
            if (startFuel - cost[start] < 0) return false;
            startFuel = startFuel - cost[start] + gas[next];
            start++;
            firstIteration = true;
        }
    }
}
