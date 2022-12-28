package chap_06;

public class _02_Parameter {
    // 전달값이 있는 메소드
    public static void power(int number) {
        int res = number * number;
        System.out.println(res);
    }

    public static void powerByExp(int number, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= number;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        // 전달값, 파라미터
        power(2);
        powerByExp(2, 3);
    }
}
