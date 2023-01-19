package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // 엔티티 매니저 팩토리는 애플리케이션 로딩시점에 딱 하나만 만들어야함
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 실제 DB에 저장을 하는 등의 트랜잭션(고객이 뭔가 장바구니에 넣는 행위를 하고 나가는, db 커넥션을 얻어서 쿼리를 날리고 종료되는)을 할때마다 엔티티매니저를 만들어줘야 한다.
        // 엔티티 매니저는 쓰레드간에 절대 공유하면 안된다. (사용하고 버려야 한다.)
        // JPA 의 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다.
        EntityManager em = emf.createEntityManager();

        // DB 커넥션을 받는다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // code
        try {
            // 생성
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("memberB");
//            em.persist(member);

            // 조회
//            Member member = em.find(Member.class, 1L);

            // JPQL
            // 테이블을 대상으로 하지 않고 엔티티 객체를 대상으로 한다.
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8) 페이지네이션 예시
                    .getResultList();
            for (Member member : result) {
                System.out.println("member = " + member.getName());
            }

            // 수정
//            member.setName("HelloJPA"); // em.persist 안해도 알아서 업데이트 된다!!
            // JPA 를 통해서 가져오면 JPA 가 관리한다. 트랜잭션이 커밋하는 시점에 변경이 됐는지 체크한다. 바뀌었으면 자동으로 업데이트 쿼리 만들어서 날린다.

            // 삭제
//            em.remove(member);

            tx.commit();
        } catch (Exception e) { // 도중 오류 발생하면 롤백
            tx.rollback();
        } finally {
            // 오류가 나든 말든 닫아줘야한다.
            em.close();
        }

        emf.close();
    }
}
