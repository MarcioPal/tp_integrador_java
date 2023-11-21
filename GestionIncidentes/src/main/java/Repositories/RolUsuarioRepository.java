/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Entidades.RolUsuario;
import Entidades.Usuario;
import java.io.File;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author marci
 */
public class RolUsuarioRepository extends BaseRepository<RolUsuario>{
    
    public RolUsuarioRepository() {
          super(new Configuration().configure(new File("hibernate.cfg.xml")).addAnnotatedClass(RolUsuario.class).buildSessionFactory());
    }
    
    
      @Override
    public RolUsuario findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(RolUsuario.class, id);
        }
    }
    
    
    @Override
    public List<RolUsuario> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM roles", RolUsuario.class).list();
        }
    }
}
