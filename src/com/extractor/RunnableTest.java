package com.extractor;

import java.io.PrintStream;
import java.sql.SQLException;
import java.util.*;

public class RunnableTest implements Runnable {
    private Integer parameters;
    public RunnableTest(Integer parameters) {
        this.parameters = parameters;
    }
    public static void testThreads(CiExtractor inclTest, List<Integer> dscIdList, ExtractPromotionSQL extractPromotionSQL  ){
        Long timeTaken = Calendar.getInstance().getTimeInMillis();
        System.out.println(String.format("starting expensive task thread %s", Thread.currentThread().getName()));
        PrintStream p = Objects.requireNonNull(System.out);
        List<Integer> foundResources = inclTest.getIdsFromCI(dscIdList);
        Iterator<Integer> i = foundResources.iterator();
        dscIdList.removeAll(foundResources);
        System.out.println("Final size:" + dscIdList.size());
        System.out.println("*********************");
        dscIdList.forEach(o -> p.println(o));
        System.out.println("*********************");
        List<String> finalUpdateQueryList = new ArrayList<>();
        if (!dscIdList.isEmpty() && extractPromotionSQL.getPromotionIDFromTxt() != null) {
            DevDBExtractor devDBExtractor = new DevDBExtractor();
            // T_resources = 103, T_resource_code=106
            for (Integer resourceCode : dscIdList) {
                try {
                    finalUpdateQueryList.add(devDBExtractor.extractTResFromSetup(106, resourceCode, extractPromotionSQL.getPromotionIDFromTxt()));
                    finalUpdateQueryList.add(devDBExtractor.extractTResFromSetup(103, resourceCode, extractPromotionSQL.getPromotionIDFromTxt()));
                }
                catch (SQLException e){
                    System.out.println(e);
                }
                catch (ClassNotFoundException e){
                    System.out.println(e);
                }
            }
            System.out.println("\n\n\nRUN QUERIES BELOW STARTS:**********");
            finalUpdateQueryList.forEach(o -> p.println(o));
            System.out.println("RUN QUERIES BELOW ENDS:**********");
            System.out.println("Time taken by thread:" + (Calendar.getInstance().getTimeInMillis() - timeTaken));

        }
    }

    public void run() {
        System.out.println("run() @" + Thread.currentThread());
        long start = System.currentTimeMillis();
        ExtractPromotionSQL extractPromotionSQL = new ExtractPromotionSQL();
        CiExtractor inclTest = new CiExtractor();
            try {
                List<Integer> testInt = new ArrayList<>();
                testInt.add(parameters);
                System.out.println(Thread.currentThread().getName() );
                testThreads(inclTest,  testInt, extractPromotionSQL  );

            } catch (Exception e) {
                System.out.println(e);
            }
        System.out.println("TIME for RUN@"+(System.currentTimeMillis()-start));
    }
}
