package com.argentinaprograma.grupo5.tpintegrador.repositories;


import com.argentinaprograma.grupo5.tpintegrador.model.Tecnico;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{
    
}
