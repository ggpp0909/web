package chap_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _05_Stream {
    public static void main(String[] args) {
        // 스트림 (데이터가 흐른다, 데이터가공(필터링) 하면서 흘리기)

        // 스트림 생성

        // 배열에서 스트림 만드는 법
        int[] scores = {100, 95, 90, 85, 80};
        IntStream scoreStream = Arrays.stream(scores);

        String[] langs = {"Python", "Java", "C", "C#"};
        Stream<String> langStream = Arrays.stream(langs);

        // 컬렉션에서 스트림 만드는 법
        List<String> langList = new ArrayList<>();
        // add 로 하나하나 추가 안하고 바로 넣기
        langList = Arrays.asList("Python", "Java", "C", "C#");
        System.out.println(langList);
        Stream<String> langListStream = langList.stream();

        // 이렇게 스트림 생성도 가능
        Stream<String> langListOfStream = Stream.of("Python", "Java", "C", "C#");

        // 스트림 사용

        // 중간 연산 (Intermediate Operation) : filter, map, sorted, distinct, skip, ...
        // 최종 연산 (Terminal Operation) : count, min, max, sum, forEach, anyMatch, allMatch, ...

        // 90점 이상인 점수만 출력
        Arrays.stream(scores).filter(x -> x >= 90)
                .forEach(x -> System.out.println(x));
        // Arrays.stream(scores).filter(x -> x >= 90).forEach(System.out::println); // 위와 동일

        // 90점 이상인 사람의 수
        int count = (int) Arrays.stream(scores).filter(x -> x >= 90).count();
        System.out.println(count);

        // 90점 이상인 점수들의 합
        int sum = Arrays.stream(scores).filter(x -> x >= 90).sum();
        System.out.println(sum);

        // 90점 이상인 점수들을 정렬
        Arrays.stream(scores).filter(x -> x >= 90)
                .sorted()
                .forEach(System.out::println);

        // "Python", "Java", "C", "C#"
        // C로 시작하는 프로그래밍 언어
        Arrays.stream(langs).filter(x -> x.startsWith("C"))
                .forEach(System.out::println);

        // Java 라는 글자를 포함하는 언어
        Arrays.stream(langs).filter(x -> x.contains("Java"))
                .forEach(System.out::println);

        // 글자 개수가 4글자 이하인 언어를 정렬해서 출력
        Arrays.stream(langs).filter(x -> x.length() <= 4)
                .sorted()
                .forEach(System.out::println);
        langList.stream().filter(x -> x.length() <= 4)
                .sorted()
                .forEach(System.out::println);

        // 4글자 이하인 언어 중에서 C라는 글자를 포함하는 언어
        langList.stream().filter(x -> x.length() <= 4)
                .filter(x -> x.contains("C"))
                .forEach(System.out::println);

        // 4글자 이하인 언어 중에서 C라는 글자를 포함하는 언어가 하나라도 있는지?
        boolean anyMatch = langList.stream().filter(x -> x.length() <= 4)
                .anyMatch(x -> x.contains("C"));

        System.out.println(anyMatch);

        // 4글자 이하인 언어들은 모두 C라는 글자를 포함하는지?

        boolean allMatch = langList.stream().filter(x -> x.length() <= 4)
                .allMatch(x -> x.contains("C"));

        System.out.println(allMatch);

        // 4글자 이하인 C라는 글자를 포함하는 언어 뒤에 "어려워요" 라는 글자를 함께 출력
        // map
        langList.stream().filter(x -> x.length() <= 4)
                .filter(x -> x.contains("C"))
                .map(x -> x + " 어려워요")
                .forEach(System.out::println);

        // C라는 글자를 포함하는 언어를 대문자로 출력
        langList.stream().filter(x -> x.contains("C"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 가공된 데이터를 리스트로 저장
        // C라는 글자를 포함하는 언어를 대문자로 출력
        List<String> langListStartsWithC = langList.stream().filter(x -> x.contains("C"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(langListStartsWithC);

    }
}
