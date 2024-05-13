package database;

import java.util.ArrayList;

public interface DAOInterface<T> {

    public ArrayList<T> chonTatCa();

    public T chonTheoMa(T t);

    public int chenTT(T t);

    public int insertAll(ArrayList<T> arr);

    public int xoaTT(T t);

    public int deleteAll(ArrayList<T> arr);

    public int capNhatTT(T t);

}
