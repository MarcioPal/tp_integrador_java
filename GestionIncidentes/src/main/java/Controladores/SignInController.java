/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Servicios.SignInService;

public class SignInController {
   private static SignInController instance;
   private SignInService service;
   
   private SignInController(){
       
   }
   
   //Este metodo deberia controlar a cual pantalla dirigirse segun el rol del usuario
   public void iniciarSesion(){
   
   }
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
