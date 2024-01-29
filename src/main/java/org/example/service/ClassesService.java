package org.example.service;

public interface ClassesService<T> extends BaseService<T>{
    public String getFloor(T entity);
}
