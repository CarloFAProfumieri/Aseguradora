package com.example.aseguradora.DAOs;

import com.example.aseguradora.DTOs.PolizaDTO;
import com.example.aseguradora.persistentes.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class PolizaDAO {

    private final SessionFactory sessionFactory;

    public PolizaDAO() {
        Configuration configuration = new Configuration().configure(ClienteDAO.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }

    public void guardarPoliza(PolizaDTO polizaDTO) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(polizaDTO);
            transaction.commit();
        }
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
    public Poliza getPoliza(int numeroPoliza) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Poliza.class, numeroPoliza);
        }
    }

    public List<Poliza> getAllPolizas() {
        try (Session session = sessionFactory.openSession()) {
            Query<Poliza> query = session.createQuery("FROM Poliza ", Poliza.class);
            return query.list();
        }
    }

    public List<ModeloVehiculo> getModelos(int idMarca) {
        try (Session session = sessionFactory.openSession()) {
            Query<ModeloVehiculo> query = session.createQuery("FROM ModeloVehiculo WHERE idMarca = :idMarca", ModeloVehiculo.class);
            query.setParameter("idMarca", idMarca);
            return query.list();
        }
    }

    public List<Provincia> getAllProvincias() {
        try (Session session = sessionFactory.openSession()) {
            Query<Provincia> query = session.createQuery("FROM Provincia", Provincia.class);
            return query.list();
        }
    }

    public List<Localidad> getLocalidades(int idProvincia) {
        try (Session session = sessionFactory.openSession()) {
            Query<Localidad> query = session.createQuery("FROM Localidad WHERE idProvincia = :idProvincia", Localidad.class);
            query.setParameter("idProvincia", idProvincia);
            return query.list();
        }
    }
}
