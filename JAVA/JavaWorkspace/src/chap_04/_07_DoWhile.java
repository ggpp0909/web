package chap_04;

public class _07_DoWhile {
    public static void main(String[] args) {
        // 반복문 do while
        int dist = 25; // 전체거리 25m
        int move = 0; // 현재 이동 거리 0m
        int height = 2; // 키 2m

        while (move + height < dist) {
            System.out.println("발차기를 계속 합니다.");
            System.out.println("현재 이동거리 : " + move);
            move += 3;
        }
        System.out.println("도착");

        ////////
        // 키가 엄청나게 큰 사람?
        move = 0;
        height = 25; // 키 25m

        // 반복문 조건이 참인 경우가 없어서 실행이 안됨.
        while (move + height < dist) {
            System.out.println("발차기를 계속 합니다.");
            System.out.println("현재 이동거리 : " + move);
            move += 3;
        }
        System.out.println("도착");

        // do while 반복문
        // 최소 한번은 do 영역 실행, 그후 조건 확인하여 do 반복
        do {
            System.out.println("발차기를 계속 합니다.");
            System.out.println("현재 이동거리 " + move);
        } while (move + height < dist) ;
    }
}
