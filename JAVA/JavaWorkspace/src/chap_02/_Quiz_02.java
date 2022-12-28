package chap_02;

// 어린이 키에 따른 노링기구 탑승 가능 여부를 확인하는 프로그램 작성
// 조건
// 키가 120cm 이상인 경우에만 탑승 가능
// 삼항연산자 이용
public class _Quiz_02 {
    public static void main(String[] args) {
        int h = 126;
        String ans = h >= 120 ? "키가 " + Integer.toString(h) + "cm 이므로 탑승 가능 합니다." : "키가 " + Integer.toString(h) + "cm 이므로 탑승 불가능 합니다.";
        System.out.println(ans);
    }
}
