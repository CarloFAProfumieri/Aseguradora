package com.example.aseguradora.DAOs;

import com.example.aseguradora.DTOs.ClienteDTO;
import com.example.aseguradora.enumeraciones.EstadoCliente;
import com.example.aseguradora.persistentes.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
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

            if (unClienteDTO.getNumeroDocumento() != 0) {
                query.setParameter("numeroDocumento", unClienteDTO.getNumeroDocumento());
            }
            if (unClienteDTO.getApellido() != null) {
                query.setParameter("apellido", "%" + unClienteDTO.getApellido() + "%");
            }
            if (unClienteDTO.getNombre() != null) {
                query.setParameter("nombre", "%" + unClienteDTO.getNombre() + "%");
            }
            query.setFirstResult(desde);
            query.setMaxResults(cantidadMaximaDeResultados);
            return query.getResultList();
        }
    }

    public int getClientesNumeroDeCoincidencias(ClienteDTO unClienteDTO, int numeroDeResultadosMax) {
        try (Session session = sessionFactory.openSession()) {
            StringBuilder queryString = getStringBuilder(unClienteDTO);

            queryString.insert(0, "select count(*) ");

            Query<Long> countQuery = session.createQuery(queryString.toString(), Long.class);

            if (unClienteDTO.getNumeroCliente() != 0) {
                countQuery.setParameter("numeroCliente", unClienteDTO.getNumeroCliente());
            }

            if (unClienteDTO.getTipoDocumentoId() != 0) {
                countQuery.setParameter("idTipoDocumento", unClienteDTO.getTipoDocumentoId());
            }

            if (unClienteDTO.getNumeroDocumento() != 0) {
                countQuery.setParameter("numeroDocumento", unClienteDTO.getNumeroDocumento());
            }

            if (unClienteDTO.getApellido() != null) {
                countQuery.setParameter("apellido", "%" + unClienteDTO.getApellido() + "%");
            }

            if (unClienteDTO.getNombre() != null) {
                countQuery.setParameter("nombre", "%" + unClienteDTO.getNombre() + "%");
            }
            countQuery.setMaxResults(numeroDeResultadosMax);
            return Math.toIntExact(Math.min(countQuery.getSingleResult(), numeroDeResultadosMax));
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

        if (unClienteDTO.getNumeroDocumento() != 0) {
            queryString.append(" AND c.numeroDocumento = :numeroDocumento");
        }

        if (unClienteDTO.getApellido() != null) {
            queryString.append(" AND LOWER(c.apellido) LIKE LOWER(:apellido)");
        }
        if (unClienteDTO.getNombre() != null) {
            queryString.append(" AND LOWER(c.nombre) LIKE LOWER(:nombre)");
        }
        return queryString;
    }

    public void setEstadoCliente(ClienteDTO clienteDTO, EstadoCliente estadoCliente) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                Cliente cliente = obtenerClientePorNumero(clienteDTO.getNumeroCliente());

                cliente.setEstado(estadoCliente);

                // Guardar los cambios en la base de datos
                session.save(cliente);

                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }


    public boolean esActivoHace2Anios(int numeroCliente) {
        try (Session session = sessionFactory.openSession()) {
            // Utilizamos HQL para verificar si el cliente está activo hace 2 años
            String hql = "SELECT CASE WHEN c.activoDesde <= :fechaHace2Anios THEN true ELSE false END " +
                    "FROM Cliente c " +
                    "WHERE c.numeroCliente = :numeroCliente";

            LocalDate fechaHace2Anios = LocalDate.now().minusYears(2);

            Query<Boolean> query = session.createQuery(hql, Boolean.class);
            query.setParameter("numeroCliente", numeroCliente);
            query.setParameter("fechaHace2Anios", fechaHace2Anios);

            return query.uniqueResult();
        }
    }

}
