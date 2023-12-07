package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.KmPorAnio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class KmPorAnioDAO {
    private final SessionFactory sessionFactory;

    public KmPorAnioDAO() {
        Configuration configuration = new Configuration().configure(KmPorAnio.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }

    public KmPorAnio getKmPorAnio(int idKmPorAnio) {
        try (Session session = sessionFactory.openSession()){
            return session.get(KmPorAnio.class, idKmPorAnio);
        }
    }
    public List<KmPorAnio> getAllKmPorAnio() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM KmPorAnio";
            Query<KmPorAnio> query = session.createQuery(hql, KmPorAnio.class);
            return query.list();
        }
    }

    public void insertKmPorAnio(KmPorAnio kmPorAnio) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                // Guardar el objeto KmPorAnio en la base de datos
                session.save(kmPorAnio);

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace(); // Manejo de la excepción (puedes personalizar según tus necesidades)
            }
        }
    }
    public static void main(String[] args) {
        KmPorAnioDAO kmPorAnioDAO = new KmPorAnioDAO();
        KmPorAnio kmPorAnio = new KmPorAnio();
        kmPorAnio.setKmPorAnio(99999);
        kmPorAnio.setLimiteSuperior(Integer.MAX_VALUE);
        kmPorAnio.setLimiteInferior(30000);
        kmPorAnio.setValorPorcentual(0.15);
        kmPorAnioDAO.insertKmPorAnio(kmPorAnio);
    }
}
