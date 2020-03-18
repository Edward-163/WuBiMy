package com.hyj;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        /**
         * public void execute(ForkJoinTask<?> task)它自己就没结果,
         * ForkJoinTask的2个实现类,
         * RecursiveAction  无返回值
         * RecursiveTask    有返回值,
         */
//        forkJoinPool.execute(new MyRecursiveTask(1,(long)(Math.pow(10,9)+1)))
        ForkJoinTask<Long> forkJoinTask = forkJoinPool.submit(new MyRecursiveTask(1,  10000));
//        ForkJoinTask<Long> forkJoinTask = forkJoinPool.submit(new MyRecursiveTask(1, (long) (Math.pow(10, 9) + 1)));
        System.out.println(forkJoinTask.get());

        long l = System.currentTimeMillis();
        System.out.println(LongStream.rangeClosed(1, 10000).parallel().reduce(0, Long::sum));
        System.out.println(System.currentTimeMillis()-l);

    }


}


class MyRecursiveTask extends RecursiveTask<Long> {
    private long start;
    private long end;

    public MyRecursiveTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long l = System.currentTimeMillis();
        if (end - start < 10000) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            Long middle = (start + end) / 2;
            long join = new MyRecursiveTask(start, middle).fork().join();
            long join1 = new MyRecursiveTask(middle, end).fork().join();
            System.out.println(System.currentTimeMillis()-l);
            return join + join1;
        }
    }
}
