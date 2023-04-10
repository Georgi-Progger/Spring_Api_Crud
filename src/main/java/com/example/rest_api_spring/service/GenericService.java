package com.example.rest_api_spring.service;

import java.util.List;

public interface GenericService<T, ID> {
    List<T> loadAll();
    T create (T t);
    T getById (ID id);
    T update (T t);
    void delete (ID id);
}
