package chap_10;

import chap_10.converter.*;

public class _04_FunctionalInterface {
    public static void main(String[] args) {
        KRWConverter converter = new KRWConverter();
//        converter.convert(2);
        convertUSD(converter, 2);

        // 람다식 활용
        convertUSD(USD -> System.out.println(USD + "달러 = " + (USD * 1400) + " 원"), 2);

        // 인터페이스 활용
        // 이런 인테페이스를 함수형 인터페이스라고 함
        // 함수형 인터페이스 이용하기 위해서는 인터페이스에서는 딱 하나의 추상메서드만 존재해야 한다는 조건이 있음
        Convertible convertible = USD -> System.out.println(USD + "달러 = " + (USD * 1400) + " 원");
        convertUSD(convertible, 3);

        // 전달값이 하나도 없다면?
        ConvertibleWithNoParams c1 = () -> System.out.println("1달러는 1400원");
        c1.convert();

        // 두 줄 이상의 코드가 있다면?
        c1 = () -> {
            int USD = 5;
            int KRW = 1400;
            System.out.println(USD * KRW);
        };
        c1.convert();

        // 전달값이 2개인 경우?

        ConvertibleWithTwoParams c2 = (d, w) -> System.out.println(d + "달러는 " + (d * w) + "원");
        c2.convert(2, 10);

        // 반환 값이 있는 경우?
        ConvertibleWithReturn c3 = (d, w) -> d * w;
        int result = c3.convert(20, 1400);
        System.out.println(result);
        
    }

    public static void convertUSD(Convertible converter, int USD) {
        converter.convert(USD);
    }
}
