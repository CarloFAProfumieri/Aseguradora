package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.CantidadSiniestros;
import com.example.aseguradora.persistentes.MedidaSeguridad;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class CantidadSiniestrosDAO {

    private final SessionFactory sessionFactory;

    public CantidadSiniestrosDAO() {
        Configuration configuration = new Configuration().configure(CantidadSiniestros.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }

    public List<CantidadSiniestros> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<CantidadSiniestros> query = session.createQuery("FROM CantidadSiniestros ", CantidadSiniestros.class);
            List<CantidadSiniestros> marcas = query.getResultList();

            transaction.commit();

            return marcas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
