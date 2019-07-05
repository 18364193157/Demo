//package com.test.lenho;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//import springfox.documentation.spring.web.HandlerMethodReturnTypes;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Enumeration;
//
///**
// * 描述:
// *
// * @author langyonghe
// * @create 2019-06-13 14:31
// */
//@Slf4j
//@Configuration
//public class LogInfoInterceptor extends HandlerInterceptorAdapter {
//
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//
//
//
//        if (handler instanceof HandlerMethod) {
////            LogInfo logInfo = ((HandlerMethod) handler).getMethodAnnotation(LogInfo.class);
//            LogInfo logInfo = ((HandlerMethod) handler).getMethod().getDeclaringClass().getAnnotation(LogInfo.class);
//            if(null == logInfo || !logInfo.enable()){
//                return true;
//            }
//            Enumeration<String> parameterNames = request.getParameterNames();
//            StringBuffer stringBuffer = new StringBuffer();
//            while (parameterNames.hasMoreElements()){
//                stringBuffer.append(parameterNames.nextElement()+",");
//            }
//            log.info("URL : " + request.getRequestURL().toString());
//            log.info("HTTP_METHOD : " + request.getMethod());
//            log.info("IP : " + request.getRemoteAddr());
//            log.info("ARGS :" + stringBuffer.toString());
//        }
//        return true;
//    }
//}
