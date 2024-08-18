package Strings;

public class PrintAllSubsequences {
    public static void main(String[] args) {
//        allSubsequences(0, "acb", "");
        allSubsequence("acb");
    }

    static void allSubsequences(int index, String s, String f) {
        if (index == s.length()) {
            System.out.println(f + " ");
            return;
        }

//      picking
//      f = f + s.charAt(index);
        allSubsequences(index + 1, s, f + s.charAt(index));

//      popping out while backtracking
//      f = f.popback()
        allSubsequences(index + 1, s, f);
    }

    static void allSubsequence(String s) {
        int n = s.length();
        for (int num = 0; num < (1 << n); num++) {
            String sub = "";
            for (int i = 0; i < n; i++) {
                //check if the ith bit is set or not
                if ((num & (1 << i))!=0) {
                    sub += s.charAt(i);
                }
            }
            if (sub.length() > 0) {
                System.out.println(sub);
            }
        }
    }
}
