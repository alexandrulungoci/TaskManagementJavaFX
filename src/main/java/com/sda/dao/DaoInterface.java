package com.sda.dao;


import com.sda.model.Model;

public interface DaoInterface<T extends Model> {

    void add(T objectToBeAdded);

    void update(T objectToBeUpdated);

    void remove(T objectToBeRemoved);




}
