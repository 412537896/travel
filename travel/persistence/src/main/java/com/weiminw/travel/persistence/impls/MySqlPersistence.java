package com.weiminw.travel.persistence.impls;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.weiminw.travel.persistence.IPersistence;

public final class MySqlPersistence<T> implements IPersistence<T> {
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("travel");
	
	private MySqlPersistence(){
	}
	public static final <T> MySqlPersistence<T> newInstance(){
		return new MySqlPersistence<T>();
	}
	@Override
	public T getPersistenceObject(Class<? extends T> typeCLass,long id) {
		EntityManager manager = factory.createEntityManager();
		return manager.find(typeCLass, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getPersistenceObjects(String query) {
		EntityManager manager = factory.createEntityManager();
		Query namedQuery= manager.createNamedQuery(query);
		namedQuery.setMaxResults(10);
		return namedQuery.getResultList();
	}
	
	public List<T> getPersistenceObjects(String query,Map<String,?> parameters) {
		EntityManager manager = factory.createEntityManager();
		Query namedQuery= manager.createNamedQuery(query);
		namedQuery.setMaxResults(10);
		for(Map.Entry<String,?> entry:parameters.entrySet()){
			namedQuery.setParameter(entry.getKey(), entry.getValue());
		}
		return namedQuery.getResultList();
	}
	
	
	
}
