package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId(); // 커맨드와 쿼리를 분리해라, 멤버를 등록시키는 커맨드성이기 때문에 아이디정도만 리
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
