package com.argentinaprograma.grupo5.tpintegrador.services;

import com.argentinaprograma.grupo5.tpintegrador.model.EstadoEnum;
import com.argentinaprograma.grupo5.tpintegrador.model.Tecnico;
import com.argentinaprograma.grupo5.tpintegrador.model.Incidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argentinaprograma.grupo5.tpintegrador.repositories.TecnicoRepository;
import jakarta.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import com.argentinaprograma.grupo5.tpintegrador.model.Especialidad;

@Service
@Transactional
public class TecnicoService {

    TecnicoRepository tecnicoRepository;

    @Autowired

    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public int guardar(Tecnico t) {
        return this.tecnicoRepository.save(t).getId();

    }

    public Tecnico obtenerTecnicoPorId(Integer id) {
        return this.tecnicoRepository.findById(id).get();
    }

    public List<Tecnico> buscarTodos() {
        return tecnicoRepository.findAll();
    }

    public int buscarIdTecnicoConMasIncidencias(int n) {
        LocalDate fechaHoy = LocalDate.now();
        //Traigo las listas de tecnicos
        List<Tecnico> listaTecnicos = tecnicoRepository.findAll();
        //Genero variables intermedias para ir almacenando el Id del tecnico ganador y el nro de incidentes resueltos máximo
        int tecnicoIdGanador = -1;
        int incidentesResueltosMax = 0;
        // con un for, recorremos todos los Tecnicos
        for (Tecnico iteraTecnico : listaTecnicos) {
            //Genero una variable intermedia para almacenar los incidentes resueltos de cada tecnico
            int incidentesResueltos = 0;
            //con un for recorremos todos los incidentes asociados al técnico
            for (Incidente iteraIncidente : iteraTecnico.getIncidenteList()) {
            //con el objeto Duration obtengo la diferencia entre hoy y la fecha de resolucion    
                Duration diff = Duration.between(iteraIncidente.getFechaResolucion().atStartOfDay(), fechaHoy.atStartOfDay());
                long diffDias = diff.toDays();
                // solo se tienen en cuenta los incidentes Resueltos y resueltos en los últimos n días
                // utilizo un contador para ir guardando los incidentes resueltos del técnico
                if ((iteraIncidente.getEstado() == EstadoEnum.FINALIZADO) && (diffDias <= n)) {
                    incidentesResueltos = incidentesResueltos + 1;
                }
            }
            // Si el técnico tiene más incidentes resueltos que el Máximo almacenado, entonces modififo el Máximo almacenado y el ID tecnico ganador
            if (incidentesResueltos > incidentesResueltosMax) {
                tecnicoIdGanador = iteraTecnico.getId();
                incidentesResueltosMax = incidentesResueltos;
            }
        }
        return tecnicoIdGanador;
    }

    
  // La lógica del siguiente método es igual a la anterior con la diferencia de que se filtra la lista de incidentes por Especialidad, usando Steam.Filter
    public int buscarIdTecnicoConMasIncidenciasEspecialidad(int n, Especialidad e) {
        LocalDate fechaHoy = LocalDate.now();
        List<Tecnico> listaTecnicos = tecnicoRepository.findAll();
        int tecnicoIdGanador = -1;
        int incidentesResueltosMax = 0;
        for (Tecnico iteraTecnico : listaTecnicos) {
            int incidentesResueltos = 0;
            List<Incidente> listaFiltrada = (List<Incidente>) iteraTecnico.getIncidenteList().stream()
                    .filter(c -> c.getEspecialidad().getNombre().equals(e.getNombre()))
                    .collect(Collectors.toList());
            for (Incidente iteraIncidente : listaFiltrada) {
                Duration diff = Duration.between(iteraIncidente.getFechaResolucion().atStartOfDay(), fechaHoy.atStartOfDay());
                long diffDias = diff.toDays();
                if ((iteraIncidente.getEstado() == EstadoEnum.FINALIZADO) && (diffDias <= n)) {
                    incidentesResueltos = incidentesResueltos + 1;
                }
            }
            if (incidentesResueltos > incidentesResueltosMax) {
                tecnicoIdGanador = iteraTecnico.getId();
                incidentesResueltosMax = incidentesResueltos;
            }
        }
        return tecnicoIdGanador;
    }

    public int buscarIdTecnicoMasRapido() {
        //genero la lista de técnicos
        List<Tecnico> listaTecnicos = tecnicoRepository.findAll();
        //variables intermedias
        int tecnicoIdGanador = -1;
        int tiempoMinimo = 99999;
        for (Tecnico iteraTecnico : listaTecnicos) {
            for (Incidente iteraIncidente : iteraTecnico.getIncidenteList()) {
                if (iteraIncidente.getEstado() == EstadoEnum.FINALIZADO) {
                    Duration diff = Duration.between(iteraIncidente.getFechaIngreso().atStartOfDay(), iteraIncidente.getFechaResolucion().atStartOfDay());
                    long diffDias = diff.toDays();
                    if (diffDias <= tiempoMinimo) {
                      tiempoMinimo = (int) diffDias;
                      tecnicoIdGanador = iteraTecnico.getId();
                    }
                }
            }
        }
            return tecnicoIdGanador;
        }
    }
