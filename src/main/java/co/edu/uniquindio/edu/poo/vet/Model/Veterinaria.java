package co.edu.uniquindio.edu.poo.vet.Model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Veterinaria {
    private String nombre;
    private String direccion;
    private LinkedList<HistoriaClinica> ListahistoriasClinicas;
    LinkedList<Mascota> listademascotasenclinica;
    LinkedList<Veterinario> veteriniosclinica;
    LinkedList<Propietario> propietariosdemascotas;
    LinkedList<PersonalApoyo> PersonalApoyo;
    LinkedList<AgendaCitaMedica> citas;

    //constructor de la clase Veterinaria
    public Veterinaria(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ListahistoriasClinicas = new LinkedList<>();
        this.veteriniosclinica = new LinkedList<>();
        this.propietariosdemascotas = new LinkedList<>();
        this.PersonalApoyo = new LinkedList<>();
        this.listademascotasenclinica = new LinkedList<>();
        this.citas = new LinkedList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LinkedList<AgendaCitaMedica> getCitas() {
        return citas;
    }

    public void setCitas(LinkedList<AgendaCitaMedica> citas) {
        this.citas = citas;
    }

    public LinkedList<PersonalApoyo> getPersonalApoyo() {
        return PersonalApoyo;
    }

    public void setPersonalApoyo(LinkedList<PersonalApoyo> personalApoyo) {
        PersonalApoyo = personalApoyo;
    }

    public LinkedList<Propietario> getPropietariosdemascotas() {
        return propietariosdemascotas;
    }

    public void setPropietariosdemascotas(LinkedList<Propietario> propietariosdemascotas) {
        this.propietariosdemascotas = propietariosdemascotas;
    }

    public LinkedList<Veterinario> getVeteriniosclinica() {
        return veteriniosclinica;
    }

    public void setVeteriniosclinica(LinkedList<Veterinario> veteriniosclinica) {
        this.veteriniosclinica = veteriniosclinica;
    }

    public LinkedList<Mascota> getListademascotasenclinica() {
        return listademascotasenclinica;
    }

    public void setListademascotasenclinica(LinkedList<Mascota> listademascotasenclinica) {
        this.listademascotasenclinica = listademascotasenclinica;
    }

    public LinkedList<HistoriaClinica> getListahistoriasClinicas() {
        return ListahistoriasClinicas;
    }

    public void setListahistoriasClinicas(LinkedList<HistoriaClinica> listahistoriasClinicas) {
        ListahistoriasClinicas = listahistoriasClinicas;
    }


    public boolean verificarPropietario(String idPropietario) {
        for (Propietario propietario : propietariosdemascotas) {
            if (propietario.getTelefono().equals(idPropietario)) {
                return false;
            }
        }
        return true;
    }


    public boolean verificarVeterianario(String idProfesional) {
        for (Veterinario veterinario : veteriniosclinica) {
            if (veterinario.getIdProfesional().equals(idProfesional)) {
                return false;
            }
        }
        return true;
    }


    public boolean registrarPropietario(Propietario propietario) {
        if (verificarPropietario(propietario.getIdPropietario())) {
            propietariosdemascotas.add(propietario);
            return true;
        }
        return false;
    }


    public boolean eliminarPropietario(String idPropietario) {
        for (Propietario propietario : propietariosdemascotas) {
            if (propietario.getTelefono().equals(idPropietario)) {
                propietariosdemascotas.remove(propietario);
                return true;
            }
        }
        return false;
    }


    public boolean registrarMascota(Mascota mascota) {
        for (Mascota NuevaMascota : listademascotasenclinica) {
            if (NuevaMascota.getId() == mascota.getId()) {
                return false;
            }
        }
        listademascotasenclinica.add(mascota);
        return true;
    }


    public boolean eliminarMascota(String idMascota) {
        for (Mascota mascota : listademascotasenclinica) {
            if (String.valueOf(mascota.getId()).equals(idMascota)) {
                listademascotasenclinica.remove(mascota);
                return true;
            }
        }
        return false;
    }


    public boolean registrarVeterinario(Veterinario veterinario) {
        if (verificarVeterianario(veterinario.getIdProfesional())) {
            veteriniosclinica.add(veterinario);
            return true;
        }
        return false;
    }

    public boolean eliminarVeterinario(String idVeterinario) {
        for (Veterinario veterinario : veteriniosclinica) {
            if (veterinario.getIdProfesional().equals(idVeterinario)) {
                veteriniosclinica.remove(veterinario);
                return true;
            }
        }
        return false;
    }


    public void asignarIdMascota() {
        for (Mascota mascota : listademascotasenclinica) {
            if (mascota.getId() == 0) {
                int idmascota;
                do {
                    idmascota = (int) (Math.random() * 9000000) + 1000000;
                } while (idYaExiste(idmascota));

                mascota.setId(idmascota);
                return;
            }
        }
    }


    public void agendarCita(AgendaCitaMedica cita) {
        citas.add(cita);
    }


    public List<AgendaCitaMedica> buscarCitaPorDia(LocalDate fechaBuscada) {
        List<AgendaCitaMedica> citaResultado = new LinkedList<>();
        for (AgendaCitaMedica cita : citas) {
            if (cita.getFecha().equals(fechaBuscada)) {
                citaResultado.add(cita);
            }
        }
        return citaResultado;
    }

    private boolean idYaExiste(int id) {
        for (Mascota mascota : listademascotasenclinica) {
            if (mascota.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public HistoriaClinica buscarHistoriaClinica(int idMascota) {
        for (HistoriaClinica historiaClinica : ListahistoriasClinicas) {
            if (historiaClinica.getMascota().getId() == idMascota) {
                return historiaClinica;
            }
        }
        return null;
    }

    public Mascota buscarMascota(int idMascota) {
        for (Mascota mascota : listademascotasenclinica) {
            if (mascota.getId() == idMascota) {
                return mascota;
            }
        }
        return null;

    }
    public void eliminarMascota(Mascota mascota) {
        listademascotasenclinica.remove(mascota);
    }
}