package com.bondarenko.utils;

import java.util.Collection;

public class PrintUtils {

    public static void printDelimiter(String operation){
        String prepared = StringUtils.isNullOrEmpty(operation) ? "" : "<" + operation + ">";
        System.out.println("\n<---------------------" + prepared + "--------------------->\n");
    }

    public static void printCollection(Collection<?> collection){
        if (collection != null)
            collection.forEach(System.out::println);
    }
}
