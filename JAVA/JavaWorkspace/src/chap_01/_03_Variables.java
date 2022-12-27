package chap_01;

public class _03_Variables {
    public static void main(String[] args) {
//        String name; // 변수 선언
//        name = "영남";
        String name = "영남";
        // 정수형
        int hour = 1;

        System.out.println(name + "님, 배송이 시작됩니다. " + hour + "시에 방문 예정입니다.");
        System.out.println(name + "님, 배송이 완료되었습니다.");

        // 실수형
        double score = 90.5;
        // 한글자, 작음따음표 필수
        char grade = 'A';
        name = "철수";
        System.out.println(name  +"님의 평균 점수는 " + score + "점입니다.");
        System.out.println("학점은" + grade + "입니다.");

        // 불리안
        boolean pass = true;
        System.out.println("이번 시험에 합격했을까요? " + pass);

        // 실수형, 더블보단 정밀도가 떨어짐
        double d = 3.14123456789;
        float f = 3.14123456789F; // 실수값 뒤에 F 붙이기
        System.out.println(d);
        System.out.println(f);

// 너무큼 int 는 약 -21억부터 21억 사이숫자 가능
//        int i = 100000000000;

        long l = 1000000000000L; // int 보다 훨씬 큰 범위 값 가질 수 있음
        l = 1_000_000_000_000L; // 이렇게 해도 똑같음, 가독성증가
        System.out.println(l);
    }
}
