package com.PerformanceCheck;

import java.util.ArrayList;
import java.util.List;

public class AddRandomData {

    public List<RandomClass> getLotsOfData(){
        List<RandomClass> randomClassList = new ArrayList<>();
        for (int i=0;i<10000;i++)
        randomClassList.add(new RandomClass(i,i,i));
        return randomClassList;
    }
}
