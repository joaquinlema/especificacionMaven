package com.vaadin.vaadin_archetype_jpacontainer.Test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vaadin.vaadin_archetype_jpacontainer.domain.ClienteEjemplo;
import com.vaadin.vaadin_archetype_jpacontainer.domain.Direccion;

public class EntityManagerTest {

	private static EntityManagerFactory entityManagerFactory;

	@BeforeClass
	public static void setUp() throws Exception {
			entityManagerFactory = Persistence.createEntityManagerFactory("com.vaadin.vaadin_archetype_jpacontainer" );
	}

	@AfterClass
	public static void tearDown() throws Exception {
		entityManagerFactory.close();
	}

	
	@Test
	public void testHibernate() {
		// Creamos un cliente con su dirección
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		ClienteEjemplo c = new ClienteEjemplo(2003581, "Cliente1");
		c.setDir(new Direccion("Domicilio1"));
	
		entityManager.persist(c);
		entityManager.getTransaction().commit();
		entityManager.close();

		//y los recuperamos.
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
        List<ClienteEjemplo> result = entityManager.createQuery( "from ClienteEjemplo", ClienteEjemplo.class ).getResultList();
		for ( ClienteEjemplo cliente : result ) {
			System.out.println( cliente.getRazonSocial() + " " + cliente.getDir().getDomicilio());
		}
        entityManager.getTransaction().commit();
        entityManager.close();
	}

}
