package Array;

import java.util.Arrays;

public class Rearrange {
    public static void main(String[] args) {
        int[] arr = { 1,2,-1,4,-5,6,-7};
//        rearr(arr);
        rotate(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    static void rearr(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] > 0) {
                i++;
            }
            else if (arr[j] < 0) {
                j--;
            }
            else if (arr[i] < 0 && arr[j] > 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        i = 0;
        j = arr.length - 1;
        while (i<=j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i+=2;
            j-=2;
        }
    }

    public static void rotate(int[] arr, int from, int to){
        int temp  =arr[to];
        for(int i = to; i>from; i--){
            arr[i] = arr[i-1];
        }
        arr[from] = temp;
    }

}
