package chap_09;

import java.util.ArrayList;
import java.util.Collections;

public class _04_ArrayList {
    public static void main(String[] args) {
        // 컬렉션 프레임워크
        // List, Set, Map

        ArrayList<String> list = new ArrayList<>();

        // 데이터 추가
        list.add("유재석");
        list.add("조세호");
        list.add("김종국");
        list.add("박명수");
        list.add("강호동");

        // 데이터 조회
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(4));
        System.out.println(" ------ ");

        // 데이터 삭제
        System.out.println("신청 학생 수 (이사 전) : " + list.size());
        list.remove("박명수");
        System.out.println("신청 학생 수 (이사 후) : " + list.size());
        System.out.println(list.get(3));
        System.out.println(" ------ ");

        System.out.println("남은 학생 수 (제외 전) : " + list.size());
        list.remove(list.size() - 1); // 인덱스로도 가능, 마지막 인덱
        System.out.println("남은 학생 수 (제외 후) : " + list.size());

        // 순회
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(" ------ ");

        // 데이터 변경
        list.get(0);
        list.set(0, "이수근");
        list.get(0);
        System.out.println(" ------ ");

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
