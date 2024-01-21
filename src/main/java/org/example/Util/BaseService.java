package org.example.Util;

import java.lang.reflect.Type;
import java.util.List;

interface BaseService<T> {
    public boolean save(T entity);

    public T getById(Long id);

    public List<T> getAll();

    public boolean delete(T entity);

}
