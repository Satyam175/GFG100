package Array;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character,Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);

        int prev = 0;
        int numeral = 0;
        for(int i = s.length() -1; i>=0; i--){
            char c = s.charAt(i);
            int val = charMap.get(c);

            if(val >= prev){
                numeral+=val;
            } else{
                numeral-=val;
            }
            prev = val;
        }
        return numeral;
    }
}
