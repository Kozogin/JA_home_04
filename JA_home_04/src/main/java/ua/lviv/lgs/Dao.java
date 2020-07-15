package ua.lviv.lgs;

import java.sql.SQLException;

public interface Dao<T, R, M> {
	
	public void insert(T t) throws SQLException;
	
	public T read(R r) throws SQLException;
	
	public void update(T t) throws SQLException;
	
	public void delete(R r) throws SQLException;
	
	public M readAll() throws SQLException;

}
