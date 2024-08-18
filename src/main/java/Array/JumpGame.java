package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int jumpSteps = 0;
        for(int n : nums){
            if(jumpSteps < 0) return false;
            if(n > jumpSteps) jumpSteps = n;
            jumpSteps--;
        }
        return true;
    }
}
