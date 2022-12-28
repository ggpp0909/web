package chap_04;

// 조건문을 활용하여 주차요금 정산 프로그램 작성
// 조건
// 주차요금은 시간당 4000원, 일일 최대 요금은 30000원
// 경차 또는 장애인 차량은 최종 요금에서 50% 할인
public class _Quiz_04 {
    public static void main(String[] args) {
        int hour = 10;
        int maxFee = 30000;
        int feePerHour = 4000;
        String car = "장애인";
        int ans = 0;

        for (int i = 0; i < hour; i++) {
            ans += feePerHour;
        }

        if (ans >= maxFee) {
            ans = maxFee;
        }

        if (car.equals("경차") || car.equals("장애인")) {
            ans /= 2;
        }

        System.out.println("주차요금은 " + ans + "원 입니다.");

    }
}
