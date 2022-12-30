package chap_12;

public class _04_MultiThread {
    public static void main(String[] args) {
        Runnable cleaner1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("직원1 청소 시작");
                for (int i = 1; i < 10; i += 2) {
                    System.out.println("직원1이 " + i + "번째 방 청소");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("직원1 청소 끝");
            }
        };

        // 람다식으로
        // Runnable 은 Functional 인터페이스이므로 람다식으로 동작을 정의해주면 run 호출 시 그 동작이 수행 됨
        Runnable cleaner2 = () -> {
            System.out.println("직원2 청소 시작");
            for (int i = 2; i < 10; i += 2) {
                System.out.println("직원2이 " + i + "번째 방 청소");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("직원2 청소 끝");
        };

        Thread cleanerThread1 = new Thread(cleaner1);
        Thread cleanerThread2 = new Thread(cleaner2);

        cleanerThread1.start();
        cleanerThread2.start();

        // 필요한 만큼 얼마든지 만들 수 있음

    }
}
