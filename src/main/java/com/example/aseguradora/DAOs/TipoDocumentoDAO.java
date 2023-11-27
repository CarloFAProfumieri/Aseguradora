package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.TipoCobertura;
import com.example.aseguradora.persistentes.TipoDocumento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class TipoDocumentoDAO {
    private final SessionFactory sessionFactory;
    public TipoDocumentoDAO() {
        Configuration configuration = new Configuration().configure(TipoCobertura.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }
    public List<TipoDocumento> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<TipoDocumento> query = session.createQuery("FROM TipoDocumento ", TipoDocumento.class);
            return query.list();
        }
    }
}
