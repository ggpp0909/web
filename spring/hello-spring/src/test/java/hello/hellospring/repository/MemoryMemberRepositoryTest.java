package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    // 1. 일단 객체 만들기
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 메소드 실행 끝날 때 마다 동작하는 메소드
    // 이곳에서 clear 해줘야 함
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    // 2. Test 어노테이션 붙여서 만들기
    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); // 옵셔널에서는 get 으로 값 꺼낼 수 있음
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(member, result); // (기대하는것, 실제값), 다르면 오류뜸, 같으면 아무문제없이 실행됨

        // 좀더 편하게 쓸 수 있는것 기댓값이 결과값과 같다 순서로작성
        assertThat(member).isEqualTo(result);
    }


    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
//        Member result = repository.findByName("spring2").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result).isEqualTo(2);
    }
}
