package Array;

import java.util.HashMap;

public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }

    public static String intToRoman(int num){
        String[] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hrns = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] ths ={"","M","MM","MMM"};

        return ths[num/1000] + hrns[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];

    }
}
