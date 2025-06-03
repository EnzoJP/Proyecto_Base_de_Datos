package ar.edu.uncuyo.dao;

import ar.edu.uncuyo.model.cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class clienteDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public void insert_cliente(cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public void updateCliente(cliente clienteNuevo) {
    EntityManager em = emf.createEntityManager();
    cliente clienteExistente = em.find(cliente.class, clienteNuevo.getId());
    em.getTransaction().begin();
    if (clienteExistente == null) {
        throw new IllegalArgumentException("Cliente no encontrado");
    } else {
        clienteExistente.setNombre(clienteNuevo.getNombre());
        clienteExistente.setApellido(clienteNuevo.getApellido());
        clienteExistente.setDni(clienteNuevo.getDni());
        clienteExistente.setTelefono(clienteNuevo.getTelefono());
        clienteExistente.setEmail(clienteNuevo.getEmail());
        clienteExistente.setCodPostal(clienteNuevo.getCodPostal());
        clienteExistente.setGenero(clienteNuevo.getGenero());
    }
    em.merge(clienteExistente);
    em.getTransaction().commit();
    em.close();
    }

    public void delete_cliente(cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        cliente = em.find(cliente.class, cliente.getId());
        if (cliente != null) {
            em.remove(cliente);
        }else {
            throw new IllegalArgumentException("Cliente no encontrado");
        }
        em.getTransaction().commit();
        em.close();
    }

    public cliente getIdCliente(Long id) {
        EntityManager em = emf.createEntityManager();
        cliente cliente = em.find(cliente.class, id);
        em.close();
        return cliente;
    }

    public List<cliente> getAllClientes() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<cliente> query = em.createQuery("FROM cliente ", cliente.class);
        List<cliente> clientes = query.getResultList();
        em.close();
        return clientes;
    }
}
