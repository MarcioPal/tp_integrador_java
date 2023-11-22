/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Entidades.Servicio;
import java.io.File;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author marci
 */
public class ServicioRepository extends BaseRepository<Servicio> {
    
    public ServicioRepository() {
       super(new Configuration().configure(new File("hibernate.cfg.xml")).addAnnotatedClass(Servicio.class).buildSessionFactory());
    }
    
     @Override
    public Servicio findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Servicio.class, id);
        }
    }
    
    
    @Override
    public List<Servicio> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM servicios", Servicio.class).list();
        }
    }
    
}
