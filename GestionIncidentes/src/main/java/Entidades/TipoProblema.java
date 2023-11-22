/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TIPOS_DE_PROBLEMA")
public class TipoProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    @SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "tip_seq")
    private Long id;
    @Column(unique=true)
    private String nombre;
    private int tiempoEstimadoHoras;
    private int tiempoMaximoHoras;
    @ManyToMany
    private List<Especialidad> especialidades; 
}
