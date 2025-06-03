package ar.edu.uncuyo.dao;

import ar.edu.uncuyo.model.genero;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class generoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public void insert_genero(genero genero) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(genero);
        em.getTransaction().commit();
        em.close();
    }

    public void updateGenero(genero generoNuevo) {
        EntityManager em = emf.createEntityManager();
        genero generoExistente = em.find(genero.class, generoNuevo.getID_genero());
        em.getTransaction().begin();
        if (generoExistente == null) {
            throw new IllegalArgumentException("Género no encontrado");
        } else {
            generoExistente.setDescripcion(generoNuevo.getdescripcion());
        }
        em.merge(generoExistente);
        em.getTransaction().commit();
        em.close();
    }

    public void delete_genero(genero genero) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        genero = em.find(genero.class, genero.getID_genero());
        if (genero != null) {
            em.remove(genero);
        } else {
            throw new IllegalArgumentException("Género no encontrado");
        }
        em.getTransaction().commit();
        em.close();
    }

    public genero getIdGenero(Long id) {
        EntityManager em = emf.createEntityManager();
        genero genero = em.find(genero.class, id);
        em.close();
        return genero;
    }

    public List<genero> getAllGeneros() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<genero> query = em.createQuery("FROM genero", genero.class);
        List<genero> generos = query.getResultList();
        em.close();
        return generos;
    }
}
