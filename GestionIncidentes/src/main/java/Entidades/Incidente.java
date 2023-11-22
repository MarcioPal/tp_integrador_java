/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Enum.EstadoEnum;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "INCIDENTES")
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    @SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "Inc_seq")
    private Long id;
    private String consideraciones;
    private Date fechaIngreso;
    private Date fechaEstimadaResolucion;
    private Date fechaResolucion;
    private Cliente cliente;
    @OneToOne
    private Servicio servicio;
    private EstadoEnum estado;
    @ManyToMany
    private List<TipoProblema> problemas;
    @ManyToOne
    private Tecnico tecnico;
    
    
    
}
