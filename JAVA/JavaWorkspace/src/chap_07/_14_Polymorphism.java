package chap_07;

import chap_07.camera.Camera;
import chap_07.camera.FactoryCam;
import chap_07.camera.SpeedCam;

public class _14_Polymorphism {
    public static void main(String[] args) {
        // 다형성
        // Speedcam is a Camera. (IS-A) 관계
        // class Person : 사람
        // class Student extends Person : 학생 (학생은 사람이다. Student is a person)
        // class teacher extends Person : 선생님 (선생님은 사람이다. Teacher is a person)
        // 역은 성립하지 않음. 이처럼 상속은 부모와 자식간에 is a 관계가 있다.

        // 부모 클래스 이름으로 만들 수 있음
        Camera camera = new Camera();
        Camera factoryCam = new FactoryCam();
        Camera speedCam = new SpeedCam();

        camera.showMainFeature();
        factoryCam.showMainFeature();
        speedCam.showMainFeature();

        // 이렇게 하면 다음과 같은 이점이 있음
        Camera[] cameras = new Camera[3];
        cameras[0] = new Camera();
        cameras[1] = new FactoryCam();
        cameras[2] = new SpeedCam();

        for (Camera cam : cameras) {
            cam.showMainFeature();
        }

        System.out.println("-----");

        // 하지만 다음과 같은 문제가 있음
        // Camera라는 이름의 부모클래스로 정의했기 때문에 자식 클래스에만 있는 것들을 쓸 수 없음
//        speedCam.checkSpeed();
//        factoryCam.detectFire();


        if (camera instanceof Camera) {
            System.out.println("카메라 입니다.");
        }

        if (factoryCam instanceof FactoryCam) { // factoryCam이 FactoryCam의 인스턴스라면
            ((FactoryCam) factoryCam).detectFire(); // 형변환 하여 사용 가능
        }

        if (speedCam instanceof SpeedCam) {
            ((SpeedCam) speedCam).recognizeLicensePlate();
        }

        // 참고
        // 모든 클래스는 Object라는 클래스를 상속받고 있음
        Object[] objs = new Object[3];
        objs[0] = new Camera();
        objs[1] = new Camera();
        objs[2] = new Camera();
    }
}
