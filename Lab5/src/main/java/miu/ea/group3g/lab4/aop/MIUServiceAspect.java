package miu.ea.group3g.lab4.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class MIUServiceAspect {
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void hasPostMappingAnnotation() {}

    @Pointcut("execution(* miu.ea.group3g.lab4..*(..))")
    public void postMethodsInControllers() {}

    @SneakyThrows
    @Before("hasPostMappingAnnotation() && postMethodsInControllers()")
    public void checkHeader() {
        System.out.println("Checking request for AOP-IS-AWESOME header...");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        String headerValue = request.getHeader("AOP-IS-AWESOME");
        if (headerValue == null || !headerValue.equals("true")) {
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header is missing or invalid.");
        }
    }
}
