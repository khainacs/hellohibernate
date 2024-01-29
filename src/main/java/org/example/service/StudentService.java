package org.example.service;

public interface StudentService<T> extends BaseService<T>{
    public String getNumberOfParents(T entity);
}
