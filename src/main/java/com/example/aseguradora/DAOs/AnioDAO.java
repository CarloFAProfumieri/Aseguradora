package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.AnioFabricacion;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AnioDAO {

    private final SessionFactory sessionFactory;

    public AnioDAO() {
        Configuration configuration = new Configuration().configure(AnioFabricacion.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }
}
