package com.argentinaprograma.grupo5.tpintegrador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tecnico")

public class Tecnico {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String nombre;
private String apellido;
@ManyToMany
@JoinTable(
name = "tecnico_especialidad",
joinColumns = @JoinColumn(name = "id_tecnico"),
inverseJoinColumns = @JoinColumn(name = "id_especialidad"))
private List<Especialidad> especialidadList;
@OneToMany
@JoinColumn(name = "id_tecnico", referencedColumnName ="id")
private List<Incidente> incidenteList;
@OneToMany
@JoinColumn(name = "id_tecnico", referencedColumnName ="id")
private List<MedioComunicacion> medioComunicacionList;
   
}
