/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "CLIENTES")
public class Cliente implements Serializable{
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
   @SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "Cli_seq")
   private Long id;
   @Column(unique=true)
   private Long cuit;
   @Column(unique=true)
   private String razonSoc;
   @ManyToMany
   @JoinTable(name = "cliente_servicio",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id"))       
   List<Servicio> servicios;
   private String email;
}
