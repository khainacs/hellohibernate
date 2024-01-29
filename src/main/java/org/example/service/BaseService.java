package org.example.service;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {
    public boolean save(T entity);

    public T getById(Long id);

    public List<T> getAll(String sql);

    public boolean delete(T entity);

    public List<T> query(Class object, String sql, Map<String, Object> map);

}
