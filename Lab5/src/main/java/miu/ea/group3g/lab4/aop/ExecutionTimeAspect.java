package miu.ea.group3g.lab4.aop;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import miu.ea.group3g.lab4.entity.ActivityLog;
import miu.ea.group3g.lab4.repository.ActivityLogRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ActivityLogRepository activityLogRepository;

    @SneakyThrows
    @Around("@annotation(ExecutionTime)")
    public Object printExcutionTime(ProceedingJoinPoint proceedingJoinPoint) {
        long start = System.currentTimeMillis() ;
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("start " + start + " ms");
        System.out.println("end " + end + " ms");
        System.out.println("duration " + (end - start) + " ms");
        System.out.println("operation " + proceedingJoinPoint.getSignature().getName());
        //
        ActivityLog log = new ActivityLog();
        log.setDate(LocalDateTime.now());
        log.setOperation(proceedingJoinPoint.getSignature().getName());
        log.setDuration((end - start));
        activityLogRepository.save(log);
        //
        return result;
    }
}
