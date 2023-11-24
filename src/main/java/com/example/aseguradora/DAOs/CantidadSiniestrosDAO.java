package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.CantidadSiniestros;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CantidadSiniestrosDAO {

    private final SessionFactory sessionFactory;

    public CantidadSiniestrosDAO() {
        Configuration configuration = new Configuration().configure(CantidadSiniestros.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }
}
