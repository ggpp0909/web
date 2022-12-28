package chap_04;

public class _01_If {
    public static void main(String[] args) {
        // 조건문 if
        int hour = 10; // 오전 10시

        // if 문 내에서 하나의 문장을 실행할 때는 { } 생략 가능
        if (hour < 14)
            System.out.println("지각하지 않았어요");

        // if 문 내에서 2개 이상의 문장을 실행할 때는 { } 생략 불가
        if (hour < 14) {
            System.out.println("지각하지 않았어요");
            System.out.println("어서오세요");
        }

        // 오후 2시 이전 모닝 커피를 마시지 않은 경우?
        boolean morningCoffee = false;
        if (hour < 14 && !morningCoffee) {
            System.out.println("아메리카노 + 1");
        }
        System.out.println("커피 주문 완료");

        // 오후 2
    }
}
