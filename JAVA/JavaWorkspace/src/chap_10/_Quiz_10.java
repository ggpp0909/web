package chap_10;

// 스트림을 이용하여 미술관 방문 손님에게 적절한 입장료를 안내하는 프로그램을 작성하시오
// 조건
// 손님이름 및 나이정보를 위한 Customer 클래스 생성
// 입장료는 1인당 5000원으로 고정
// 20세 이상의 손님들에게만 입장료 부과 (그 외에는 무료)
// 모든 클래스는 하나의 파일에 정의

// 힌트
// map 을 이용하여 원하는 현태로 데이터를 가공할 수 있음
// 삼항연산자

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Quiz_10 {
    public static void main(String[] args) {
        List<Customer> arr = Arrays.asList(
                new Customer("챈들러", 50),
                new Customer("레이첼", 42),
                new Customer("모니카", 21),
                new Customer("벤자민", 18),
                new Customer("제임스", 5)
        );

        arr.stream().map(x -> x.age >= 20 ? x.name + " 5000원" : x.name + " 무료")
                .forEach(System.out::println);
    }
}

class Customer {
    String name;
    int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
