package chap_09.user;

import java.util.HashMap;

public class _07_HashMap {
    public static void main(String[] args) {
        // 맵 (KEY, VALUE)
        // 중복x, 순서x
        // 맵을 쓰고 싶은데 순서를 보장하고 싶다면 LinkedHashMap 쓰기
        HashMap<String, Integer> map = new HashMap<>();

        // 데이터 추가
        map.put("유재석", 10); // 키: 유재석
        map.put("김종국", 10);
        map.put("박명수",5);

        System.out.println(map.size());
        System.out.println(map);

        // 조회
        System.out.println(map.get("유재석"));
        System.out.println(map.get("김종국"));

        // 확인
        System.out.println(map.containsKey("김종국"));
        int point = map.get("김종국");
        map.put("김종국", ++point);
        System.out.println(map.get("김종국"));

        // 삭제
        map.remove("김종국");
        System.out.println(map.get("김종국"));

        // 전체 삭제
        map.clear();
        System.out.println(map.isEmpty());

        map.put("유재석", 10); // 키: 유재석
        map.put("김종국", 10);
        map.put("박명수", 5);

        // key 확인
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        // value 확인
        for (int value : map.values()) {
            System.out.println(value);
        }

        // key 와 value 함께 확인
        for (String key : map.keySet()) {
            System.out.println(key + ", " + map.get(key));
        }
    }
}
