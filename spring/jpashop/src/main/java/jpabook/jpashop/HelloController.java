package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String Hello(Model model) { // model 에 데이터를 실어서 뷰로 넘길 수 있다.
        model.addAttribute("data", "hello!!");
        return "hello"; // 화면 이름, 뒤에 html 생략 됨
    }
}
