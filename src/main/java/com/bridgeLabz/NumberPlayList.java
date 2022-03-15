package com.bridgeLabz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class NumberPlayList {
    public static void main(String[] args) {
        // Creating sample Collection
        List<Integer> myNumberList = new ArrayList<>();
        for (int i = 0; i < 5; i++) myNumberList.add(i);
        //Method 1 : Traversing Using Iterator
        Iterator<Integer> it = myNumberList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Mth1: Iterator Value::" + i);
        }

        //Method 2: Traversing with Explicit Consumer interface implimentation
        class MyConsumer implements Consumer<Integer> {
            public void accept(Integer t) {
                System.out.println("Math: Consumer impl value::" + t);
            }
        }
        MyConsumer action = new MyConsumer();
        myNumberList.forEach(action);

        //Method 3 : Traversing with Ananymous Consumer interface implementation
        myNumberList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("Mth3: forEach anonymous class Value::" + t);
            }
        });

        //Method 4: Explicit Lambda Function
        Consumer<Integer> myListAction = n -> {
            System.out.println("Mth4: forEach Lanbda impl Value::" + n);
        };
        myNumberList.forEach(myListAction);

        //Method 5: Implicit Lambda Function
        myNumberList.forEach(n -> {
            System.out.println("Mth4: forEach Lanbda impl Value::" + n);
        });

        //Method 6: Implicit Lambda Function to print double value
        Function<Integer,Double> toDoubleFunction = Integer::doubleValue;
        myNumberList.forEach(n -> {
            System.out.println("Mth5: forEach Lambda Double value"+
                    toDoubleFunction.apply(n));
        });
    }
}
