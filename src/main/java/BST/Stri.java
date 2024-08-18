package BST;

public class Stri {
    static int a = 10;
    public static void check(int a){
        a = a+10;
    }
    public static void main(String[] args) {
        Stri s = new Stri();
        System.out.println(s.a);
        check(123);
        System.out.println(s.a);
    }
}
