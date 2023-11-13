package org.example.dto;

import java.util.List;

public interface GeneralDao <T>{
    List<T> getAll();
    T get(Long id);
    T save(T object);
    void delete(Long id);

}
