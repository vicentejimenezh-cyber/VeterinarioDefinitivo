package co.edu.uniquindio.edu.poo.vet.Model;

public class Veterinario extends Persona{
    public String idProfesional;


    public Veterinario(String nombre, String apellido, String telefono, String direccion,String idProfesional) {
        super(nombre, apellido, telefono, direccion);

        this.idProfesional = idProfesional;

    }

    public String getIdProfesional() {
        return idProfesional;
    }
    public void setIdProfesional(String idProfesional) {
        this.idProfesional = idProfesional;
    }

}
