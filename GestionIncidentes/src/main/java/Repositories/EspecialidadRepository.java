/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Entidades.Especialidad;
import Entidades.Usuario;
import java.io.File;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author marci
 */
public class EspecialidadRepository extends BaseRepository<Especialidad> {
    
    public EspecialidadRepository() {
          super(new Configuration().configure(new File("hibernate.cfg.xml")).addAnnotatedClass(Especialidad.class).buildSessionFactory());
    }
    
     @Override
    public Especialidad findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Especialidad.class, id);
        }
    }
    
    
    @Override
    public List<Especialidad> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM especialidades", Especialidad.class).list();
        }
    }
}
