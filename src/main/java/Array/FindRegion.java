package Array;

import java.util.ArrayList;
import java.util.List;

public class FindRegion {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(3,1,2,1));
        System.out.println(findRegion(list));
    }

    private static int findRegion(List<Integer> heights){
        int sum = 0;
        for (int i = 0; i < heights.size(); i++){
            int currentRegion = 1;
            int left = i-1;
            while(left>=0 && heights.get(left)<heights.get(i)){
                currentRegion++;
                left--;
            }
            int right = i+1;

            while(right<heights.size() && heights.get(right)<heights.get(i)){
                currentRegion++;
                right++;
            }
            sum+=currentRegion;
        }
        return sum;
    }
}
