package com.argentinaprograma.grupo5.tpintegrador;

// Trabajo Integrador - Argentina Programa 4.0 - Java Intermedio
// Grupo 5: Integrantes: Gustavo Montell, Marcio Palazzo, Claudio Ledesma

import java.util.ArrayList;
import java.util.List;
import com.argentinaprograma.grupo5.tpintegrador.model.Cliente;
import com.argentinaprograma.grupo5.tpintegrador.model.Especialidad;
import com.argentinaprograma.grupo5.tpintegrador.model.EstadoEnum;
import com.argentinaprograma.grupo5.tpintegrador.model.Incidente;
import com.argentinaprograma.grupo5.tpintegrador.model.MedioComunicacion;
import com.argentinaprograma.grupo5.tpintegrador.model.MedioEnum;
import com.argentinaprograma.grupo5.tpintegrador.model.Servicio;
import com.argentinaprograma.grupo5.tpintegrador.model.TipoProblema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.argentinaprograma.grupo5.tpintegrador.model.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import com.argentinaprograma.grupo5.tpintegrador.services.ClienteService;
import com.argentinaprograma.grupo5.tpintegrador.services.EspecialidadService;
import com.argentinaprograma.grupo5.tpintegrador.services.IncidenteService;
import com.argentinaprograma.grupo5.tpintegrador.services.MedioComunicacionService;
import com.argentinaprograma.grupo5.tpintegrador.services.ServicioService;
import com.argentinaprograma.grupo5.tpintegrador.services.TecnicoService;
import com.argentinaprograma.grupo5.tpintegrador.services.TipoProblemaService;
import java.time.LocalDate;


@SpringBootApplication

