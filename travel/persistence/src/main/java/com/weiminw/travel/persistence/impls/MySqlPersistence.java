package com.weiminw.travel.persistence.impls;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.weiminw.travel.interfaces.IUser;
import com.weiminw.travel.persistence.IPersistence;

public final class MySqlPersistence<T> implements IPersistence<T> {
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("travel");
	
	private MySqlPersistence(){
	}
	public static final <T> MySqlPersistence<T> create(){
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
//		namedQuery.setMaxResults(10000);
		return namedQuery.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getPersistenceObjects(String query,Map.Entry<String,?>... parameters) {
		EntityManager manager = factory.createEntityManager();
		Query namedQuery= manager.createNamedQuery(query);
//		namedQuery.setMaxResults(10);
		for(Map.Entry<String,?> entry:parameters){
			namedQuery.setParameter(entry.getKey(), entry.getValue());
		}
		return namedQuery.getResultList();
	}
	
	public boolean insertPersistenceObjects(T object){
		EntityManager manager = factory.createEntityManager();
		return false;
	}
	
	public boolean updatePersistenceObject(T object){
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		T merged = manager.merge(object);
		manager.getTransaction().commit();
		return true;
		
	}
	
	
	
}
