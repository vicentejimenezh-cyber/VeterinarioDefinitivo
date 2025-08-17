package co.edu.uniquindio.edu.poo.vet.Model;

import java.util.LinkedList;

public class HistoriaClinica {
    Mascota mascota;
    private LinkedList<ConsultaMedica>consultas;

    public HistoriaClinica(Mascota mascota) {
        this.mascota = mascota;
        this.consultas = new LinkedList<>();
    }
    public Mascota getMascota() {
        return mascota;
    }
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    public LinkedList<ConsultaMedica> getConsultas() {
        return consultas;
    }
    public void setConsultas(LinkedList<ConsultaMedica> consultas) {
        this.consultas = consultas;
    }
    public void agregarConsulta(ConsultaMedica consulta){
        consultas.add(consulta);
    }

}
