package chap_12;

import chap_12.clean.CleanThread;

public class _01_Thread {
    public static void main(String[] args) {
        // 쓰레드
        // 실행된 프로그램을 프로세스, 프로세스의 자원을 이용하여 실제로 작업을 수행하는 것을 쓰레드라고 함
        // 프로세스는 여러개의 쓰레드를 가질 수 있음.
        // 별도의 처리가 없으면 하나의 쓰레드를 가짐

        // cleanBySelf();
        CleanThread cleanThread = new CleanThread();

        // 이렇게 run 을 직접 호출하면 동시 작업 X
        // cleanThread.run(); // 직원 청소

        // start()로 호출하면 run 을 호출하여 동시 작업
        cleanThread.start();
        cleanByBoss(); // 사장 청소
    }

    public static void cleanBySelf() {
        System.out.println("혼자 청소 시작");
        for (int i = 0; i < 10; i ++) {
            System.out.println("혼자 " + i + "번째 방 청소");
        }
        System.out.println("혼자 청소 끝");
    }

    public static void cleanByBoss() {
        System.out.println("사장 청소 시작");
        for (int i = 1; i < 10; i += 2) {
            System.out.println("사장 " + i + "번째 방 청소");
        }
        System.out.println("사장 청소 끝");
    }
}
