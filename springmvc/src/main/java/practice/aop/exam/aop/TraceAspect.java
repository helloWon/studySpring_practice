package practice.aop.exam.aop;

import lombok.extern.slf4j.Slf4j;
import practice.aop.exam.annotation.Trace;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class TraceAspect {

    // @Before("@annotation(practice.aop.exam.annotation.Trace)")
    @Before("@annotation(trace)")
    public void doTrace(JoinPoint joinPoint, Trace trace) {
        Object[] args = joinPoint.getArgs();
        log.info("[trace] {} args={}", joinPoint.getSignature(), args);
    }
}