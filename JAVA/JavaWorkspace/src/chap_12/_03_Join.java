package chap_12;

import chap_12.clean.CleanRunnable;

public class _03_Join {
    public static void main(String[] args) {
        CleanRunnable cleanRunnable = new CleanRunnable();
        Thread thread = new Thread(cleanRunnable);
        thread.start();

        // join: 쓰레드의 동작이 끝날 때 까지 기다리거나, 어느정도 시간을 기다린 후 실행 하기 위함
        try {
            thread.join(2500); // 2.5초 대기
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        cleanByBoss();
    }

    public static void cleanByBoss() {
        System.out.println("사장 청소 시작");
        for (int i = 1; i < 10; i += 2) {
            System.out.println("사장 " + i + "번째 방 청소");
            try {
                Thread.sleep(1000); // 딜레이
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("사장 청소 끝");
    }
}
