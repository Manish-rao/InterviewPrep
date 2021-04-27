package com.extractor;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ExtractPromotionSQL {
    public List testMethod(){
        List<Integer> resourceCodeList = new ArrayList<>();
        try {
            File dir = new File("C:\\Users\\manish.madhusoodhan\\Documents\\PromotionTest.txt");
            teststring(dir, resourceCodeList);
            Set<Integer> listWithoutDuplicates = new LinkedHashSet<Integer>(resourceCodeList);
            resourceCodeList.clear();

            resourceCodeList.addAll(listWithoutDuplicates);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resourceCodeList;
    }

    public String getPromotionIDFromTxt(){
        try {
            File dir = new File("C:\\Users\\manish.madhusoodhan\\Documents\\PromotionTest.txt");
            return getPromotionScanner(dir);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void teststring(File file, List resourceCodeList) {
        Scanner scanner = null;
        List<String> valuesInQuotes =new ArrayList<>();
        if(file.exists()) {
            try {
                scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    String nextToken = scanner.next();
                    if (nextToken.contains("DSC_ID=")) {
                        valuesInQuotes.addAll(Arrays.asList(splitToken("DSC_ID=",nextToken)));
                    }
                    else if(nextToken.contains("DESCRIPTION_ID=")){
                        valuesInQuotes.addAll(Arrays.asList(splitToken("DESCRIPTION_ID=",nextToken)));
                    }
                }

                for (String a:valuesInQuotes){
                    if(a!=null && !"null".equalsIgnoreCase(a)){
                        resourceCodeList.add(Integer.parseInt(a));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (scanner != null) scanner.close();
            }
        }
    }

    public String[] splitToken(String dscId, String nextToken){
       return StringUtils.substringsBetween(nextToken, dscId, ",");
    }

    private String getPromotionScanner(File file) {
        Scanner scanner = null;
        if(file.exists()) {
            try {
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String nextToken = scanner.nextLine();
                    if (nextToken.contains("Promotion project id") ) {
                        return nextToken.split("=")[1];
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (scanner != null) scanner.close();
            }
        }
        return null;
    }
}
