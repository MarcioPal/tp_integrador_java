
package com.argentinaprograma.grupo5.tpintegrador.services;

import com.argentinaprograma.grupo5.tpintegrador.model.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argentinaprograma.grupo5.tpintegrador.repositories.EspecialidadRepository;

@Service
public class EspecialidadService {
EspecialidadRepository especialidadRepository;

@Autowired

 public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }
 public int guardar(Especialidad t){
     return this.especialidadRepository.save(t).getId();
 }    
 public Especialidad obtenerEspecialidadPorId(Integer id){
 return this.especialidadRepository.findById(id).get();
}
}

