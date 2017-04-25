/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

import entidades.TbPessoa;

import java.lang.reflect.Field;

/**
 *
 * @author Suelem
 */
public abstract class AbstractFacade<T> {

	private Class<T> entityClass;

	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	public void create(T entity) {
		getEntityManager().persist(entity);
	}

	public void edit(T entity) {
		getEntityManager().merge(entity);
	}


	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByNome(T entity) {
		Query query = getEntityManager().createNamedQuery("TbPessoa.findByNome");
		TbPessoa filtro = (TbPessoa)entity;
		query.setParameter("nome",filtro.getNome());
		return query.getResultList();		
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByCpf(T entity) {
		System.out.println("CHEGOUB AQYUI");
		Query query1 = getEntityManager().createNamedQuery("TbPessoa.findByCpf");
		TbPessoa filtro1 = (TbPessoa)entity;
		query1.setParameter("cpf",filtro1.getCpf());
		return query1.getResultList();
	}	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> findAll() {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<T> findAllSenha() {
		Query query1 = getEntityManager().createNamedQuery("TbSenha.findAll");
		return query1.getResultList();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> findRange(int[] range) {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		q.setMaxResults(range[1] - range[0] + 1);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int count() {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}
}
