/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Servicios.SignInService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SignInController {
   private static SignInController instance;
   private SignInService service;
   
   
   public boolean verifyCredentials(String user, String pass){
       return service.verifyCredentials(user, pass);
   }
   
   public static SignInController getInstance(){
       if(instance == null){ 
          instance = new SignInController(); 
          instance.service = new SignInService();
        }
       
       return instance;
   }

}
