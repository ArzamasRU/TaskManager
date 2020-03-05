package ru.lavrov.tm.api;

import java.util.Collection;

public interface IService<T extends IEntity> {
    void persist(T entity);
    void merge(T entity);
    void remove(String entityId, String userId);
    void removeAll(String userId);
    Collection<T> findAll(String userId);
}