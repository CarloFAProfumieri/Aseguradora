package com.example.aseguradora.DAOs;

import com.example.aseguradora.DTOs.PolizaDTO;
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
    public Poliza getPoliza(int numeroPoliza) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Poliza.class, numeroPoliza);
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






}
