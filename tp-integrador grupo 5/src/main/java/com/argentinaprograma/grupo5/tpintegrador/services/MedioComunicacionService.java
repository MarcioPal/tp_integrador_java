package com.argentinaprograma.grupo5.tpintegrador.services;

import com.argentinaprograma.grupo5.tpintegrador.model.MedioComunicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argentinaprograma.grupo5.tpintegrador.repositories.MedioComunicacionRepository;

@Service
public class MedioComunicacionService {
MedioComunicacionRepository medioComunicacionRepository;

@Autowired

    public MedioComunicacionService(MedioComunicacionRepository medioComunicacionRepository) {
        this.medioComunicacionRepository = medioComunicacionRepository;
    }

public int guardar(MedioComunicacion t){
     return this.medioComunicacionRepository.save(t).getId();
 }

 public MedioComunicacion obtenerMedioComunicacionPorId(Integer id){
 return this.medioComunicacionRepository.findById(id).get();
}
}
