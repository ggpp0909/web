package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository // 스프링 빈으로 등록 (컴포넌트 스캔)
@RequiredArgsConstructor // 스프링 데이터 JPA 를 쓰면 레포지토리에서 PersistenceContext 대신 autowired 어노테이션 써도 주입 되도록 지원해줌 따라서 이렇게 일관성 있게 쓸 수 있음
public class MemberRepository {

//    @PersistenceContext // jpa 의 엔티티매니저를 스프링이 자동으로 주입시켜준다.
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) // JPQL, 문법은 SQL 과 거의 똑같은데 차이는 테이블을 대상으로 하는게 아니라 엔티티를 대상으로 함
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
