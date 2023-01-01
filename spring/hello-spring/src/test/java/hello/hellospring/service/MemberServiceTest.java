package hello.hellospring.service;

import hello.hellospring.domain.Member;

import hello.hellospring.repository.MemoryMemberRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    // 메소드 실행 끝날 때 마다 동작하는 메소드
    // 이곳에서 clear 해줘야 함
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }


    // 테스트 코드는 과감하게 한글로 적어도 상관없다 (직관적으로)
    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member = new Member();
        member.setName("spring");

        Member member2 = new Member(); // 이름 한번에 바꾸기 단축키 쉬프트 F6
        member2.setName("spring");

        // when
        memberService.join(member);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));// 뒤에 로직이 실행되면 앞의 예외가 터져야 한다
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다."); // 어떤 메세지인지 까지 테스트 가능

        // 이것과 동일
//    일   try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
//        }

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}