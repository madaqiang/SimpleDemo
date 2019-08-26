package com.mdq.simpletest.demo.utils;

import com.mdq.simpletest.demo.model.User;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class TestJava8 {

    public static void  main( String args[]){
        String []  charest = {"a","b","ccc","ddd"};
        List<String> testList = CollectionUtils.arrayToList(charest);
        //
        List<Integer> intList= CollectionUtils.arrayToList(new int[]{1,2,3,4});
        //
        testList.stream().forEach(item -> System.out.println(item));
        //
        testList.stream().forEach(item ->{
            if("b".equals(item)){
                System.out.println(item);
            }
        });
        //
        System.out.println(testList.stream().collect(Collectors.toList()));
        //
        System.out.println(testList.stream().filter(e -> e.startsWith("a")).collect(Collectors.toList()));
        //
        testList.forEach(System.out::println);
        //
        testList.stream().filter(s -> s.contains("b")).forEach(System.out::println);
        //
        System.out.println(intList.stream().max(Comparator.comparing(Integer::shortValue)));

        Map<String ,String> testHash = new HashMap<>();
        testHash.put("a","1");
        testHash.put("b","2");
        testHash.put("c","3");
        testHash.put("d","4");
        testHash.forEach((k,v) -> System.out.println("key:"+k+",value:"+v));
        testHash.forEach((k,v) -> {
            if("a".equals(k)){
                System.out.println(v);
            }
        });

        Optional<Integer> maxInteger = intList.stream().
                collect(Collectors.maxBy(Comparator.comparing(Integer::intValue)));
        maxInteger.ifPresent(System.out::println);

        Optional<String> maxDish = testList.stream().
                collect(Collectors.maxBy(Comparator.comparing(String::length)));
        maxDish.ifPresent(System.out::println);

        Optional<String> minDish = testList.stream().
                collect(Collectors.minBy(Comparator.comparing(String::length)));
        minDish.ifPresent(System.out::println);
    }
}
