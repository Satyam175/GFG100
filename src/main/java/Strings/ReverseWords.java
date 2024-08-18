package Strings;

import java.util.ArrayList;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }

    public static String reverseWords(String s) {
        String[] words = s.split("\\s");

        int start = 0;
        int end = words.length-1;


        while (start<end){
            if (words[start] == " " || words[start].isEmpty()){
                start++;
            } else if(words[end] == " " || words[end].isEmpty()){
                end--;
            } else {
                String temp = words[start];
                words[start] = words[end];
                words[end] = temp;
                start++;
                end--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<words.length;i++){
            String word = words[i];
            if (!word.isEmpty() && !word.equals(" ")){
                sb.append(word);
                if (i!= words.length-1){
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public String reverseWords2(String s) {
        String[] words = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();

        for(int i = words.length-1; i>0;i--){
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.append(words[0]);
        return sb.toString();
    }
}
