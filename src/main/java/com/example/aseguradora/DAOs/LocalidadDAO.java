package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.Localidad;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class LocalidadDAO {
    private final SessionFactory sessionFactory;

    public LocalidadDAO() {
        Configuration configuration = new Configuration().configure(Localidad.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }
    public List<Localidad> getLocalidades(int idProvincia) {
        try (Session session = sessionFactory.openSession()) {
            Query<Localidad> query = session.createQuery("FROM Localidad WHERE provincia.idProvincia = :idProvincia", Localidad.class);
            query.setParameter("idProvincia", idProvincia);
            return query.list();
        }
    }
    public Localidad getLocalidad(int idLocalidad) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Localidad.class, idLocalidad);
        }
    }
}
