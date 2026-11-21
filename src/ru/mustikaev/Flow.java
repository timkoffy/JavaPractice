package ru.mustikaev;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Flow<E> {
    private List<E> list;

    public Flow(List<E> list) {
        this.list = list;
    }

    public <R> Flow<R> map(Function<E, R> fun) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, (E) fun.apply(list.get(i)));
        }
        return (Flow<R>) this;
    }

    public Flow<E> filter(Predicate<E> predicate) {
        for (int i = 0; i < list.size(); i++) {
            if (!predicate.test(list.get(i))) list.remove(i--);
        }
        return this;
    }

    public E reduce(E initValue, BiFunction<E, E, E> fun) {
        E res = initValue;
        for (E elem : list) {
            res = fun.apply(res, elem);
        }
        return res;
    }
}
