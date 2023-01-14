package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    // 로그 찍기용, slf4j 에서 임포트한다. 롬복 어노테이션으로 아래코드 대체 가능
//    Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    public String home() {
        log.info("home controller");
        return "home"; // home.html 파일을 찾아간다.
    }
}
