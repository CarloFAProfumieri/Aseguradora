package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.Localidad;
import com.example.aseguradora.persistentes.ValorPorcentualHijo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ValorPorcentualHijoDAO {
    private final SessionFactory sessionFactory;

    public ValorPorcentualHijoDAO() {
        Configuration configuration = new Configuration().configure(ValorPorcentualHijo.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }

    public ValorPorcentualHijo getValorPorcentualHijo(Integer idValorPorcentualHijo) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(ValorPorcentualHijo.class, idValorPorcentualHijo);
        }
    }
}
