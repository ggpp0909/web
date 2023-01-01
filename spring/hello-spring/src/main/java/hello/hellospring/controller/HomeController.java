package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 빈 주소로 들어오면 호출됨.
    @GetMapping("/")
    public String Home() {
        return "Home"; // home.html
    }
}
