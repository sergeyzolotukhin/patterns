package ua.in.sz.spring.common;

import java.util.stream.Stream;

public interface FilterDao {
    <E,D> Stream<D> search(Filter<E, D> filter);

    <E,D> Long count(Filter<E, D> filter);
}
