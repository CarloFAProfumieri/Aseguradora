package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.File;
import java.util.List;

public class ClienteDAO {

    private final SessionFactory sessionFactory;

    public ClienteDAO() {
        Configuration configuration = new Configuration().configure(ClienteDAO.class.getClassLoader().getResource("hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.sessionFactory = sessionFactory;
    }

    public void guardarCliente(Cliente cliente) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(cliente);
            transaction.commit();
        }
    }

    public Cliente obtenerClientePorNumero(int numeroCliente) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Cliente.class, numeroCliente);
        }
    }

    public List<Cliente> obtenerTodosLosClientes() {
        try (Session session = sessionFactory.openSession()) {
            Query<Cliente> query = session.createQuery("FROM Cliente", Cliente.class);
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
