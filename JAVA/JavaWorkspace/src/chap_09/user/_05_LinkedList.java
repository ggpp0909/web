package chap_09.user;

import java.util.Collections;
import java.util.LinkedList;

public class _05_LinkedList {
    public static void main(String[] args) {
        // 링크드 리스트
        LinkedList<String> list = new LinkedList<>();
        list.add("유재석");
        list.add("조세호");
        list.add("김종국");
        list.add("박명수");
        list.add("강호동");

        // 데이터 조회
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        // 추가
        list.addFirst("서장훈");
        System.out.println(list);
        list.addLast("김희철");
        System.out.println(list);

        // array list, linked list 둘다 사용 가능한거, 중간에 데이터 넣기
        // 지정된 인덱스에 넣고 나머지는 뒤로 밀리는 효과
        list.add(1, "김영철");
        System.out.println(list);

        // 값 삭제
        list.remove(list.size() - 1);
        System.out.println(list);

        // 처음, 마지막 값 삭제
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);

        // 변경
        list.set(0, "이수근");

        // 인덱스 확인
        System.out.println(list.indexOf("김종국"));

        // 리스트 내에 있는 지?
        System.out.println(list.contains("김종국"));

        // 전체 삭제
        list.clear();
        System.out.println(list.isEmpty());

        list.add("유재석");
        list.add("조세호");
        list.add("김종국");
        list.add("박명수");
        list.add("강호동");

        // 정렬
        Collections.sort(list);
        System.out.println(list);
    }
}
