// package com.library.aspect;

// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;

// @Aspect
// public class LoggingAspect {

//     @Around("execution(* com.library.service.*.*(..))")
//     public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//         long start = System.currentTimeMillis();

//         Object result = joinPoint.proceed(); // run the target method

//         long end = System.currentTimeMillis();
//         System.out.println("[LOG] Execution time of " + joinPoint.getSignature() + ": " + (end - start) + "ms");

//         return result;
//     }
// }

package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[AOP BEFORE] Method: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.library.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[AOP AFTER] Method: " + joinPoint.getSignature().getName());
    }
}
