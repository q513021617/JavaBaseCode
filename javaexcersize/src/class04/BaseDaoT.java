package class04;

import java.sql.SQLException;

public interface BaseDaoT<T> {
	
	void add(T t);

	boolean delete(T t) throws SQLException;
	boolean update(T t);
	T select(T t);
}
