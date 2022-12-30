package chap_12.clean;

public class Room {
    public int number = 1;

    // synchronized 로 동기화 해주면 여러 쓰레드가 접근시 동기화가 되어 다른 쓰레드가 메소드를 실행중이면 기다렸다가 실행함
    // 안해줄 경우 동시에 실행하는 경우가 생겨서 number++; 가 잘 안되는 경우 발생할 수 있음
    synchronized public void clean(String name) {
        // 직원 1: 3번방 청소 중
        System.out.println(name + " : " + number + "번방 청소 중");
        number++;
    }
}
