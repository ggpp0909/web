package chap_13;

public class _02_Output {
    public static void main(String[] args) {
        // System.out.format(); 과 동일
        // System.out.printf("포맷", 값1, 값2, 값3);

        System.out.println("----정수----");
        System.out.printf("%d%n", 1); // 1 정수값 출력 후 줄바꿈
        System.out.printf("%d %d %d%n", 1, 2, 3); // 1 2 3
        System.out.printf("%d%n", 1234); // 1234
        System.out.printf("%6d%n", 1234); // __1234,수를 출력하는데 6만큼의 공간을 확보 후 1234 출력
        System.out.printf("%06d%n", 1234); // 001234, 6만큼의 공간을 확보 후 1234 출력, 빈공간은 0으로 채움
        System.out.printf("%6d%n", -1234); // _-1234
        System.out.printf("%+6d%n", 1234); // _+1234 (항상 기호 표시)
        System.out.printf("%,15d%n", 1000000000); // ___1,000,000,000 (세자리마다 콤마로 구분)
        System.out.printf("%-6d%n", 1234); // 1234__, 6자리 공간 확보 후 왼쪽으로 정렬
    }
}
