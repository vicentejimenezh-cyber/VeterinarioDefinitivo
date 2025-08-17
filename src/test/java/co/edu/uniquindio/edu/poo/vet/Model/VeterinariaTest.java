package co.edu.uniquindio.edu.poo.vet.Model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
class VeterinariaTest {

    private Veterinaria veterinaria;
    private Propietario propietario;
    private Veterinario veterinario;
    private  Mascota mascota1;
    private Mascota mascota2;
    private Mascota mascota3;
    private AgendaCitaMedica cita;
    private HistoriaClinica historia1;
    private HistoriaClinica historia2;



    @BeforeEach
    void setUp() {



        veterinaria = new Veterinaria("Vet", "Calle 123");
        propietario = new Propietario("Juan", "Perez", "12345", "Calle Falsa", "12345");
        veterinario= new Veterinario("Ana", "Gomez", "67890", "Calle Verdadera", "67890");
        mascota1 = new Mascota("Firulais", "Perro", "Labrador", 5, 1234);
        mascota2 = new Mascota("Rex", "Perro", "Pastor", 3, 234);
        mascota3 = new Mascota("Mora", "Perro", "Pastor", 4, -1);
        cita = new AgendaCitaMedica(
                LocalDate.of(2023, 10, 15),
                LocalTime.of(10,30),
                "Chequeo general");

        historia1 = new HistoriaClinica(mascota1);
        historia2 = new HistoriaClinica(mascota2);

        veterinaria.getListahistoriasClinicas().add(historia1);
        veterinaria.getListahistoriasClinicas().add(historia2);
    }

    // Métodos de prueba para verificar el funcionamiento de la clase Veterinaria
    @Test
    void verificarPropietario() {
        assertTrue(veterinaria.verificarPropietario("12345") && veterinaria.verificarPropietario("67890"));

    }
// Verifica que el propietario existe en la lista de propietarios
    @Test
    void verificarVeterianario() {
        assertTrue(veterinaria.verificarVeterianario("12345")
                && veterinaria.verificarVeterianario("67890"));

    }

    //registra un propietario
    @Test
    void registrarPropietario() {
        assertTrue(veterinaria.registrarPropietario(propietario));
        assertFalse(veterinaria.registrarPropietario(propietario));
    }

    //VerifiCa que un propietario se elimine de la lista de propietarios

    @Test
    void eliminarPropietario() {
        veterinaria.registrarPropietario(propietario);
        assertTrue(veterinaria.eliminarPropietario("12345"));
        assertFalse(veterinaria.eliminarPropietario("67890"));
    }


// Verifica que una mascota se registre
    @Test
    void registrarMascota() {
        assertTrue(veterinaria.registrarMascota(mascota1));
        assertFalse(veterinaria.registrarMascota(mascota2));

    }


// Verifica que un veterinario se registre
    @Test
    void registrarVeterinario() {
        assertTrue(veterinaria.registrarVeterinario(veterinario));
        assertFalse(veterinaria.registrarVeterinario(veterinario));
    }

    //Verifica que un veterinario se elimine de la lista de veterinarios

    @Test
    void eliminarVeterinario() {
        veterinaria.registrarVeterinario(veterinario);
        assertTrue(veterinaria.eliminarVeterinario("67890"));
        assertFalse(veterinaria.eliminarVeterinario("12345"));
    }

    // Asigna un ID único a una mascota registrada

    @Test
    void asignarIdMascota() {
        veterinaria.registrarMascota(mascota3);
        mascota3.setId(0);
        veterinaria.asignarIdMascota();
        assertTrue(mascota3.getId() > 0);
    }

    @Test
    void agendarCita() {
        veterinaria.agendarCita(cita);
        assertTrue(veterinaria.buscarCitaPorDia(LocalDate.of(2023, 10, 15)).contains(cita));
    }

    //Busca una cita por dia

    @Test
    void buscarCitaPorDia() {
        veterinaria.agendarCita(cita); // O agendarCita(mascota1, propietario, veterinario, etc) según cómo definiste el método

        assertTrue(veterinaria.buscarCitaPorDia(LocalDate.of(2023, 10, 15)).contains(cita));
        assertFalse(veterinaria.buscarCitaPorDia(LocalDate.of(2023, 10, 16)).contains(cita));


    }




}