package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor // 롬복에서 생성자 자동 주입
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo") // log-demo url로 요청 받음
    @ResponseBody // 뷰가 아닌 응답
    public String logDemo(HttpServletRequest request) { // 자바에서 제공하는 표준 서블릿 규약에 의한 http 요청을 받는다
        String requestURL = request.getRequestURL().toString(); // 고객이 어떤 url 로 요청했는지
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
