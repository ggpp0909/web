package chap_05;

public class _01_Array {
    public static void main(String[] args) {
        // 배열 : 같은 자료형의 값 여러개를 저장하는 연속된 공간
        String person1 = "아메리카노";
        String person2 = "카페모카";
        String person3 = "라떼";
        String person4 = "카푸치노";

        System.out.println(person1 + " 하나");
        System.out.println(person2 + " 하나");
        System.out.println(person3 + " 하나");
        System.out.println(person4 + " 하나");
        System.out.println("주세요"); // 불편

        // 배열 선언 첫 번째 방법
        String[] coffees = new String[5]; // 크기 4에 해당하는 String 배열 선언

        // 배열 선언 두 번째 방법, 대괄호 위치 선언
//       String coffees2[] = new String[4];

        coffees[0] = "아메리카노";
        coffees[1] = "카페모카";
        coffees[2] = "라떼";
        coffees[3] = "카푸치노";
        System.out.println(coffees[4]);

        // 세 번째 방법, 선언과 동시에 값 넣기
        String[] coffees3 = new String[] {"아메리카노", "카페모카", "라떼", "카푸치노"};

        // 네 번째 방법, 위와 동일, new String 생략
        String[] coffees4 = {"아메리카노", "카페모카", "라떼", "카푸치노"};

        for (int i = 0; i < 4; i++) {
            System.out.println(coffees4[i] +" 하나 주세요");
        }

        // 다른 자료형?
        int[] i = new int[3];
        double[] d = new double[] {10.0, 11.2, 13.5};
        // 에러
//        System.out.println(d[3]);

    }
}
