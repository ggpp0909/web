package chap_04;

public class _06_while {
    public static void main(String[] args) {
        // 반복문 while
        // 수영장에서 수영을 하는 모습
        int dist = 25; // 전체거리 25m
        int move = 0; // 현재 이동거리

        // (조건) {실행}
        while (dist > move) {
            System.out.println("현재이동거리 " + move);
            move += 3;
        }
        System.out.println("도착");
    }
}
