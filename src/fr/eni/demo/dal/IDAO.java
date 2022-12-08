package fr.eni.demo.dal;

import java.util.List;

public interface IDAO<T> {
	
	public void selectBy(T object);
	public List<T> selectAll();
	public boolean insert(T object);

}
