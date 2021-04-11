package com.test.currentandsafe.threadpool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author langyonghe
 * @date 2021/3/8 16:13
 */
@Data
@AllArgsConstructor
@Slf4j
public class ForkJoinExample extends RecursiveTask<Integer> {
    private static final int threshold = 2;
    private int start;
    private int end;


    @Override
    protected Integer compute() {
        int sum = 0;
        boolean compare = end - start <= threshold;
        if(compare){
            for(int i = start; i <= end; i++) {
                sum += i;
            }
        }else {
            //如果任务大于阈值，就分裂成两个子任务
            int middle = (start + end) / 2;
            ForkJoinExample left = new ForkJoinExample(start,middle);
            ForkJoinExample right = new ForkJoinExample(middle + 1,end);

            left.fork();
            right.fork();

            sum = left.join() + right.join();
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinExample forkJoinExample = new ForkJoinExample(1,100);
        Future<Integer> result = forkJoinPool.submit(forkJoinExample);
        log.info("result: {}", result.get());

    }
}
