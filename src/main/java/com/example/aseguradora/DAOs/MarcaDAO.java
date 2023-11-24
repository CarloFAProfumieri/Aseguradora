package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.Localidad;
import com.example.aseguradora.persistentes.Marca;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class MarcaDAO {
    private final SessionFactory sessionFactory;

    public MarcaDAO() {
        Configuration configuration = new Configuration().configure(Marca.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }

    public List<Marca> getAllMarcas() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<Marca> query = session.createQuery("FROM Marca", Marca.class);
            List<Marca> marcas = query.getResultList();

            transaction.commit();

            return marcas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
