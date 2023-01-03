package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // 이게 있어야 AOP 로 사용 가능
@Component
public class TimeTraceAop {

    // 타겟 정하기, 문법이 있지만 쓰던거만 쓰는편, 다음처럼 적으면 다 적용한다는 뜻
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("start = " + joinPoint.toString());

        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("end = " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
