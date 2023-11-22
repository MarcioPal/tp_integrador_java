/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionincidentes;

import Entidades.Especialidad;
import Entidades.RolUsuario;
import Entidades.Servicio;
import Entidades.TipoProblema;
import Entidades.Usuario;
import Repositories.EspecialidadRepository;
import Repositories.RolUsuarioRepository;
import Repositories.ServicioRepository;
import Repositories.TipoProblemaRepository;
import Repositories.UsuarioRepository;
import java.util.ArrayList;

/**
 *
 * @author marci
 */
public class Main {

    public static void main(String[] args) {
      
        //CARGA MASIVA DE PARAMETRIA, EJECUTAR SOLO LA PRIMERA VEZ
        /*
        RolUsuario rol = new RolUsuario();
        rol.setNombre("operador");
        RolUsuario rol1 = new RolUsuario();
        rol1.setNombre("rrhh");
        RolUsuario rol2 = new RolUsuario();
        rol2.setNombre("comercial");
        RolUsuario rol3 = new RolUsuario();
        rol3.setNombre("tecnico");
        
        Especialidad e = new Especialidad();
        e.setNombre("Optimizacion");
        Especialidad e1 = new Especialidad();
        e1.setNombre("Redes");
        Especialidad e2 = new Especialidad();
        e2.setNombre("CiberSeguridad");
        
       
        TipoProblema tp = new TipoProblema();
        tp.setNombre("Problemas de rendimiento");
        tp.setEspecialidades(new ArrayList());
        tp.setTiempoEstimadoHoras(5);
        tp.setTiempoMaximoHoras(7);
        tp.getEspecialidades().add(e);
        TipoProblema tp1 = new TipoProblema();
        tp1.setNombre("Problemas de red");
        tp1.setTiempoEstimadoHoras(3);
        tp1.setTiempoMaximoHoras(4);
        tp1.setEspecialidades(new ArrayList());
        tp1.getEspecialidades().add(e1);
        TipoProblema tp2 = new TipoProblema();
        tp2.setNombre("Problemas de seguridad");
        tp2.setTiempoEstimadoHoras(2);
        tp2.setTiempoMaximoHoras(4);
        tp2.setEspecialidades(new ArrayList());
        tp2.getEspecialidades().add(e2);
        
        ArrayList<TipoProblema> tipos = new ArrayList<>();
        tipos.add(tp);
        tipos.add(tp1);
        tipos.add(tp2);
        
        Servicio s = new Servicio();
        s.setNombre("SAP");
        s.setTipos_problema(tipos);
        Servicio s1 = new Servicio();
        s1.setNombre("TANGO");
        s1.setTipos_problema(tipos);
        Servicio s2 = new Servicio();
        s2.setNombre("Windows");
        s2.setTipos_problema(tipos);
        Servicio s3 = new Servicio();
        s3.setNombre("MacOS");
        s3.setTipos_problema(tipos);
        Servicio s4 = new Servicio();
        s4.setNombre("Linux");
        s4.setTipos_problema(tipos);
        
      
        
        Usuario us = new Usuario("operador","123456","Marcio Palazzo",rol);
        RolUsuarioRepository rolrepo = new RolUsuarioRepository();
        UsuarioRepository urepo = new UsuarioRepository();
        ServicioRepository srepo = new ServicioRepository();
        EspecialidadRepository erepo = new EspecialidadRepository();
        TipoProblemaRepository tprepo = new TipoProblemaRepository(); 

        
        rolrepo.save(rol);
        rolrepo.save(rol2);
        rolrepo.save(rol3);
   
        urepo.save(us); 
        
        erepo.save(e);
        erepo.save(e1);
        erepo.save(e2);
        
        tprepo.save(tp);
        tprepo.save(tp1);
        tprepo.save(tp2);
        
        srepo.save(s1);
        srepo.save(s2);
        srepo.save(s3);
        srepo.save(s4);
        
       */
        
      
    }
}
