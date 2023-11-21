/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Entidades.Usuario;
import java.io.File;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author marci
 */
public class UsuarioRepository extends BaseRepository<Usuario>{
    
    public UsuarioRepository() {
        super(new Configuration().configure(new File("hibernate.cfg.xml")).addAnnotatedClass(Usuario.class).buildSessionFactory());
    }
    
    
    @Override
    public Usuario findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Usuario.class, id);
        }
    }
    
    
    @Override
    public List<Usuario> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Usuarios", Usuario.class).list();
        }
    }
    
      public List<Usuario> findByUserandPassword(String user, String pass) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Usuarios WHERE usuario = :user AND password = :pass", Usuario.class).list();
        }
    }
}
