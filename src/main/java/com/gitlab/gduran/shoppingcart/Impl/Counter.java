package com.gitlab.gduran.shoppingcart.Impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Counter<T> {
    private final Map<T, Long> bag = new HashMap<>();

    public Set<T> getItems() {
        return bag.keySet();
    }

    public void setItems(Collection<T> items){
        bag.clear();
        bag.putAll(items.stream().collect(groupingBy(identity(), counting())));
    }

    public long getCount(T item) {
        return bag.getOrDefault(item, 0L);
    }

    public void setCount(T item, long count){
        if (count < 1L) {
            throw new IllegalArgumentException("Count must be greater or equals to 1");
        }
        bag.put(item,count);
    }

    public long removeItem(T item){
        if(bag.containsKey(item)){
            return bag.remove(item);
        }
        return 0;
    }

    public long increaseCount(T item){
        return increaseCount(item,1L);
    }

    public long increaseCount(T item, long count) {
        if (count < 1L) {
            throw new IllegalArgumentException("Count must be greater or equals to 1");
        }
        if(bag.containsKey(item)){
            long newCount = bag.get(item) + count;
            bag.put(item,newCount);
            return newCount;
        }
        bag.put(item,count);
        return count;
    }

    public long decreaseCount(T item){
        return decreaseCount(item,1L);
    }

    public long decreaseCount(T item, long count) {
        if (count < 1L){
            throw  new IllegalArgumentException("Count most be greater or equals to 1");
        }
        if (!bag.containsKey(item)) {
            throw new IllegalArgumentException(String.format("There's not %s to be decreased", item));
        }
        long newCount = bag.get(item) - count;
        if (newCount < 0) {
            throw new IllegalArgumentException(String.format("There's not enough of %s", item));
        } else if (newCount == 0) {
            removeItem(item);
        } else {
            bag.put(item, newCount);
        }
        return newCount;
    }
}
