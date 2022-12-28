package chap_03;

public class _03_StringCompare {
    public static void main(String[] args) {
        // 문자열 비교
        String s1 = "Java";
        String s2 = "Python";

        System.out.println(s1.equals(s2)); // 문자열 내용이 같으면 true, 다르면 false
        System.out.println(s1.equals("Java")); // true
        System.out.println(s2.equals("python")); // false, 대소문자 구분
        System.out.println(s2.equalsIgnoreCase("python")); // true, 대소문자 구분 X

        // 문자열 비교 심화
        s1 = "1234"; // 참조
        s2 = "1234";

        System.out.println(s1.equals(s2)); // true (내용)
        System.out.println(s1 == s2); // true (참조)

        s1 = new String("1234"); // 서로 다른 메모리 공간에 할당됨
        s2 = new String("1234");
        System.out.println(s1.equals(s2)); // true (내용)
        System.out.println(s1 == s2); // false

        // 즉 자바에서 일반적으로 내용만 비교할때는 등호보다는 equals 사용하기.


    }
}
