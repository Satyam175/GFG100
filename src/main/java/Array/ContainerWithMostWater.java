package Array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr, arr.length));
        System.out.println(maxArea(arr));
    }

//    long maxArea(int A[], int len) {
//        long max = 0;
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                max = Math.max(max, (j-i)*Math.min(A[i], A[j]));
//            }
//        }
//        return max;
//    }

    static long maxArea(int[] A, int len) {
        long max = 0;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(A[i], A[j]));
            if (A[i] < A[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length -1;
        int max = 0;

        while(start < end){
            int area = (end-start)*Math.min(height[start], height[end]);
            max = Math.max(area, max);

            if(height[start] < height[end]){
                start++;
            } else{
                end--;
            }
        }
        return max;
    }
}
