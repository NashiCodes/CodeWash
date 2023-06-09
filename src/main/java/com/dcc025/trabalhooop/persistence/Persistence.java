package com.dcc025.trabalhooop.persistence;

import java.util.List;

public interface Persistence<T> {
    String DIRECTORY = "data";

    void save(List<T> item);

    List<T> findAll();
}
