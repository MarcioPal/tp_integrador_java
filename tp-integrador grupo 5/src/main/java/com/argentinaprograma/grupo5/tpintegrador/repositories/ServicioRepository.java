package com.argentinaprograma.grupo5.tpintegrador.repositories;

import com.argentinaprograma.grupo5.tpintegrador.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ServicioRepository extends JpaRepository<Servicio, Integer>{
    
}
