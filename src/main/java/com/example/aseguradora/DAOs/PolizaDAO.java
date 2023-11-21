package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.Poliza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PolizaDAO {

    private final SessionFactory sessionFactory;

    public PolizaDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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

    public List<Poliza> getAllPagos() {
        try (Session session = sessionFactory.openSession()) {
            Query<Poliza> query = session.createQuery("FROM Poliza ", Poliza.class);
            return query.list();
        }
    }
}
