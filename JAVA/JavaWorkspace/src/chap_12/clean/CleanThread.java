package chap_12.clean;

// Thread 를 만드려면 interface 익스텐즈하고 run 정의해야함
public class CleanThread extends Thread {
    public void run() {
        System.out.println("직원 청소 시작 (Thread)");
        for (int i = 0; i < 10; i += 2) {
            System.out.println("직원이 " + i + "번째 방 청소");
        }
        System.out.println("직원 청소 끝 (Thread)");
    }
}
