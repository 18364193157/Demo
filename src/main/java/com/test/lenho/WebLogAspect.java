//package com.uooguo.newretail.storecenter.goods.service.annotation;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//
///**
// * 描述:
// *
// * @author langyonghe
// * @create 2019-06-13 11:06
// */
//@Slf4j
//@Aspect
//@Component
//public class WebLogAspect {
//
//
//    @Pointcut("execution(* com.uooguo.newretail.storecenter.goods.service.controller.*.*(..))\"")
//    public void webLog(){}
//    ThreadLocal<Long> startTime = new ThreadLocal<>();
//
//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint)throws Throwable{
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = requestAttributes.getRequest();
//        startTime.set(System.currentTimeMillis());
//        // 记录下请求内容
//        log.info("URL : " + request.getRequestURL().toString());
//        log.info("HTTP_METHOD : " + request.getMethod());
//        log.info("IP : " + request.getRemoteAddr());
//        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//    }
//
//    @AfterReturning(returning = "ret",pointcut = "webLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
//        log.info("RESPONSE : " + ret);
//        log.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
//    }
//}
