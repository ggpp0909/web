package chap_07.camera;

// 클래스에 final 붙이면 상속 불가능하게 만들 수 도 있음
public class ActionCam extends Camera {
    // final 로 인해 어디에서도 값을 바꿀 수 없음
    // 직접 초기화 해도 되고 생성자에서 해도 된다.
    public final String lens; // = "광각렌즈";

    public ActionCam() {
        super("액션 카메라");
        lens = "광각렌즈";
    }

    // 메서드도 final로 자식클래스에서 오버라이딩 못하게 할 수 있음
    public final void makeVideo() {
        System.out.println(this.name + " : " + this.lens + "로 촬영한 멋진 비디오를 제작합니다.");
    }
}
