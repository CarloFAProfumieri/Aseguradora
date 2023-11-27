package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.Hijo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HijoDAO {
    private final SessionFactory sessionFactory;

    public HijoDAO() {
        Configuration configuration = new Configuration().configure(Hijo.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }
}
