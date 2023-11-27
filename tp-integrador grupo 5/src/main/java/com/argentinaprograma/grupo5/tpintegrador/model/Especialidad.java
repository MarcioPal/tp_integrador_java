package com.argentinaprograma.grupo5.tpintegrador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "especialidad")

public class Especialidad {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String nombre;
private String descripcion;
   
}
