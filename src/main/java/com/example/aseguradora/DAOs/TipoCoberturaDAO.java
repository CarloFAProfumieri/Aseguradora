package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.CantidadSiniestros;
import com.example.aseguradora.persistentes.TipoCobertura;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class TipoCoberturaDAO {
    private final SessionFactory sessionFactory;

    public TipoCoberturaDAO() {
        Configuration configuration = new Configuration().configure(TipoCobertura.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }
    public List<TipoCobertura> getAllTiposCobertura() {
        try (Session session = sessionFactory.openSession()) {
            Query<TipoCobertura> query = session.createQuery("FROM TipoCobertura", TipoCobertura.class);
            return query.list();
        }
    }
}
