package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.Provincia;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ProvinciaDAO {
    private final SessionFactory sessionFactory;

    public ProvinciaDAO() {
        Configuration configuration = new Configuration().configure(Provincia.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }
    public List<Provincia> getAllProvincias() {
        try (Session session = sessionFactory.openSession()) {
            Query<Provincia> query = session.createQuery("FROM Provincia", Provincia.class);
            return query.list();
        }
    }
}
