package com.extractor;


import java.io.PrintStream;
import java.sql.SQLException;
import java.util.*;

public class TestExtract {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ExtractPromotionSQL extractPromotionSQL = new ExtractPromotionSQL();
        Long timeTaken = Calendar.getInstance().getTimeInMillis();
        PrintStream p = Objects.requireNonNull(System.out);
        List<Integer> dscIdList = extractPromotionSQL.testMethod();
        long start = System.currentTimeMillis();
        CiExtractor inclTest = new CiExtractor();
        //TODO Remove this line later, added to test since its already promoted to CI
        dscIdList.add(20003761);
        System.out.println("Initial size:"+dscIdList.size());
        List<Integer> foundResources = inclTest.getIdsFromCI(dscIdList);
        Iterator<Integer> i = foundResources.iterator();
        dscIdList.removeAll(foundResources);
        System.out.println("Final size:"+dscIdList.size());
        System.out.println("*********************");
        dscIdList.forEach(o -> p.println(o));
        System.out.println("*********************");
        List<String> finalUpdateQueryList=new ArrayList<>();
        if(!dscIdList.isEmpty() && extractPromotionSQL.getPromotionIDFromTxt()!=null) {
            DevDBExtractor devDBExtractor = new DevDBExtractor();
            // T_resources = 103, T_resource_code=106
            for(Integer resourceCode:dscIdList) {
                finalUpdateQueryList.add(devDBExtractor.extractTResFromSetup(106, resourceCode, extractPromotionSQL.getPromotionIDFromTxt()));
                finalUpdateQueryList.add(devDBExtractor.extractTResFromSetup(103, resourceCode, extractPromotionSQL.getPromotionIDFromTxt()));
            }
            System.out.println("\n\n\nRUN QUERIES BELOW STARTS:**********");
            finalUpdateQueryList.forEach(o -> p.println(o));
            System.out.println("RUN QUERIES BELOW ENDS:**********");

        }
        System.out.println("TIME for TOTAL@"+(System.currentTimeMillis()-start));
    }

}
