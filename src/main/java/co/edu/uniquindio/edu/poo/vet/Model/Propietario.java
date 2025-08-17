package co.edu.uniquindio.edu.poo.vet.Model;

import java.util.LinkedList;

public class Propietario extends Persona    {
    LinkedList<Mascota>mascotaspropias;
    private String idPropietario;

    public Propietario(String nombre, String apellido, String telefono, String direccion, String idPropietario) {
        super(nombre, apellido, telefono, direccion);
        this.mascotaspropias=new LinkedList<>();
        this.idPropietario = idPropietario;

    }
    public LinkedList getMascotasPropias() {
        return mascotaspropias;
    }

    public void setMascotaspropias(LinkedList<Mascota> mascotaspropias) {
        this.mascotaspropias = mascotaspropias;
    }

    public LinkedList<Mascota> getMascotaspropias() {
        return mascotaspropias;
    }

    public String getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }

}
