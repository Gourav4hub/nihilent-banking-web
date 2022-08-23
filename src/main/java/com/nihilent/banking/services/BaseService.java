package com.nihilent.banking.services;

import java.util.List;

public interface BaseService<T>
{
	T save(T ob);
	T update(T ob);
	List<T> list();
	T get(int id);
}
