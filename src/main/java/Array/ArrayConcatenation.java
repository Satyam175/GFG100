package Array;

public class ArrayConcatenation {
    public static void main(String[] args) {
        System.out.println(getConcatenation(new int[]{1,2,1}));
    }
    public static int[] getConcatenation(int[] nums) {
        int newSize = 2*nums.length;
        int[] ans = new int[newSize];
        for(int i = 0; i < newSize; i++){
            int j = i%nums.length;
            ans[i] = nums[j];
        }
        return ans;
    }
}
