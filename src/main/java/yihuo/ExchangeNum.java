package yihuo;

public class ExchangeNum {

    public static void main(String[] args) {

        int a = 0;
        int b = 1;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

    }

    public static void exchangeNum() {

    }
}
