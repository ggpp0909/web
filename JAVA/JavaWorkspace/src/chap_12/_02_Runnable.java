package chap_12;

import chap_12.clean.CleanRunnable;

public class _02_Runnable {
    public static void main(String[] args) {
        // 쓰레드를 다르게 만드는 방법
        CleanRunnable cleanRunnable = new CleanRunnable();
        Thread thread = new Thread(cleanRunnable);
        thread.start();

        cleanByBoss();

        // 앞에서 만든 cleanThread 와의 차이가 뭘까?
        // cleanThread 는 Thread 를 상속받고 cleanRunnable 은 Runnable 인터페이스를 구현함
        // 상속은 단일상속만 가능하므로 Thread 를 상속받는 클래스가 다른 부모 클래스를 상속받고 싶다면 불가능
        // 이럴때 Runnable 인터페이스를 쓰면 된다. (인터페이스는 여러 번 구현할 수 있으므로)
    }

    public static void cleanByBoss() {
        System.out.println("사장 청소 시작");
        for (int i = 1; i < 10; i += 2) {
            System.out.println("사장 " + i + "번째 방 청소");
        }
        System.out.println("사장 청소 끝");
    }
}
