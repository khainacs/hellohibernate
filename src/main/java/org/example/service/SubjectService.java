package org.example.service;

public interface SubjectService<T> extends BaseService<T>{
    public String getAuthor(T entity);
}
