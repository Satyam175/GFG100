package Array;

public class FindMissingNumber {
    public static void main(String[] args) {
//   1,2,4,5
//   0,0,0,0,0
//   1,1,0,3,1
        System.out.println(missingNumber3(new int[]{1, 2, 3, 5}, 5));
    }

    //method 1 - use sum formula n*(n+1)/2
    int missingNumber(int[] array, int n) {
        int sum = (n * (n + 1)) / 2;
        int sumOfArray = 0;
        for (int i = 0; i < array.length; i++) {
            sumOfArray += array[i];
        }
        return sum - sumOfArray;
    }

    static int missingNumber2(int[] array, int n) {
        int[] temp = new int[n];
        for (int i = 0; i < array.length; i++) {
            temp[array[i] - 1] = 1;
        }
        for (int i = 0; i <= n; i++) {
            if (temp[i] == 0) return i + 1;
        }
        return 0;
    }

    static int missingNumber3(int[] array, int n) {
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum += i;
            sum -= array[i - 2];
        }
        return sum;
    }

//    using XOR

//    static int missingNumber4(int[] array, int n){
//        int xor1 = 0;int xor2 = 0;
//        for (int i = 0 ; i<n-1 ;i++){
//            xor2 = xor2^(array[i]);
//            xor1 = xor1^i;
//        }
//        xor1 = xor1 ^ n;
//        return xor2^xor1;
//    }

}
