package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.MedidaSeguridad;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class MedidaSeguridadDAO {
    private final SessionFactory sessionFactory;

    public MedidaSeguridadDAO() {
        Configuration configuration = new Configuration().configure(MedidaSeguridad.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }

    public List<MedidaSeguridad> getAllMedidas() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<MedidaSeguridad> query = session.createQuery("FROM MedidaSeguridad ", MedidaSeguridad.class);
            List<MedidaSeguridad> marcas = query.getResultList();

            transaction.commit();

            return marcas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
