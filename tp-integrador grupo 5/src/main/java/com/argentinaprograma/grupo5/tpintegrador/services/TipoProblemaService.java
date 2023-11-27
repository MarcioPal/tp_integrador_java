package com.argentinaprograma.grupo5.tpintegrador.services;

import com.argentinaprograma.grupo5.tpintegrador.model.TipoProblema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argentinaprograma.grupo5.tpintegrador.repositories.TipoProblemaRepository;

@Service
public class TipoProblemaService {
TipoProblemaRepository tipoProblemaRepository;

@Autowired

    public TipoProblemaService(TipoProblemaRepository tipoProblemaRepository) {
        this.tipoProblemaRepository = tipoProblemaRepository;
    }

public int guardar(TipoProblema t){
     return this.tipoProblemaRepository.save(t).getId();
 }

 public TipoProblema obtenerTipoProblemaPorId(Integer id){
 return this.tipoProblemaRepository.findById(id).get();
}
}
