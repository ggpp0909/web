package chap_08.camera;

public class SpeedCam extends Camera{
    @Override
    public void showMainFeature() {
        System.out.println("속도 측정, 번호 인식");
    }

    public void detect() {
        System.out.println("사고를 감지합니다.");
    }

    public void report() {
        System.out.println("사고신고를 진행합니다.");
    }
}
