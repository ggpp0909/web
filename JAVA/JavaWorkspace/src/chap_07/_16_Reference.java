package chap_07;

import chap_07.camera.Camera;

public class _16_Reference {
    public static void main(String[] args) {
        // 참조
        // 기본 자료형 (Primitive Data Type) : int, float, double, long, boolean, ...
        // 기본 값을 가짐, 0, 0.0 등등

        // 참조 자료형 (Non-Primitive, Reference Data Types) : String, Camera, FactoryCam ...
        // 기본 값은 null, 메서드를 가질 수 있음, 대문자로 시작

        //////////
        int a = 10;
        int b = 20;
        b = a;
        System.out.println(a);
        System.out.println(b);
        b = 30;
        System.out.println(a);
        System.out.println(b);
        System.out.println("-------------");
        Camera c1 = new Camera();
        Camera c2 = new Camera();
        c1.name = "카메라1";
        c2.name = "카메라2";

        System.out.println(c1.name);
        System.out.println(c2.name);
        c2 = c1; // 단순한 값 복사
        System.out.println(c1.name);
        System.out.println(c2.name);

        c2.name = "고장난 카메라";
        System.out.println(c1.name); // 고장난 카메라
        System.out.println(c2.name); // 고장난 카메라
        // 이유  c1, c2는 어딘가에 만들어진 메모리 공간을 참조하고 있음
        // c2 = c1 에서 같은 메모리 공간을 바라보게 됨

        changeName(c2);
        System.out.println(c1.name); // 잘못된 카메라
        System.out.println(c2.name); // 잘못된 카메라
    }


    public static void changeName(Camera camera) {
        camera.name = "잘못된 카메라";
    }
}
