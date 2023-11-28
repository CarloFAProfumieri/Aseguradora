package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.KmPorAnio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class KmPorAnioDAO {
    private final SessionFactory sessionFactory;

    public KmPorAnioDAO() {
        Configuration configuration = new Configuration().configure(KmPorAnio.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }

    public KmPorAnio getKmPorAnio(int idKmPorAnio) {
        try (Session session = sessionFactory.openSession()){
            return session.get(KmPorAnio.class, idKmPorAnio);
        }
    }
}
