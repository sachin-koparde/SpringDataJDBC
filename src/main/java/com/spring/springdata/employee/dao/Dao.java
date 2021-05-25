package com.spring.springdata.employee.dao;

import java.util.List;

public interface Dao<T> {

    void save(T t);

    T load(int id);

    void updateSalary(int id, float newSalary);

    void delete(int id);

    List<T> loadAll();

}
