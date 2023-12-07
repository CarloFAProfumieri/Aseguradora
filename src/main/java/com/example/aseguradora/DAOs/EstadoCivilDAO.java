package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.EstadoCivil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class EstadoCivilDAO {
    private final SessionFactory sessionFactory;

    public EstadoCivilDAO() {
        Configuration configuration = new Configuration().configure(EstadoCivil.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }
    //cambio de preuba
    public List<EstadoCivil> getAllEstadosCiviles() {
        try (Session session = sessionFactory.openSession()) {
            Query<EstadoCivil> query = session.createQuery("FROM EstadoCivil", EstadoCivil.class);
            return query.list();
        }
    }

    public EstadoCivil getEstadoCivil(int idEstadoCivil) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(EstadoCivil.class, idEstadoCivil);
        }
    }
}
