package chap_06;

public class _07_VariableScope {
    public static void methodA() {
//        System.out.println(number);
    }

    public static void methodB() {
        int result = 1; // 지역 변수는 변수가 선언된 영역 내에서만 사용 가능
    }

    public static void main(String[] args) {
        int number = 3; // 이것도 지역 변수
//        System.out.println(result);

        for (int i = 0; i < 5; i++) {
            System.out.println(i); // i도 for 문 안에서만 사용 가능
        }
        System.out.println(i);

        {
            int j = 0;
            System.out.println(j); // 선언된 중괄호 내에서만 사용 가능 (지역변수)
        }
        System.out.println(j);

    }
}
