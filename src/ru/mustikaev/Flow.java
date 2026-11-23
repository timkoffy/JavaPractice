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
        return (Flow<R>) new Flow<>(new Iterable<R>() {
            @Override 
            public Iterator<R> iterator() {
                return new MapIterator<>(Flow.this.iterator(), fun);
            }
        });
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
        private boolean buffered;

        public FilterIterator(Iterator<T> source, Predicate<T> predicate) {
            this.source = source;
            this.predicate = predicate;
        }

        @Override
        public boolean hasNext() {
            if (buffered) return true;
            while (source.hasNext()) {
                T sourceElem = source.next();
                if (predicate.test(sourceElem)) {
                    nextElem = sourceElem;
                    buffered = true;
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
            buffered = false;
            return nextElem;
        }
    }

    private class MapIterator<T, R> implements Iterator<R> {
        private Iterator<T> source;
        private Function<T, R> fun;

        public MapIterator(Iterator<T> source, Function<T, R> fun) {
            this.source = source;
            this.fun = fun;
        }

        @Override
        public boolean hasNext() {
            return source.hasNext();
        }

        @Override
        public R next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (R) fun.apply(source.next());
        }
    }
}
