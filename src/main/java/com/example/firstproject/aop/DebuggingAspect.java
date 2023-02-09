package com.example.firstproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // 부가 기능을 주입하는 클래스다.
@Component // Ioc컨테이너가 해당 객체를 생성 및 관리
@Slf4j
public class DebuggingAspect {

    //대상 메소드 선택 : api의 패키지의 모든 메소드
    @Pointcut("execution(* com.example.firstproject.api.*.*(..))")
    private void cut(){}

    //실행 시점 설정 cut() 대상이 수행되기 이전에 수행하는 것.
    @Before("cut()")
    public void loggingArgs(JoinPoint joinPoint){ //  cut()의 대상 메소드 (메소드를 둘러싼 결합 지점)
        // 입력 값 가져오기
        Object[] args = joinPoint.getArgs();

        //클래스 명
        String className = joinPoint.getTarget()
                .getClass()
                .getSimpleName();

        // 메소드 명
        String methodName = joinPoint.getSignature().getName();

        //입력값 로깅하기
        //CommentService#create의 입력값 => 5
        //CommentService#create의 입력값 => CommentDto(id=null,...)
        for(Object obj : args){
            //foreach문
            log.info("{}#{}의 입력값 => {}",className, methodName, obj);
        }
    }

    // 실행 시점 설정 : cut()에 지정된 대상 호출 성공 후
    @AfterReturning(value= "cut()", returning="returnObj")
    public void loggingReturnValue(JoinPoint joinPoint, Object returnObj){ // cut()의 대상 메소드, 리턴값


        //반환값, 로깅

        //CommentService#create 로깅값 => CommentDto(id=10,...)

        //클래스 명
        String className = joinPoint.getTarget()
                .getClass()
                .getSimpleName();

        // 메소드 명
        String methodName = joinPoint.getSignature().getName();

        log.info("{}#{}의 반환값 => {}",className, methodName, returnObj);
    }
}
