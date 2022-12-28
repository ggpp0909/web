package chap_03;

public class _01_String {
    public static void main(String[] args) {
        String s = "I like Java and Python and C.";
        System.out.println(s);

        // 문자열 길이
        System.out.println(s.length());

        // 대소문자 변환
        System.out.println(s.toUpperCase()); // 대문자로
        System.out.println(s.toLowerCase()); // 소문자로

        // 포함 관계
        System.out.println(s.contains("Java")); // true, 포함 된다면 true, 안된다면 false
        System.out.println(s.contains("C#")); // false
        System.out.println(s.indexOf("Java")); // 7, 포함된다면 첫 글자의 인덱스
        System.out.println(s.indexOf("C#")); // -1, 포함 안된다면 -1
        System.out.println(s.indexOf("and")); // 12, 처음 일치하는 위치 정보
        System.out.println(s.lastIndexOf("and")); // 23, 마지막에 일치하는 위치 정보
        System.out.println(s.startsWith("I like")); // true, 이 문자열로 시작 하면 true
        System.out.println(s.endsWith("C.")); // true, 이 문자열로 끝나면 true
    }
}
