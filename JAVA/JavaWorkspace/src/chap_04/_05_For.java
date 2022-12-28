package chap_04;

public class _05_For {
    public static void main(String[] args) {
        // 반복문 for (선언; 조건; 증감), fori 적고 엔터 치면 편함
        for (int i = 0; i < 10; i++) {
            System.out.println(i); // 0부터 9까지 출력
        }

        // 짝수만 출력
        for (int i = 0; i < 10; i += 2) {
            System.out.println(i);
        }

        // 홀수만 출력
        for (int i = 1; i < 10; i += 2) {
            System.out.println(i);
        }

        // 거꾸로 숫자
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
        }

        // 1부터 10까지 수들의 합
        int sum = 0;
        for (int i = 1; i < 11; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
