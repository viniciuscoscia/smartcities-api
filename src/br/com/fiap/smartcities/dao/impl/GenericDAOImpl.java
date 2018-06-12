package br.com.fiap.smartcities.dao.impl;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fiap.smartcities.dao.GenericDAO;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	@PersistenceContext
	protected EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void cadastrar(T entidade) {
		em.persist(entidade);
	}
	
	public void atualizar(T entidade) {
		em.merge(entidade);
	}
	
	public T buscar(K chave) {
		return em.find(clazz, chave);
	}
	
	public void remover(K chave) throws Exception {
		T entidade = buscar(chave);
		if (entidade == null) {
			throw new Exception("Entidade não encontrada");
		}
		em.remove(entidade);
	}
	
	public List<T> listar(){
		return em.createQuery("from " + clazz.getName(),clazz).getResultList();
	}
	
	@Override
    public void commit() throws Exception {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception("Erro no commit");
        }
    }
	
}