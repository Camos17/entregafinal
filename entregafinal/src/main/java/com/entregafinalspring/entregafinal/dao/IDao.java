package com.entregafinalspring.entregafinal.dao;

import java.util.List;

public interface IDao<T> {

    public T guardar(T t);
    public T buscar(int id);
    public List<T> buscarTodos();
    public boolean actualizar(T t);
    public boolean borrar(int id);

}
