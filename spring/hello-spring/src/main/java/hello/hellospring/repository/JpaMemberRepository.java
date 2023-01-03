package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    // JPA 는 엔티티 매니저로부터 모든것이 동작된다.
    // JPA 라이브러리 받으면 스프링 부트가 알아서 만들어줌. 우리는 주입만 하면 됨
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) { // 이렇게 하면 JPA 가 INSERT 쿼리 만들어서 DB 에 집어넣음 (setID 이런거 다 해줌)
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);// 조회할 타입, 식별자 아이디
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        // findName 같은 PK 기반이 아닌 것들은 조금 특별한 JPQL 이라는 객체지향 쿼리를 써야함
        // JPQL 은 객체를 대상으로 쿼리를 날린다 그럼 SQL 로 번역됨
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // Member 엔티티를 조회 해, * 이 아니라 m 이라고 함, 엔티티 자체를 셀렉트하는 것
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
