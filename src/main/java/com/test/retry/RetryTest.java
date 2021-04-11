package com.test.retry;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.AttemptTimeLimiters;
import com.github.rholder.retry.BlockStrategies;
import com.github.rholder.retry.RetryListener;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author langyonghe
 * @date 2021/4/10 10:53
 */
@Slf4j
public class RetryTest {


    private static  boolean method() {
//        System.out.println(1/0);
        return false;
    }

    public static void main(String[] args) {
        Callable<Boolean> task = () -> method();




        RetryHelper<Boolean> retryHelper = new RetryHelper<>();
        try {
            Boolean call = retryHelper.call(true, task);
            if(!call) {
                log.info("成功后 处理逻辑+++++++++++++++");
            }
        } catch (Exception e) {
            log.error("occur error",e);
        }
    }
}
