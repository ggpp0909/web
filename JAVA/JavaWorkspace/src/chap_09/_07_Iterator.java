package chap_09;

import java.util.*;

public class _07_Iterator {
    public static void main(String[] args) {
        // 이터레이터
        // List 는 인터페이스, 다형성에 의해 List 로 객체 생성 가능
        List<String> list = new ArrayList<>();
        list.add("유재석");
        list.add("잘못된 정보");
        list.add("조세호");
        list.add("잘못된 정보");
        list.add("김종국");
        list.add("박명수");
        list.add("잘못된 정보");
        list.add("강호동");

        System.out.println(list);
        System.out.println("--------");

        // 반환 형을 가지는 메서드는 마우스 두고 cmd + option + v 로 변수 자동생성 가능
        Iterator<String> it = list.iterator();

        // 커서가 계속 이동함
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());

        // 순회
        it = list.iterator(); // 커서 처음으로 초기화
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 잘못된 데이터 삭제하면서 순회
        it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.contains("잘못된")) {
                it.remove(); // 삭제
            }
        }

        System.out.println(list);

        // 세트와 맵에서도 사용 가능

        HashSet<String> set = new HashSet<>();
        set.add("쌈장");
        set.add("후추");
        set.add("상추");
        Iterator<String> itSet = set.iterator();

        while (itSet.hasNext()) {
            String s = itSet.next();
            if (s.contains("쌈장")) {
                itSet.remove(); // 삭제
            }
        }

        System.out.println(set);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("유재석", 10);
        map.put("박명수", 5);

        // map.iterator() // 제공되지 않음
        Iterator<String> iterMapKey = map.keySet().iterator();
        while (iterMapKey.hasNext()) {
            String s = iterMapKey.next();
            if (s.contains("유재석")) {
                iterMapKey.remove(); // 삭제
            }
        }
        System.out.println(map);

        // 키 밸류 함께 조회
        Iterator<Map.Entry<String, Integer>> itMap = map.entrySet().iterator();
        while (itMap.hasNext()) {
            System.out.println(itMap.next());
        }


    }
}

