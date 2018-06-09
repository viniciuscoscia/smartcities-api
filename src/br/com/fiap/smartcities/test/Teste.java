package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;

import br.com.fiap.smartcities.entity.Usuario;
import br.com.fiap.smartcities.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {

		EntityManager em = null;

		Usuario Usuario = new Usuario();
		Usuario.setNome("Fernando Gouveia Lima");
		Usuario.setEmail("qualquer@gmail.com");

		try {
			em = EntityManagerFactorySingleton.getInstance().createEntityManager();
			em.getTransaction().begin();
			em.persist(Usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			System.out.println("Cadastro não realizado");
		} finally {
			em.close();
		}
	}
}