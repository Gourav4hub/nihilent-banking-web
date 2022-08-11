package com.nihilent.banking.services;

import java.util.List;

public interface BaseService<T>
{
	boolean save(T ob);
	boolean update(T ob);
	List<T> list();
	T get(int id);
}
