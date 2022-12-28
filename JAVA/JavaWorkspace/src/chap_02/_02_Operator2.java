package chap_02;

public class _02_Operator2 {
    public static void main(String[] args) {
        // 대입 연산자
        int num = 10;
        num = num + 2;
        System.out.println(num); // 12

        // 복합 대입 연산자, 사칙 연산 모두 가능
        num += 2;
        System.out.println(num); // 14
    }
}
