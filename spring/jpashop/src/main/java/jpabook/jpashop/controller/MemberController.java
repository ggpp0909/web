package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm()); // 컨트롤러에서 뷰로 넘어갈때 데이터를 실어서 넘김, 여기서는 멤버폼 들어갈때 빈 껍데기만 넘ㅖ
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {
        // @Valid 로 MemberForm 이 넘어올 때 NotEmpty 와 같은 검증을 거침
        // 오류 발생시 코드가 팅겨버리는데 BindingResult 를 주면 오류가 result 에 담겨서 코드에 실행됨
        // 바로 Member 로 받는건 안되나? -> Hello world 급 간단한 폼에서는 가능하지만 실무에선 거의 안그러니 해당 form 에 fit 한 클래스를 만들어서 받는게 훨씬 나음

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
        Member member = new Member();

        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);
        return "redirect:/";
    }
}
