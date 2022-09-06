package com.example.prueba_paolac_williamt.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService <T, ID extends Serializable>  {
    public T save(T entity);
    public T findByReference (ID reference);
    public List<T> findByAll();
    public void delete(ID id);
}
