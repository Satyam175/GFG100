package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {

    public static void main(String[] args) {
        String[] arr = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] arrrr = {"What", "must", "be", "acknowledgment", "shall", "be"};
//        System.out.println(fullJustify(arr, 16));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int index = 0;
        List<String> result = new ArrayList<>();

        while(index < words.length){
            StringBuilder sb = new StringBuilder();
            int wordCount = 0;
            int lineLength = 0;

            while(index < words.length && lineLength + words[index].length() + wordCount <= maxWidth){
                lineLength+=words[index].length();
                wordCount++;
                index++;
            }

            int totalSpaces = maxWidth - lineLength;
            int spaceBetweenWords = wordCount > 1 ? totalSpaces / (wordCount -1) : totalSpaces;
            int extraSpaces = wordCount > 1 ? totalSpaces % (wordCount - 1) : 0;

            if (index == words.length){
                spaceBetweenWords = 1;
                extraSpaces = 0;
            }


            for(int i = index - wordCount;i<index;i++){
                sb.append(words[i]);
                if(i<index -1){
                    sb.append(" ".repeat(spaceBetweenWords));
                    if (extraSpaces > 0){
                        sb.append(" ");
                        extraSpaces--;
                    }
                }
            }

            sb.append(" ".repeat(maxWidth - sb.length()));

            result.add(sb.toString());
        }
        return result;
    }

}
