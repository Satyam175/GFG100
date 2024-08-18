package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenation {
    public static void main(String[] args) {
        String[] arr = {"foo","bar"};
        System.out.println(findSubstring2("barfoothefoobarman", arr));
    }

    public static List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || words[0].length() == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (totalLen > s.length()) return result;

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Slide over the string s with step of wordLen
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> seenWords = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordMap.containsKey(sub)) {
                    seenWords.put(sub, seenWords.getOrDefault(sub, 0) + 1);

                    if (seenWords.get(sub) <= wordMap.get(sub)) {
                        count++;
                    }

                    while (seenWords.get(sub) > wordMap.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        left += wordLen;

                        if (seenWords.get(leftWord) < wordMap.get(leftWord)) {
                            count--;
                        }
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    seenWords.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(words.length * words[0].length() > s.length()){
            return new ArrayList();
        }
        int len = words[0].length();
        int totalLen = len*words.length;
        int currentLength = 0;
        boolean isMapModified = false;

        Map<String, Integer> map = getFreqMap(words);
        Map<String, Integer> map2 = getFreqMap(words);

        for(int i = 0; i<s.length()-len+1; i++){
            if (isMapModified) {
                map.clear();
                map = map2;
            }
            int j = i;
            while (currentLength < totalLen && j+len <= s.length()){
                String substring = s.substring(j, j+len);
                if(map.containsKey(substring)){
                    int freq = map.get(substring);
                    if (freq<=0) break;
                    map.put(substring, freq-1);
                    isMapModified = true;
                    j+=len;
                    currentLength+=len;
                } else {
                    break;
                }
            }
            if (currentLength == totalLen){
                result .add(i);
            }
            currentLength= 0;
        }
        return result;
    }

    public static Map<String, Integer> getFreqMap(String[] words){
        Map<String, Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }
}
