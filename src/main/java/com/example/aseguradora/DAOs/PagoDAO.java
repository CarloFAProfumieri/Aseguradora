package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.Cuota;
import com.example.aseguradora.persistentes.PagoPoliza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class PagoDAO {

    private final SessionFactory sessionFactory;

    public PagoDAO() {
        Configuration configuration = new Configuration().configure(ClienteDAO.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }

    public void guardarPago(PagoPoliza pagoPoliza) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(pagoPoliza);
            transaction.commit();
        }
    }

    public PagoPoliza getPagoPoliza(int idPago) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(PagoPoliza.class, idPago);
        }
    }

    public List<PagoPoliza> getAllPagos() {
        try (Session session = sessionFactory.openSession()) {
            Query<PagoPoliza> query = session.createQuery("FROM PagoPoliza ", PagoPoliza.class);
            return query.list();
        }
    }
}
