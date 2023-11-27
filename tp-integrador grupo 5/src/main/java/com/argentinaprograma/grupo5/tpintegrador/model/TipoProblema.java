package com.argentinaprograma.grupo5.tpintegrador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipoProblema")

public class TipoProblema {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String tipo;
private int tiempoEstimado;
private int tiempoMaximo;
@ManyToMany
@JoinTable(
name = "tipoProblema_especialidad",
joinColumns = @JoinColumn(name = "id_tipoProblema"),
inverseJoinColumns = @JoinColumn(name = "id_especialidad"))
private List<Especialidad> especialidadList;
   
}
