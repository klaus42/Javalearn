package com.javalearn.study.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListStringCollectorExample {
    public static void main(String[] args) {
        String[] arr1 = {"Саша","Маша","Коля","Даша"};
        String[] arr2 = {"Петя","Вася","Маша","Веня"};
        String[] arr3 = {"Вова","Дима","Кирилл","Семен"};
        String[] arr4 = {"Инокентий","Илларион","Петя"};



        List<String> list1 = Arrays.asList(arr1);
        List<String> list2 =Arrays.asList(arr2);
        List<String> list3 = Arrays.asList(arr3);
        List<String> list4 = Arrays.asList(arr4);

       // List<String> newStream = Stream.of(list1,list2,list3,list4);
       // Set<String> newSet = newStream.collect(Collectors.toSet());

        Map<String,Double> map = new HashMap<>();
        map.put("Вася",83D);
        map.put("Петя",76D);
        map.put("Вова",98D);
        map.put("Катя",53D);

        //System.out.println(Stream.of(map.values()).mapToDouble((a)->a.).average());





    }
}
