package ru.mustikaev;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Flow<E> implements Iterable<E> {
    private Iterable<E> source;

    public Flow(Iterable<E> source) {
        this.source = source;
    }


    public Flow<E> filter(Predicate<E> predicate) {
        
        return new Flow<>(new Iterable<E>() {
            @Override 
            public Iterator<E> iterator() {
                return new FilterIterator<>(Flow.this.iterator(), predicate);
            }
        });
    }

    public <R> Flow<R> map(Function<E, R> fun) {
        return null;
    }

    public E reduce(E initValue, BiFunction<E, E, E> fun) {
        E res = initValue;
        for (E elem : this) {
            res = fun.apply(res, elem);
        }
        return res;
    }

    @Override
    public Iterator<E> iterator() {
        return source.iterator();
    }


    private class FilterIterator<T> implements Iterator<T> {
        private Iterator<T> source;
        private Predicate<T> predicate;
        private T nextElem;

        public FilterIterator(Iterator<T> source, Predicate<T> predicate) {
            this.source = source;
            this.predicate = predicate;
        }

        @Override
        public boolean hasNext() {
            while (source.hasNext()) {
                T sourceElem = source.next();
                if (predicate.test(sourceElem)) {
                    nextElem = sourceElem;
                    return true;
                }
            }
            return false;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return nextElem;
        }
    }
}
