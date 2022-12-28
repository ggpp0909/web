package chap_06;

public class _05_Overloading {
    public static int getPower(int number) {
        int res = number * number;
        return res;
    }

    public static int getPower(String strNumber) {
        int number = Integer.parseInt(strNumber);
        int res = number * number;
        return res;
    }

    public static int getPower(int number, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= number;
        }
        return result;
    }

    public static void main(String[] args) {
        // 메소드 오버로딩 (이름이 같은 메서드를 여러개 만드는 것)
        // 반환형이 같은 메서드만 가능
        System.out.println(getPower(3));
        System.out.println(getPower("2"));
        System.out.println(getPower(3, 2));

    }
}
