package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.Localidad;
import com.example.aseguradora.persistentes.MedidaSeguridad;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MedidaSeguridadDAO {
    private final SessionFactory sessionFactory;

    public MedidaSeguridadDAO() {
        Configuration configuration = new Configuration().configure(MedidaSeguridad.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }
}
