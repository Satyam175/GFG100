package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneNumbers {
    public static void main(String[] args) {
        System.out.println(letterCombinations("24"));
    }

    public static List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        if (digits.equals("")) return ans;

        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        helper(ans, map, 0, digits, new StringBuilder());
        return ans;
    }

    public static void helper(List<String> l, HashMap<Integer, String> map, int i, String digits, StringBuilder s) {
        if (i == digits.length()) {
            l.add(s.toString());
            return;
        }
        for (int j = 0; j < map.get(digits.charAt(i) - '0').length(); j++) {
            s.append(map.get(digits.charAt(i) - '0').charAt(j));
            helper(l, map, i + 1, digits, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
