package chap_09;

import java.util.HashSet;

public class _06_HashSet {
    public static void main(String[] args) {
        // 세트
        // 중복 X, 순서보장 되지 않음
        // 세트를 쓰고 싶은데 순서보장하고싶다? -> LinkedHashSet 사

        HashSet<String> set = new HashSet<>();
        set.add("삼겹살");
        set.add("쌈장");
        set.add("음료");
        set.add("소금");
        set.add("후추");
        set.add("상추");
        set.add("삼겹살");
        set.add("삼겹살");

        // 삼겹살 중복 제거됨
        System.out.println(set.size());
        System.out.println(set);

        // 순회
        for (String s : set) {
            System.out.println(s);
        }

        // 확인
        System.out.println(set.contains("삼겹살"));

        // 삭제
        set.remove("삼겹살");
        System.out.println(set);

        // 전체삭제
        set.clear();
        System.out.println(set.isEmpty());
        System.out.println(set);

        // 보다시피 array 와 같은 메소드들

    }
}
