package BitManipulation;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits("00000010100101000001111010011100"));
    }

    public static long reverseBits(String s){
        long res = 0;
        for(int i = s.length()-1;i>=0;i--){
            String str = s.substring(i,i+1);
            res = res * 2 + Integer.parseInt(str);

        }
        return res;

    }
}
