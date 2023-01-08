package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // 빈 등록
@Transactional(readOnly = true) // 데이터 변경은 꼭 트랜잭셔널이 있어야 함 (스프링 제공 임포트 권장), 읽기 전용 일때 이렇게 하면 jpa 가 성능 최적화 해줌
@RequiredArgsConstructor // 3 최종 형태 final 키워드가 있는 필드 변수만 생성자를 만들어줌(롬복) -> 생성자가 하나이므로 자동으로 Autowired
public class MemberService {
    // 1
//    @Autowired // 스프링이 스프링 빈에 등록되어 있는 멤버 리포지토리를 인젝션 해줌 (필드 인젝션, 보통 이렇게 많이 쓰지만 단점이 많음, 생성자 인젝션으로 쓰기)
//    private MemberRepository memberRepository;

    private final MemberRepository memberRepository;

    // 2
    // 생성자가 하나만 있을 경우에 Autowired 생략 가능
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    /**
     * 회원 가입
     */
    @Transactional // 여긴 읽기 전용이 많으니까 기본으로 읽기 전용으로 하고 그게 아닌것만 @Transactional 로 따로 처리
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    // 이렇게 해도 클라이언트가 각각 멤버(같은이름)를 동시에 요청 보내는 상황이면 동시에 여기를 통과할 수 있음 -> 최후의 방어수단으로 DB 에서 유니크 옵션 해주기
    private void validateDuplicateMember(Member member) {
        // EXCEPTION
        List<Member> findMember = memberRepository.findByName(member.getName());
        if (!findMember.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 회원 전체 조회
     */

    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    /**
     * 회원 한명 조회
     */
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
