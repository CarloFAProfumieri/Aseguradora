package com.example.aseguradora.DAOs;

import com.example.aseguradora.DTOs.ClienteDTO;
import com.example.aseguradora.persistentes.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ClienteDAO {

    private final SessionFactory sessionFactory;

    public ClienteDAO() {
        Configuration configuration = new Configuration().configure(ClienteDAO.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }

    public void guardarCliente(Cliente cliente) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(cliente);
            transaction.commit();
        }
    }

    public Cliente obtenerClientePorNumero(int numeroCliente) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Cliente.class, numeroCliente);
        }
    }

    public List<Cliente> obtenerTodosLosClientes() {
        try (Session session = sessionFactory.openSession()) {
            Query<Cliente> query = session.createQuery("FROM Cliente", Cliente.class);
            return query.list();
        }
    }

    // Otros métodos para operaciones CRUD y consultas específicas...
    public void getCliente(int numeroCliente) {
    }

    public List<Cliente> getClientes(ClienteDTO unClienteDTO, int cantidadMaximaDeResultados, int desde) {
        try (Session session = sessionFactory.openSession()) {
            StringBuilder queryString = getStringBuilder(unClienteDTO);

            // Agrega condiciones similares para otros campos

            Query<Cliente> query = session.createQuery(queryString.toString(), Cliente.class);

            if (unClienteDTO.getNumeroCliente() != 0) {
                query.setParameter("numeroCliente", unClienteDTO.getNumeroCliente());
            }

            if (unClienteDTO.getTipoDocumentoId() != 0) {
                query.setParameter("idTipoDocumento", unClienteDTO.getTipoDocumentoId());
            }

            if (unClienteDTO.getNumeroDocumento() != 0){
                query.setParameter("numeroDocumento", unClienteDTO.getNumeroDocumento());
            }
            if (unClienteDTO.getApellido() != null){
                query.setParameter("apellido","%" + unClienteDTO.getApellido() + "%");
            }
            if (unClienteDTO.getNombre() != null){
                query.setParameter("nombre", "%" + unClienteDTO.getNombre() + "%");
            }
            query.setFirstResult(desde);
            query.setMaxResults(cantidadMaximaDeResultados);
            return query.getResultList();
        }
    }

    private static StringBuilder getStringBuilder(ClienteDTO unClienteDTO) {
        StringBuilder queryString = new StringBuilder("FROM Cliente c WHERE 1=1"); // 1=1 para que si no se cargó nada en el clienteDTO se devuelvan todos los clientes

        if (unClienteDTO.getNumeroCliente() != 0) {
            queryString.append(" AND c.numeroCliente = :numeroCliente");
        }

        if (unClienteDTO.getTipoDocumentoId() != 0) {
            queryString.append(" AND c.tipoDocumento.idTipoDocumento = :idTipoDocumento");
        }

        if (unClienteDTO.getNumeroDocumento() != 0){
            queryString.append(" AND c.numeroDocumento = :numeroDocumento");
        }

        if (unClienteDTO.getApellido() != null){
            queryString.append(" AND LOWER(c.apellido) LIKE LOWER(:apellido)");
        }
        if (unClienteDTO.getNombre() != null){
            queryString.append(" AND LOWER(c.nombre) LIKE LOWER(:nombre)");
        }
        return queryString;
    }

}
