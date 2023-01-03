package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 인터페이스는 다중 상속된다. JpaRepository<멤버, 식별자 pk>, MemberRepository
// 인터페이스만 만들면 끝
// 스프링 데이터 jpa가 Jparepository을 받고 있으면 구현체를 만들어주고 스프링 빈에 자동으로 등록해준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // JPQL 을 짜준다. select m from Member m where m.name = ?
    // 그럼 sql 로 번역해서 실행
    @Override
    Optional<Member> findByName(String name);
}
