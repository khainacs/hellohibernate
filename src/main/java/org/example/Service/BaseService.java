package org.example.Service;

import java.lang.reflect.Type;
import java.util.List;

interface BaseService<T> {
    public boolean save(T entity);

    public T getById(Long id);

    public List<T> getAll(String sql);

    public boolean delete(T entity);

}
