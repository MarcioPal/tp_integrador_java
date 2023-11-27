/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprograma.grupo5.tpintegrador.services;

import com.argentinaprograma.grupo5.tpintegrador.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argentinaprograma.grupo5.tpintegrador.repositories.ClienteRepository;

@Service
public class ClienteService {
ClienteRepository clienteRepository;

@Autowired

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

 public int guardar(Cliente t){
     return this.clienteRepository.save(t).getId();
 }

 public Cliente obtenerClientePorId(Integer id){
 return this.clienteRepository.findById(id).get();
}
}


