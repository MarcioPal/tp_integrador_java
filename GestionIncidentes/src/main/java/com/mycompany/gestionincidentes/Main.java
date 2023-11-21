/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionincidentes;

import Entidades.RolUsuario;
import Entidades.Usuario;
import Repositories.RolUsuarioRepository;
import Repositories.UsuarioRepository;

/**
 *
 * @author marci
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Usuario.class);
        RolUsuario rol = new RolUsuario();
        rol.setNombre("Admin");
    
        Usuario us = new Usuario("marcio22","123456","Marcio Palazzo",rol);
        RolUsuarioRepository rolrepo = new RolUsuarioRepository();
        UsuarioRepository urepo = new UsuarioRepository();
        rolrepo.save(rol);
        urepo.save(us); 
    }
}
