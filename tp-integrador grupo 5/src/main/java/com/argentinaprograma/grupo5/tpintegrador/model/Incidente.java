package com.argentinaprograma.grupo5.tpintegrador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "incidente")

public class Incidente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String titulo;
private String descripcion;
private LocalDate fechaIngreso;
private LocalDate fechaEstimadaResolucion;
private LocalDate fechaResolucion;
private EstadoEnum estado;
private String consideraciones;
@ManyToMany
@JoinTable(
name = "incidente_tipoProblema",
joinColumns = @JoinColumn(name = "id_incidente"),
inverseJoinColumns = @JoinColumn(name = "id_tipoProblema"))
private List<TipoProblema> tipoProblemaList;
@ManyToOne
@JoinColumn(name = "id_cliente", referencedColumnName ="id")
 private Cliente cliente;
@ManyToOne
@JoinColumn(name = "id_servicio", referencedColumnName ="id")
 private Servicio servicio;
// Interpreto del enunciado que un incidente solo se relaciona con una especialidad
@ManyToOne
@JoinColumn(name = "id_especialidad", referencedColumnName ="id")
 private Especialidad especialidad;

}
