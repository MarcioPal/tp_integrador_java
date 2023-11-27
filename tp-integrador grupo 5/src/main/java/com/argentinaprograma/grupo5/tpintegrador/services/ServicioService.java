
package com.argentinaprograma.grupo5.tpintegrador.services;

import com.argentinaprograma.grupo5.tpintegrador.model.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argentinaprograma.grupo5.tpintegrador.repositories.ServicioRepository;

@Service
public class ServicioService {
ServicioRepository servicioRepository;

@Autowired

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

public int guardar(Servicio t){
     return this.servicioRepository.save(t).getId();
 }

 public Servicio obtenerServicioPorId(Integer id){
 return this.servicioRepository.findById(id).get();
}
}