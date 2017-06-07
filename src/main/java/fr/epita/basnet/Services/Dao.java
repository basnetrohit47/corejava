package fr.epita.basnet.Services;

import java.util.List;

public interface Dao <T> {

public void write(T instance);
public void update(T instance);
public void delete(T instance);
public List<T>listall(T instance);
	
}
