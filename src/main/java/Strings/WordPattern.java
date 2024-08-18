package Strings;

import java.util.HashMap;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] words = s.split("\\s");

        if(words.length != pattern.length()){
            return false;
        }

        for(int i = 0; i< words.length; i++){
            char c  = pattern.charAt(i);
            String word = words[i];

            if(map.containsKey(c)){
                if(!map.get(c).equals(word)) return false;
            } else {
                if (map.containsValue(word)) {
                    return false;
                }
                map.put(c, word);
            }
        }
        return true;
    }
}
