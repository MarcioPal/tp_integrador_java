
package com.argentinaprograma.grupo5.tpintegrador.repositories;

import com.argentinaprograma.grupo5.tpintegrador.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
