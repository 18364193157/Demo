//package com.test.lenho;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.lang.annotation.*;
//import java.util.Enumeration;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Documented
//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
//public @interface LogInfo {
//
//    /**
//     * @return 是否启用
//     */
//    boolean enable() default true;
//
//    @Documented
//    @Target(ElementType.TYPE)
//    @Retention(RetentionPolicy.RUNTIME)
//    @interface LogInfo {
//
//        /**
//         * @return 是否启用
//         */
//        boolean enable() default true;
//    }
//
//    /**
//     * 描述:
//     *
//     * @author langyonghe
//     * @create 2019-06-13 14:31
//     */
//    @Slf4j
//    @Configuration
//    class LogInfoInterceptor extends HandlerInterceptorAdapter {
//
//
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//            if (handler instanceof HandlerMethod) {
//    //            LogInfo logInfo = ((HandlerMethod) handler).getMethodAnnotation(LogInfo.class);
//                LogInfo logInfo = ((HandlerMethod) handler).getMethod().getDeclaringClass().getAnnotation(LogInfo.class);
//                if(null == logInfo || !logInfo.enable()){
//                    return true;
//                }
//                Enumeration<String> parameterNames = request.getParameterNames();
//
//                Map<String,List<String>> map = new ConcurrentHashMap<>();
//                while (parameterNames.hasMoreElements()){
//                    LogInfoInterceptor.log.info(parameterNames.nextElement());
//    //                String[] parameterValues = request.getParameterValues(parameterNames.nextElement());
//    //                map.put(parameterNames.nextElement(),Lists.newArrayList(parameterValues));
//                }
//                LogInfoInterceptor.log.info("URL : " + request.getRequestURL().toString());
//                LogInfoInterceptor.log.info("HTTP_METHOD : " + request.getMethod());
//                LogInfoInterceptor.log.info("IP : " + request.getRemoteAddr());
//                LogInfoInterceptor.log.info("ARGS, {}" ,map);
//            }
//            return true;
//        }
//    }
//}
