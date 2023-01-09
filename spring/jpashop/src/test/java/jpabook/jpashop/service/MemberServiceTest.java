package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@RunWith(SpringRunner.class) // junit 실행할 때 스프링과 엮어서 실행할래
@SpringBootTest // 스프링 부트를 띄운 상태로 실행, 요 두가지로 완전히 스프링과 integration 해서 테스트를 할 것
@Transactional // 테스트 후 데이터 롤백 (테스트에서)
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
//    @Rollback(value = false) // 이렇게 하면 롤백 안하고 커밋함
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("jang");

        //when
        Long saveId = memberService.join(member);

        //then
        em.flush(); // 이렇게 로그로 커밋 전 insert 문 확인할 수 있음
        Assertions.assertThat(member).isEqualTo(memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setName("kim");
        member2.setName("kim");

        //when
        memberService.join(member1);
        memberService.join(member2); // 예외가 발생해야 한다.

        //then
        Assertions.fail("예외가 발생해야 한다.");

    }
}