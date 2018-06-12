package br.com.fiap.smartcities.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.smartcities.dao.UsuarioDAO;
import br.com.fiap.smartcities.entity.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO { 
	public UsuarioDAOImpl(EntityManager em) {
		this.em = em;
	}
}