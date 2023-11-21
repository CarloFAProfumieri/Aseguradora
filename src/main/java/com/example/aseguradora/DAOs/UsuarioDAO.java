package com.example.aseguradora.DAOs;

import com.example.aseguradora.persistentes.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UsuarioDAO {

    private final SessionFactory sessionFactory;

    public UsuarioDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void guardarUsuario(Usuario usuario) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        }
    }

    public Usuario getUsuario(int nombreUsuario) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Usuario.class, nombreUsuario);
        }
    }

    public List<Usuario> getAllUsuarios() {
        try (Session session = sessionFactory.openSession()) {
            Query<Usuario> query = session.createQuery("FROM Usuario ", Usuario.class);
            return query.list();
        }
    }
}
