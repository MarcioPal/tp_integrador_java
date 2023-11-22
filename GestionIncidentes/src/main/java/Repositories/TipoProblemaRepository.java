/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Entidades.Especialidad;
import Entidades.TipoProblema;
import java.io.File;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author marci
 */
public class TipoProblemaRepository extends BaseRepository<TipoProblema>{
    
    public TipoProblemaRepository() {
         super(new Configuration().configure(new File("hibernate.cfg.xml")).addAnnotatedClass(TipoProblema.class).buildSessionFactory());
    }
    
     @Override
    public TipoProblema findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(TipoProblema.class, id);
        }
    }
    
    
    @Override
    public List<TipoProblema> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM tipos_de_problema", TipoProblema.class).list();
        }
    }
}
