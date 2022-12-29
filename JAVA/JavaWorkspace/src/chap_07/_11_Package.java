package chap_07;

import java.util.Random;

public class _11_Package {
    public static void main(String[] args) {
        // 패키지
        // 폴더 구조라고 보면 됨, 자바 클래스를 비슷한 것끼리 묶어주는 폴더 구조

        // 랜덤 클래스
        Random random = new Random();
        System.out.println("랜덤정수: " + random.nextInt()); // int 범위 내에서 정수형 값 반환
        System.out.println("랜덤 정수 (범위): " + random.nextInt(10)); // 0 이상 10 미만의 랜덤 정수
        System.out.println("랜덤 실수: " + random.nextDouble()); // 0.0이상 1.0 미만의 실수
        // System.out.println("랜덤 실수 (범위): " + random.nextDouble(10.0)); // 이런건 못함

        // 만약 5.0 이상 10.0 미만의 실수를 뽑으려면?
        double min = 5.0;
        double max = 10.0;
        System.out.println("랜덤 실수 (범위): " + (min + (max - min) * random.nextDouble()));

        // 랜덤 불리안
        System.out.println(random.nextBoolean());
    }
}
