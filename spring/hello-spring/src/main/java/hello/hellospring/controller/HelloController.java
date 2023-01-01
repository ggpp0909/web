package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // 웹 어플리케이션에서 /Hello 라고 들어오면 이 메서드를 호출 (스프링에서 해줌)
    @GetMapping("hello")
    public String Hello(Model model) {
        model.addAttribute("data", "hello!!");

        return "hello";
    }
}
