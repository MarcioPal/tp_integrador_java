package com.argentinaprograma.grupo5.tpintegrador.services;

import com.argentinaprograma.grupo5.tpintegrador.model.Incidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argentinaprograma.grupo5.tpintegrador.repositories.IncidenteRepository;

@Service
public class IncidenteService {
IncidenteRepository incidenteRepository;

@Autowired

    public IncidenteService(IncidenteRepository incidenteRepository) {
        this.incidenteRepository = incidenteRepository;
    }

 public int guardar(Incidente t){
     return this.incidenteRepository.save(t).getId();
 }

 public Incidente obtenerIncidentePorId(Integer id){
 return this.incidenteRepository.findById(id).get();
}
}
