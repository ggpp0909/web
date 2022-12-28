package chap_07;

public class BlackBox {
    String modelName; // 모델 명
    String resolution; // 해상도
    int price; // 가격
    String color; // 색

    // static 이 붙으면 클래스 변수, 위에 안붙은건 인스턴스 변수
    // 클래스변수는 클래스로부터 만들어지는 모든 객체에 똑같이 적용
    static boolean canAutoReport = false; // 자동 신고 기능

    void autoReport() {
        if (canAutoReport) {
            System.out.println("충돌이 감지되어 자동으로 신고 합니다.");
        } else {
            System.out.println("자동 신고 기능이 지원되지 않습니다.");
        }
    }

    void insertMemoryCard(int capacity) {
        System.out.println("메모리 카드가 삽입되었습니다.");
        System.out.println("용량은 " + capacity + "GB입니다.");
    }

    int getVideoFileCount(int type) {
        if (type == 1) {
            return 9;
        } else if (type == 2) { // 이벤트 영상
            return 1;
        }
        return 10;
    }
}
