package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원을 저장하면 저장된 회원이 반환
    Optional<Member> findById(Long id); // id 로 회원 찾기, Optional 은 없으면 null 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
