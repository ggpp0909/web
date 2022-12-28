package chap_05;

public class _02_ArrayLoop {
    public static void main(String[] args) {
        String[] coffees4 = {"아메리카노", "카페모카", "라떼", "카푸치노"};
        for (int i = 0; i < 4; i++) {
            System.out.println(coffees4[i] + " 하나 주세요");
        }

        // 배열의 길이를 이용
        for (int i = 0; i < coffees4.length; i++) {
            System.out.println(coffees4[i] + " 하나 주세요");
        }

        // enhanced for (for-each) 반복문, foreach 라고 치면 편함
        for (String coffee : coffees4) {
            System.out.println(coffee + " 하나 주세요");
        }
    }
}
