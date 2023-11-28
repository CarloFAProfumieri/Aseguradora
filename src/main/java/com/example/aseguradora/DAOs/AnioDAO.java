package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.AnioFabricacion;
import com.example.aseguradora.persistentes.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AnioDAO {

    private final SessionFactory sessionFactory;

    public AnioDAO() {
        Configuration configuration = new Configuration().configure(AnioFabricacion.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }

    public AnioFabricacion getAnio(int anio) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(AnioFabricacion.class, anio);
        }
    }
    //public void guardarAnios();
}
