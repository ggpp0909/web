package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// 인터페이스로 구현한 구현체

public class MemoryMemberRepository implements MemberRepository {

    // 스태틱을 붙여서 어디서 인스턴스를 생성하던지 똑같은 변수 값을 얻게끔함 (DB 역할)
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // 없으면 null 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // 모든 애들 중에 name 과 일치하는 애 찾기
                .findAny(); // 하나라도 찾는 것, 결과가 Optional 로 반환됨, 있으면 걔 반환 없으면 null 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