public class Main {
private static TecnicoService tecnicoService;
private static ServicioService servicioService;
private static IncidenteService incidenteService;
private static EspecialidadService especialidadService;
private static TipoProblemaService tipoProblemaService;
private static MedioComunicacionService medioComunicacionService;
private static ClienteService clienteService;

@Autowired

public Main(TecnicoService tecnicoService, ServicioService servicioService, IncidenteService incidenteService, EspecialidadService especialidadService, TipoProblemaService tipoProblemaService, MedioComunicacionService medioComunicacionService, ClienteService clienteService) {
    this.tecnicoService = tecnicoService;
    this.servicioService = servicioService;
    this.incidenteService = incidenteService;
    this.especialidadService = especialidadService;
    this.tipoProblemaService = tipoProblemaService;
    this.medioComunicacionService = medioComunicacionService;
    this.clienteService = clienteService;
    }
            
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

//Cargo servicios
Servicio s1 = new Servicio(1, "SAP", "Sistema de gestión");   s1.setId(servicioService.guardar(s1));
Servicio s2 = new Servicio(2, "Tango", "Sistema contable");   s2.setId(servicioService.guardar(s2));
Servicio s3 = new Servicio(3, "Bejerman", "Sistema contable"); s3.setId(servicioService.guardar(s3));
Servicio s4 = new Servicio(4, "Windows", "Sistema Operativo"); s4.setId(servicioService.guardar(s4));
Servicio s5 = new Servicio(5, "MacOs", "Sistema Operativo"); s5.setId(servicioService.guardar(s5));
Servicio s6 = new Servicio(6, "Linux", "Sistema Operativo"); s6.setId(servicioService.guardar(s6));

//Cargo especialidades
Especialidad e1 = new Especialidad (1, "Optimización", "Rendimiento/performance/almacenamiento"); e1.setId(especialidadService.guardar(e1));
Especialidad e2 = new Especialidad (2, "Redes", "Conexión/internet"); e2.setId(especialidadService.guardar(e2));
Especialidad e3 = new Especialidad (3, "CiberSeguridad", "Firewalls/Protección Datos"); e3.setId(especialidadService.guardar(e3));
Especialidad e4 = new Especialidad (4, "Software", "Instalación/Configuración"); e4.setId(especialidadService.guardar(e4));

//Cargo tipos de problema
List<Especialidad> listaE1 = new ArrayList<>();
listaE1.add(e1);
listaE1.add(e4);
TipoProblema tp1 = new TipoProblema(1,"Performance", 10, 15, listaE1); 
tp1.setId(tipoProblemaService.guardar(tp1));
List<Especialidad> listaE2 = new ArrayList<>();
listaE2.add(e2);
listaE2.add(e3);
listaE2.add(e4);
TipoProblema tp2 = new TipoProblema(2,"Conexión", 5, 7, listaE2);
tp2.setId(tipoProblemaService.guardar(tp2));
List<Especialidad> listaE3 = new ArrayList<>();
listaE3.add(e2);
listaE3.add(e3);
TipoProblema tp3 = new TipoProblema(3,"Seguridad", 8, 12, listaE3); 
tp3.setId(tipoProblemaService.guardar(tp3));
List<Especialidad> listaE4 = new ArrayList<>();
listaE4.add(e4);
listaE4.add(e2);
TipoProblema tp4 = new TipoProblema(4,"Aplicaciones", 10, 15, listaE4);
tp4.setId(tipoProblemaService.guardar(tp4));

//Cargo Clientes
List<Servicio> listaS1 = new ArrayList<>();
listaS1.add(s1);
listaS1.add(s4);
Cliente c1 = new Cliente(1, 307316985, "Bunge S.A", "Federico", "Peralta", "fperalta@bungesa.com", listaS1); 
c1.setId(clienteService.guardar(c1));
List<Servicio> listaS2 = new ArrayList<>();
listaS2.add(s2);
listaS2.add(s5);
Cliente c2 = new Cliente(2, 307352295, "TotalGas S.A", "Luciana", "Mendoza", "lmendoza@totalgassa.com", listaS2); 
c2.setId(clienteService.guardar(c2));
List<Servicio> listaS3 = new ArrayList<>();
listaS3.add(s3);
listaS3.add(s6);
Cliente c3 = new Cliente(3, 276981257, "Discover SRL", "Gerardo", "Barsanti", "gbarsanti@discoversrl.com", listaS3); 
c3.setId(clienteService.guardar(c3));

//Cargo Incidentes
List<TipoProblema> listaTp1 = new ArrayList<>();
listaTp1.add(tp1);
listaTp1.add(tp4);
LocalDate date1a = LocalDate.of(2023, 11, 15);
LocalDate date1b = LocalDate.of(2023, 11, 30);
LocalDate date1fin = LocalDate.of(2023, 11, 22);
Incidente inc1 = new Incidente(1, "Anda lento", "Las funciones tardan mucho", date1a, date1b, date1fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e4); 
inc1.setId(incidenteService.guardar(inc1));
LocalDate date2fin = LocalDate.of(2023, 11, 22);
Incidente inc2 = new Incidente(2, "Se congela", "Se congela al arrancar", date1a, date1b, date2fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e4); 
inc2.setId(incidenteService.guardar(inc2));
LocalDate date3fin = LocalDate.of(2023, 11, 22);
Incidente inc3 = new Incidente(3, "No abre", "No abre el programa", date1a, date1b, date3fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e4);
inc3.setId(incidenteService.guardar(inc3));
LocalDate date4fin = LocalDate.of(2023, 11, 16);
Incidente inc4 = new Incidente(4, "Se tilda", "Se tilda la pantalla", date1a, date1b, date4fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc4.setId(incidenteService.guardar(inc4));
LocalDate date5fin = LocalDate.of(2023, 11, 22);
Incidente inc5 = new Incidente(5, "Pantalla azul", "La pantalla se pone azul", date1a, date1b, date5fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc5.setId(incidenteService.guardar(inc5));
LocalDate date6fin = LocalDate.of(2023, 11, 22);
Incidente inc6 = new Incidente(6, "Error intermitente", "Se cierra solo", date1a, date1b, date6fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc6.setId(incidenteService.guardar(inc6));
LocalDate date7fin = LocalDate.of(2023, 11, 22);
Incidente inc7 = new Incidente(7, "Anda lento", "Las funciones tardan mucho", date1a, date1b, date7fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc7.setId(incidenteService.guardar(inc7));
LocalDate date8fin = LocalDate.of(2023, 11, 22);
Incidente inc8 = new Incidente(8, "Es muy lento", "Los procesos demoran varios min", date1a, date1b, date8fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc8.setId(incidenteService.guardar(inc8));
LocalDate date9fin = LocalDate.of(2023, 11, 22);
Incidente inc9 = new Incidente(9, "Anda lento", "Las funciones tardan mucho", date1a, date1b, date9fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc9.setId(incidenteService.guardar(inc9));
LocalDate date10fin = LocalDate.of(2023, 11, 22);
Incidente inc10 = new Incidente(10, "Anda lento", "Las funciones tardan mucho", date1a, date1b, date1fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc10.setId(incidenteService.guardar(inc10));
Incidente inc11 = new Incidente(11, "Anda lento", "Las funciones tardan mucho", date1a, date1b, date1fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc11.setId(incidenteService.guardar(inc11));
Incidente inc12 = new Incidente(12, "Anda lento", "Las funciones tardan mucho", date1a, date1b, date1fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc12.setId(incidenteService.guardar(inc12));
Incidente inc13 = new Incidente(13, "Anda lento", "Las funciones tardan mucho", date1a, date1b, date1fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc13.setId(incidenteService.guardar(inc13));
Incidente inc14 = new Incidente(14, "Anda lento", "Las funciones tardan mucho", date1a, date1b, date1fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc14.setId(incidenteService.guardar(inc14));
Incidente inc15 = new Incidente(15, "Anda lento", "Las funciones tardan mucho", date1a, date1b, date1fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc15.setId(incidenteService.guardar(inc15));
Incidente inc16 = new Incidente(16, "Anda lento", "Las funciones tardan mucho", date1a, date1b, date1fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc16.setId(incidenteService.guardar(inc16));
Incidente inc17 = new Incidente(17, "Anda lento", "Las funciones tardan mucho", date1a, date1b, date1fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc17.setId(incidenteService.guardar(inc17));
Incidente inc18 = new Incidente(18, "Anda lento", "Las funciones tardan mucho", date1a, date1b, date1fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc18.setId(incidenteService.guardar(inc18));
Incidente inc19 = new Incidente(19, "Anda lento", "Las funciones tardan mucho", date1a, date1b, date1fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc19.setId(incidenteService.guardar(inc19));
Incidente inc20 = new Incidente(20, "Anda lento", "Las funciones tardan mucho", date1a, date1b, date10fin, EstadoEnum.FINALIZADO, "ninguna", listaTp1, c1, s1, e1);
inc20.setId(incidenteService.guardar(inc20));

//Cargo medios de comunicaciòn
MedioComunicacion mc1a = new MedioComunicacion(1, MedioEnum.EMAIL, "gustavob@yahoo.com"); mc1a.setId(medioComunicacionService.guardar(mc1a));
MedioComunicacion mc1b = new MedioComunicacion(2, MedioEnum.WHATSAPP, "1131594878"); mc1b.setId(medioComunicacionService.guardar(mc1b));
MedioComunicacion mc2a = new MedioComunicacion(3, MedioEnum.EMAIL, "marcelop@gmail.com");mc2a.setId(medioComunicacionService.guardar(mc2a));
MedioComunicacion mc2b = new MedioComunicacion(4, MedioEnum.WHATSAPP, "1141783154");mc2b.setId(medioComunicacionService.guardar(mc2b));
MedioComunicacion mc3a = new MedioComunicacion(5, MedioEnum.EMAIL, "florencias@hotmail.com");mc3a.setId(medioComunicacionService.guardar(mc3a));
MedioComunicacion mc3b = new MedioComunicacion(6, MedioEnum.WHATSAPP, "2252647848");mc3b.setId(medioComunicacionService.guardar(mc3b));
MedioComunicacion mc4a = new MedioComunicacion(7, MedioEnum.EMAIL, "priscilan@gmail.com");mc4a.setId(medioComunicacionService.guardar(mc4a));
MedioComunicacion mc4b = new MedioComunicacion(8, MedioEnum.WHATSAPP, "1144885123");mc4b.setId(medioComunicacionService.guardar(mc4b));
MedioComunicacion mc5a = new MedioComunicacion(9, MedioEnum.EMAIL, "danieln@yahoo.com");mc5a.setId(medioComunicacionService.guardar(mc5a));
MedioComunicacion mc5b = new MedioComunicacion(10, MedioEnum.WHATSAPP, "3391215487");mc5b.setId(medioComunicacionService.guardar(mc5b));
MedioComunicacion mc6a = new MedioComunicacion(11, MedioEnum.EMAIL, "robertob@gmail.com");mc6a.setId(medioComunicacionService.guardar(mc6a));
MedioComunicacion mc6b = new MedioComunicacion(12, MedioEnum.WHATSAPP, "35424581598");mc6b.setId(medioComunicacionService.guardar(mc6b));

//Cargo técnicos
List<MedioComunicacion> listaMc1 = new ArrayList<>();
listaMc1.add(mc1a);
listaMc1.add(mc1b);
List<Incidente> listaInc1 = new ArrayList<>();
listaInc1.add(inc1);
listaInc1.add(inc2);
listaInc1.add(inc3);
Tecnico t1 = new Tecnico(1, "Gustavo", "Batista", listaE1, listaInc1, listaMc1);
t1.setId(tecnicoService.guardar(t1));
List<MedioComunicacion> listaMc2 = new ArrayList<>();
listaMc2.add(mc2a);
listaMc2.add(mc2b);
List<Incidente> listaInc2 = new ArrayList<>();
listaInc2.add(inc4);
listaInc2.add(inc5);
listaInc2.add(inc6);
Tecnico t2 = new Tecnico(2, "Marcelo", "Paiva", listaE1, listaInc2, listaMc2);
t2.setId(tecnicoService.guardar(t2));
List<MedioComunicacion> listaMc3 = new ArrayList<>();
listaMc3.add(mc3a);
listaMc3.add(mc3b);
List<Incidente> listaInc3 = new ArrayList<>();
listaInc3.add(inc7);
listaInc3.add(inc8);
listaInc3.add(inc9);
Tecnico t3 = new Tecnico(3, "Florencia", "Sanchez", listaE1, listaInc3, listaMc3);
t3.setId(tecnicoService.guardar(t3));
List<MedioComunicacion> listaMc4 = new ArrayList<>();
listaMc4.add(mc4a);
listaMc4.add(mc4b);
List<Incidente> listaInc4 = new ArrayList<>();
listaInc4.add(inc10);
listaInc4.add(inc11);
listaInc4.add(inc12);
Tecnico t4 = new Tecnico(4, "Priscila", "Neveleff", listaE1, listaInc4, listaMc4);
t4.setId(tecnicoService.guardar(t4));
List<MedioComunicacion> listaMc5 = new ArrayList<>();
listaMc5.add(mc5a);
listaMc5.add(mc5b);
List<Incidente> listaInc5 = new ArrayList<>();
listaInc5.add(inc13);
listaInc5.add(inc14);
listaInc5.add(inc15);
Tecnico t5 = new Tecnico(5, "Daniel", "Nuñez", listaE1, listaInc5, listaMc5);
t5.setId(tecnicoService.guardar(t5));
List<MedioComunicacion> listaMc6 = new ArrayList<>();
listaMc6.add(mc6a);
listaMc6.add(mc6b);
List<Incidente> listaInc6 = new ArrayList<>();
listaInc6.add(inc16);
listaInc6.add(inc17);
listaInc6.add(inc18);
listaInc6.add(inc19);
listaInc6.add(inc20);
Tecnico t6 = new Tecnico(6, "Roberto", "Burgos", listaE1, listaInc6, listaMc6);
t6.setId(tecnicoService.guardar(t6));
//Fin Carga Objetos
 
// genero la variable que representa la cantidad de días y que pasaremos como parámetro
int n=10;
// llamo al método que busca el ID del técnico con mayor incidentes resueltas en los últimos n días y lo guardo en una variable
int idTecnicoMasIncidentes = tecnicoService.buscarIdTecnicoConMasIncidencias(n);
// Guardo en un String el Apellido y Nombre del técnico "ganador"
String tecnicoMasIncidentes = tecnicoService.obtenerTecnicoPorId(idTecnicoMasIncidentes).getApellido() + ", " + tecnicoService.obtenerTecnicoPorId(idTecnicoMasIncidentes).getNombre(); 

// llamo al método que busca el ID del técnico con mayor incidentes resueltas en los últimos n días por ESPECIALIDAD y lo guardo en una variable
int idTecnicoMasIncidentesEspecialidad = tecnicoService.buscarIdTecnicoConMasIncidenciasEspecialidad(n, e4);
// Guardo en un String el Apellido y Nombre del técnico "ganador"
String tecnicoMasIncidentesEspecialidad = tecnicoService.obtenerTecnicoPorId(idTecnicoMasIncidentesEspecialidad).getApellido() + ", " + tecnicoService.obtenerTecnicoPorId(idTecnicoMasIncidentesEspecialidad).getNombre(); 

// llamo al método que busca el ID del técnico más rápido en resolver un incidente y lo guardo en una variable
int idTecnicoMasRapido = tecnicoService.buscarIdTecnicoMasRapido();
// Guardo en un String el Apellido y Nombre del técnico "ganador"
String tecnicoMasRapido = tecnicoService.obtenerTecnicoPorId(idTecnicoMasRapido).getApellido() + ", " + tecnicoService.obtenerTecnicoPorId(idTecnicoMasRapido).getNombre(); 


//Se imprime en pantalla los resultados
System.out.println("El técnico con más incidentes resueltos en los últimos "+n+" días, es:");
System.out.println(tecnicoMasIncidentes);
System.out.println("El técnico con más incidentes resueltos, de la especialidad "+ e4.getNombre() + ", en los últimos "+n+" días, es:");
System.out.println(tecnicoMasIncidentesEspecialidad);
System.out.println("El técnico que más rápido resolvió un incidente es:");
System.out.println(tecnicoMasRapido);


	}

}
