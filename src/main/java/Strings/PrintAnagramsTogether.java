package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PrintAnagramsTogether {
    public static void main(String[] args) {
        String[] strings = {"kptkwp", "czdvgr", "osbqrs", "shhqjd", "ydavzo", "bltcjf", "vuoswt", "gkgbjk", "hzfoyu", "tujlak", "wgmuab", "wtdeno", "cemizj", "dryfqd", "hxuzdd", "zpanxz", "lnakfa", "yovytp", "yqtjyd", "baoyal", "vbwgaf", "bmmdgq", "akmnxe", "koaaan", "jlarwn", "dbhapu", "bspgln"};
        System.out.println(Anagrams(strings));
    }
// In summary, the time complexity is O(k * (n * log(n))), and the space complexity is O(k * n).
    static List<List<String>> Anagrams(String[] string_list) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (String s : string_list) {
            String sortedString = sortString(s);
            if (map.containsKey(sortedString)) {
                List<String> l = map.get(sortedString);
                l.add(s);
                map.put(sortedString, l);
            } else {
                ArrayList arr = new ArrayList();
                arr.add(s);
                map.put(sortedString, arr);
            }
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        return result;
    }

    static String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

}
