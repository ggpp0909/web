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

    void record(boolean showDateTime, boolean showSpeed, int min) {
        System.out.println("녹화를 시작합니다.");
        if (showDateTime) {
            System.out.println("영상에 날짜정보가 표시됩니다.");
        }
        if (showSpeed) {
            System.out.println("영상에 속도정보가 표시됩니다.");
        }
        System.out.println("영상은 " + min + "분 단위로 표시됩니다.");
    }

    void record() {
        // 유지보수를 위해 일일히 쓰지않고 호출
        record(true, true, 5);
    }

    // static 이 붙어서 class 메서드, 모든 객체에 공통적으로 적용
    static void callServiceCenter() {
        System.out.println("서비스센터로 연결합니다.");

        // 클래스 변수는 클래스 메서드 내에서 수정 가능
        // 인스턴스 변수는 클래스 메서드 내에서는 직접 접근 불가
        canAutoReport = true;
    }

    void appendModelName(String modelName) {
        // 앞은 인스턴스 변수, 뒤는 매개변수
        // 두 변수 명이 같을 경우는 this 로 명시, 변수명이 다르면 생략 가능
        this.modelName += modelName;
    }
}
