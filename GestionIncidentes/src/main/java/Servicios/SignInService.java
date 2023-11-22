/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Entidades.Usuario;
import Repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SignInService {
    public UsuarioRepository urepo;
    
    public SignInService(){
        urepo = new UsuarioRepository();
    }
    
    
    public String findUser(String user, String pass){
         return urepo.findByUserandPassword(user, pass).get(0).getRol().getNombre();

    }
    
    public boolean verifyCredentials(String user, String pass){
       try {
           urepo.findByUserandPassword(user, pass);
           return true;
       }
       catch(Exception e){
           return false;
       }
    }
}
