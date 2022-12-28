package chap_07;

public class BlackBox {
    String modelName; // 모델 명
    String resolution; // 해상도
    int price; // 가격
    String color; // 색

    // static 이 붙으면 클래스 변수, 위에 안붙은건 인스턴스 변수
    // 클래스변수는 클래스로부터 만들어지는 모든 객체에 똑같이 적용
    static boolean canAutoReport = false; // 자동 신고 기능
}
