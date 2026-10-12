package dao;

import java.util.List;

public interface ICrud<T> {
    boolean crear(T objeto);
    List<T> leerTodos();
}
