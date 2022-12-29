package chap_08;

import chap_07.BlackBoxRefurbish;

public class _00_AccessModifierTest {
    public static void main(String[] args) {
        BlackBoxRefurbish b1 = new BlackBoxRefurbish();
        b1.modelName = "까망이"; // public
        // b1.resolution = "FHD"; // default, 다른패키지 이므로 접근 불가
        // b1.price = 200000; // private, 해당 클래스 내에서만 접근 가능
        // b1.color = "화이트"; // protected, 자식클래스 아님, 다른 패키지 이므로 접근 불가
    }
}
