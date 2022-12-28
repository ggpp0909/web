package chap_07;

public class _06_ClassMethod {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();
        b1.callServiceCenter();
        BlackBox b2 = new BlackBox();
        b2.callServiceCenter();

        // 클래스 변수처럼 클래스 메서드도 클래스 이름으로 접근하는 것을 권장
        BlackBox.callServiceCenter();
    }
}
