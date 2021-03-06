package ua.in.sz.spring.common;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public interface Filter<E, D> {

    CriteriaQuery<D> searchQuery(CriteriaBuilder session);

    CriteriaQuery<Long> countQuery(CriteriaBuilder session);

}
