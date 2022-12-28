package chap_04;

public class _11_Continue {
    public static void main(String[] args) {
        // continue
        // 치킨 주문 손님중에 노쇼 손님이 있다고 가정
        // for
        int max = 20; // 최대 치킨 판매 수량
        int sold = 0; // 현재 치킨 판매 수량
        int noShow = 17; // 대기번호 17번 손님이 노쇼
        for (int i = 1; i <= 50; i++) {
            System.out.println(i + "번 손님 치킨나왔습니다.");

            // 노쇼 손님
            if (i == noShow) {
                System.out.println(i + "번 손님 노쇼로 다음손님에게 기회가 넘어갑니다.");
                i ++;
                continue;
            }

            sold++;
            if (sold == max) {
                System.out.println("금일 재료 모두 소진");
                break;
            }
        }
        System.out.println("영업을 종료합니다.");

        // While 문
        sold = 0;
        int index = 1; // 손님 번호
        while (index < 50) {
            System.out.println(index + "번 손님, 주문하신 치킨 나왔습니다.");
            sold++;

            // 노쇼 손님
            if (index == noShow) {
                System.out.println(index + "번 손님 노쇼로 다음손님에게 기회가 넘어갑니다.");
                index++;
                continue;
            }

            if (sold == max) {
                System.out.println("금일 재료 모두 소진");
                break;
            }
            index++;
        }
        System.out.println("영업을 종료합니다.");

    }
}
