package co.edu.uniquindio.edu.poo.vet.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class AgendaCitaMedica {
    private LocalDate fecha;
    private LocalTime hora;
    private String motivoConsulta;
    private LinkedList<Veterinario> listaVeterinarios;



    public AgendaCitaMedica(LocalDate fecha, LocalTime hora, String motivoConsulta) {
        this.fecha = fecha;
        this.hora = hora;
        this.motivoConsulta = motivoConsulta;
        this.listaVeterinarios = new LinkedList<>();

    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public String getMotivoConsulta() {
        return motivoConsulta;
    }
    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public LinkedList<Veterinario> getListaVeterinarios() {
        return listaVeterinarios;
    }
    public void setListaVeterinarios(LinkedList<Veterinario> listaVeterinarios) {
        this.listaVeterinarios = listaVeterinarios;
    }

}