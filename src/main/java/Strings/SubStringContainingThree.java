package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubStringContainingThree {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abad"));
    }

//    public static int numberOfSubstrings(String s) {
//        int count = 0;
//        Set<Character> chars = new HashSet<>();
//        for(int i = 0; i<s.length(); i++){
//            chars.clear();
//            for(int j = i; j<s.length(); j++){
//                chars.add(s.charAt(j));
//                if(chars.size() >= 3){
//                    count+=s.length()-j;
//                    break;
//                }
//            }
//        }
//        return count;
//    }

    public static int numberOfSubstrings(String s) {
        int count = 0;
        int[] lastSeen = new int[]{-1,-1,-1};
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            lastSeen[c-'a'] = i;
            if(lastSeen[0] != -1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                int curr = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                count+=curr+1;
            }
        }
        return count;
    }
}
