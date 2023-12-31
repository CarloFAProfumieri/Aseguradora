package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.AnioFabricacion;
import com.example.aseguradora.persistentes.ModeloVehiculo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ModeloDAO {

    private final SessionFactory sessionFactory;

    public ModeloDAO() {
        Configuration configuration = new Configuration().configure(ModeloVehiculo.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }
    public List<ModeloVehiculo> getModelos(int idMarca) {
        try (Session session = sessionFactory.openSession()) {
            Query<ModeloVehiculo> query = session.createQuery("FROM ModeloVehiculo WHERE marca.idMarca = :idMarca", ModeloVehiculo.class);
            query.setParameter("idMarca", idMarca);
            return query.list();
        }
    }

    public ModeloVehiculo getModelo(int idModelo) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(ModeloVehiculo.class, idModelo);
        }
    }

    public List<AnioFabricacion> getAnios(int idModelo) {//optimizar
        try (Session session = sessionFactory.openSession()) {
            ModeloVehiculo modelo = session.get(ModeloVehiculo.class, idModelo);
            return modelo.getAnios();
        }
    }
}
