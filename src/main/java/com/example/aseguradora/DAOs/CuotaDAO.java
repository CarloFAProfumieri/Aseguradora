package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.Cliente;
import com.example.aseguradora.persistentes.Cuota;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class CuotaDAO {

    private final SessionFactory sessionFactory;

    public CuotaDAO() {
        Configuration configuration = new Configuration().configure(ClienteDAO.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }

    public void guardarCuota(Cuota cuota) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(cuota);
            transaction.commit();
        }
    }

    public Cuota obtenerClientePorNumero(int idCuota) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Cuota.class, idCuota);
        }
    }

    public List<Cuota> getAllCuotas() {
        try (Session session = sessionFactory.openSession()) {
            Query<Cuota> query = session.createQuery("FROM Cuota", Cuota.class);
            return query.list();
        }
    }

    // Otros métodos para operaciones CRUD y consultas específicas...
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure(ClienteDAO.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        ClienteDAO clienteDAO = new ClienteDAO();

        // Ahora puedes usar clienteDAO para interactuar con la base de datos
        // por ejemplo, guardar un nuevo cliente
        Cliente nuevoCliente = new Cliente(/* Datos del cliente */);
        clienteDAO.guardarCliente(nuevoCliente);

        // Obtener un cliente por número
        int numeroCliente = 1;
        Cliente clienteObtenido = clienteDAO.obtenerClientePorNumero(numeroCliente);
        System.out.println("Cliente obtenido: " + clienteObtenido);

        // Obtener todos los clientes
        List<Cliente> todosLosClientes = clienteDAO.obtenerTodosLosClientes();
        System.out.println("Todos los clientes: " + todosLosClientes);
    }
}
