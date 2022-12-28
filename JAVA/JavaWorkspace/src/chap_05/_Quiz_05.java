package chap_05;

// 배열을 활용하여 쇼핑몰에서 구매 가능한 신발 사이즈 옵션을 출력하는 프로그램을 작성
// 조건
// 신발 사이즈는 250부터 290까지 5 단위로 증가
// 신발 사이즈 수는 총 10가지

public class _Quiz_05 {
    public static void main(String[] args) {
        int[] sizes = new int[10];
        int init = 250;
        for (int i = 0; i < 10; i++) {
            sizes[i] = init;
            System.out.println(sizes[i]);
            init += 5;
        }
    }
}
