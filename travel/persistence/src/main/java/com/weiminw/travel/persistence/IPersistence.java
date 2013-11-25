package com.weiminw.travel.persistence;

import java.util.List;

public interface IPersistence<T> {
	public T getPersistenceObject(Class<T> typeCLass,long id);
	public List<T> getPersistenceObjects(String query);
}
