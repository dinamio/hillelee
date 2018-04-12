package com.bondarenko.tasks;

import com.bondarenko.utils.PrintUtils;
import com.bondarenko.utils.SortUtils;

import java.util.List;
import java.util.function.Consumer;

public class SortTask<T extends List<? extends Number>> {

    private T unsortedList;
    private String name;
    private Consumer<T> consumer;

    public SortTask(T unsortedList, String name, Consumer<T> consumer) {
        this.unsortedList = unsortedList;
        this.name = name;
        this.consumer = consumer;
    }

    public void doJob(){
        printHeader(name);
        consumer.accept(unsortedList);
        printCollection(unsortedList);
        shuffleList(unsortedList);
    }

    protected void printHeader(String taskId){
        PrintUtils.printDelimiter(taskId);
    }

    protected void printCollection(T unsortedList){
        PrintUtils.printCollection(unsortedList);
    }

    protected void shuffleList(T unsortedList){
        SortUtils.shuffle(unsortedList);
    }

    public T getUnsortedList() {
        return unsortedList;
    }

    public void setUnsortedList(T unsortedList) {
        this.unsortedList = unsortedList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Consumer<T> getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer<T> consumer) {
        this.consumer = consumer;
    }
}
