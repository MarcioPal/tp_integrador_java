
package com.argentinaprograma.grupo5.tpintegrador.repositories;

import com.argentinaprograma.grupo5.tpintegrador.model.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenteRepository extends JpaRepository<Incidente, Integer>{
    
}
