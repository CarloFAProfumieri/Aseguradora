package com.example.aseguradora.DAOs;

import com.example.aseguradora.DTOs.PolizaDTO;
import com.example.aseguradora.enumeraciones.EstadoPoliza;
import com.example.aseguradora.persistentes.Poliza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class PolizaDAO {

    private final SessionFactory sessionFactory;

    public PolizaDAO() {
        Configuration configuration = new Configuration().configure(ClienteDAO.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }

    public void guardarPoliza(PolizaDTO polizaDTO) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(polizaDTO);
            transaction.commit();
        }
    }

    public void guardarPoliza(Poliza poliza) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(poliza);
            transaction.commit();
        }
    }

    public Poliza getPoliza(String numeroPoliza) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Poliza.class, numeroPoliza);
        }
    }
    public boolean existePatenteVigente(String numeroDePatente) {
        EstadoPoliza estadoPoliza = EstadoPoliza.GENERADA;
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT COUNT(*) FROM Poliza p WHERE p.patente = :patente AND p.estadoPoliza = :estadoPoliza";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("patente", numeroDePatente);
            query.setParameter("estadoPoliza",estadoPoliza);

            Long count = query.uniqueResult();
            return count > 0;
        }
    }
    public boolean existeChasisVigente(String codigoChasis) {
        EstadoPoliza estadoPoliza = EstadoPoliza.GENERADA;
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT COUNT(*) FROM Poliza p WHERE p.codigoChasis = :chasis AND p.estadoPoliza = :estadoPoliza";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("chasis", codigoChasis);
            query.setParameter("estadoPoliza",estadoPoliza);

            Long count = query.uniqueResult();
            return count > 0;
        }
    }
    public boolean existeMotorVigente(String codigoMotor) {
        EstadoPoliza estadoPoliza = EstadoPoliza.GENERADA;
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT COUNT(*) FROM Poliza p WHERE p.codigoMotor = :motor AND p.estadoPoliza = :estadoPoliza";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("motor", codigoMotor);
            query.setParameter("estadoPoliza",estadoPoliza);

            Long count = query.uniqueResult();
            return count > 0;
        }
    }
    public List<Poliza> getAllPolizas() {
        try (Session session = sessionFactory.openSession()) {
            Query<Poliza> query = session.createQuery("FROM Poliza ", Poliza.class);
            return query.list();
        }
    }

    public int obtenerNumeroRenovacion(String numeroPoliza) {
        try (Session session = sessionFactory.openSession()) {
            // Consulta para obtener el número de sucursal desde la base de datos
            return Integer.parseInt((String) session.createQuery("SELECT SUBSTRING(p.numeroPoliza, 1, 4) FROM Poliza p WHERE p.numeroPoliza = :numeroPoliza")
                    .setParameter("numeroPoliza", numeroPoliza)
                    .uniqueResult());
        } catch (Exception e) {
            // Manejar excepciones (por ejemplo, loggear o relanzar)
            e.printStackTrace();
            return -1; // Valor predeterminado o código de error
        }
    }


    public int getPolizasVigentes(int numeroCliente) {
        try (Session session = sessionFactory.openSession()) {
            // Utilizamos HQL para contar las polizas vigentes del cliente
            String hql = "SELECT COUNT(p) FROM Poliza p " +
                    "WHERE p.cliente.numeroCliente = :numeroCliente " +
                    "AND p.estadoPoliza = :estadoPoliza";

            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("numeroCliente", numeroCliente);
            query.setParameter("estadoPoliza", EstadoPoliza.VIGENTE);

            System.out.println("cantidadPolizasActivas: " + Math.toIntExact(query.uniqueResult()));
            return Math.toIntExact(query.uniqueResult());
        }
    }
}
