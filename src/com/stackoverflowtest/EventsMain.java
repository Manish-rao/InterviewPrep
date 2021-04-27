package com.stackoverflowtest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EventsMain {
    public static void main(String[] args) {
        List<EventCustomDTO> list1 = new ArrayList<>();
        //list1.add();
        list1.add(new EventCustomDTO(false,false,"cancel"));
        list1.add(new EventCustomDTO(false,false,"unconfirmed"));
        list1.add(new EventCustomDTO(false,true,"cancel"));
        list1.add(new EventCustomDTO(true,false,"unconfirmed"));
        list1.add(new EventCustomDTO(true,false,"cancel"));
        list1.add(new EventCustomDTO(true,true,"unconfirmed"));
        List<EventCustomDTO> list2 =  new ArrayList<>();
        list2.addAll(list1);
        list1.sort(Comparator.comparing(EventCustomDTO::getPassport).reversed()
        .thenComparing(EventCustomDTO::getFeatured)
        .thenComparing(EventCustomDTO::getStatus));
        System.out.println(list1);
        list2.sort(Comparator.comparing(o -> {
            if (Boolean.TRUE.equals(o.getPassport())) {
                return 1;
            } else if (Boolean.FALSE.equals(o.getFeatured())) {
                return 2;
            } else if ("cancel".equals(o.getStatus())) {
                return 3;
            } else if ("unconfirmed".equals(o.getStatus())) {
                return 4;
            } else {
                return 5;
            }
        }));
        System.out.println(list2);
    }

}
