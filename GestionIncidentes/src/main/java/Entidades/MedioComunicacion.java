/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "MEDIOS_DE_COMUNICACION")
public class MedioComunicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
   @SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "Med_seq")
    private Long id;
    @Column(unique=true)
    private String nombre;
    private String contacto;
}
