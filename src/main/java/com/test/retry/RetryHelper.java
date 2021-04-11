package com.test.retry;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.AttemptTimeLimiters;
import com.github.rholder.retry.BlockStrategies;
import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.RetryListener;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 重试辅助类
 * @author langyonghe
 * @date 2021/4/10 13:25
 */

@Slf4j
@Service
public class RetryHelper<E> {


    public E call(E e, Callable<E> callable) throws ExecutionException, RetryException {
        Retryer<E> retryer = RetryerBuilder.<E>newBuilder()
                .withRetryListener(new RetryListener() {
                    @Override
                    public <V> void onRetry(Attempt<V> attempt) {
                        log.info("listener receive attemptNumber: {}, attemptResult: {}, attemptException: {}",
                                attempt.getAttemptNumber(), attempt.hasResult() ? attempt.getResult():null, attempt.hasException() ? attempt.getExceptionCause():null);
                    }
                })
                .withAttemptTimeLimiter(AttemptTimeLimiters.fixedTimeLimit(1, TimeUnit.SECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .withWaitStrategy(WaitStrategies.fixedWait(2, TimeUnit.SECONDS))
                .withBlockStrategy(BlockStrategies.threadSleepStrategy())
                .retryIfRuntimeException()
                .retryIfResult(Predicates.equalTo(e))
                .build();
        return retryer.call(callable);
    }
}
