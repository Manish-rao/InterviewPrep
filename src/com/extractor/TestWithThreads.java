package com.extractor;

import java.io.PrintStream;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TestWithThreads {
    static ExecutorService executorService = null;

    public static void main(String[] args)  {
        long start = System.currentTimeMillis();
        ExtractPromotionSQL extractPromotionSQL = new ExtractPromotionSQL();
        List<Integer> dscIdList = extractPromotionSQL.testMethod();
        CiExtractor inclTest = new CiExtractor();
        //TODO Remove this line later, added to test since its already promoted to CI
        dscIdList.add(20003761);
        System.out.println("Initial size:"+dscIdList.size());
        final ArrayList<RunnableTest> runnables = new ArrayList<>();
        boolean isChildThreadsDone = false;
        executorService = Executors.newFixedThreadPool(30);
        try {
            for(Integer  str: dscIdList) {
                final RunnableTest lockFileRunnable = new RunnableTest(str);
                runnables.add(lockFileRunnable);
                final Future<?> future = executorService.submit(lockFileRunnable);
                //Runnable runTest = new Runn();
                //executorService.execute((testThreads(inclTest, dscIdList, extractPromotionSQL)));
            }
        }

        finally{
            executorService.shutdown();
            try {
                Thread.currentThread().join();
                executorService.awaitTermination(10, TimeUnit.SECONDS);
            }catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("TIME for TOTAL@"+(System.currentTimeMillis()-start));

    }


}
