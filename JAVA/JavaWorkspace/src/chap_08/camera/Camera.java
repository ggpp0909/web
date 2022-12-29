package chap_08.camera;

// 추상클래스로는 객체 생성 불가
public abstract class Camera {
    public void takePicture() {
        System.out.println("사진을 촬영합니다.");
    }

    public void recordVideo() {
        System.out.println("동영상을 녹화합니다.");
    }

    // 추상클래스에서 정의하는 추상 메소드는 이름만 적어줌
    public abstract void showMainFeature(); // 구현해야 하는 메소드
}
