package co.edu.uniquindio.edu.poo.vet.ViewController;

import co.edu.uniquindio.edu.poo.vet.Model.Mascota;
import co.edu.uniquindio.edu.poo.vet.Model.Veterinaria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class RegistrarMascotaViewController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEspecie;

    @FXML
    private TextField txtRaza;

    @FXML
    private TextField txtEdad;

    @FXML
    private Button btnRegistrarMascota;

    @FXML
    private TableView<Mascota> tablaMascotas;

    @FXML
    private TableColumn<Mascota, String> colNombre;
    @FXML
    private TableColumn<Mascota, String> colEspecie;
    @FXML
    private TableColumn<Mascota, String> colRaza;
    @FXML
    private TableColumn<Mascota, Integer> colEdad;
    @FXML
    private TableColumn<Mascota, Integer> colId;

    private ObservableList<Mascota> listaObservableMascotas;


    private Veterinaria veterinaria = new Veterinaria("MiVeterinaria", "Calle Falsa 123");

    @FXML
    public void initialize() {

        listaObservableMascotas = FXCollections.observableArrayList();
        tablaMascotas.setItems(listaObservableMascotas);


        colNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));
        colEspecie.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEspecie()));
        colRaza.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRaza()));
        colEdad.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getEdad()).asObject());
        colId.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());

        btnRegistrarMascota.setOnAction(event -> OnregistrarMascota());
    }

    @FXML
    private void OnregistrarMascota() {
        try {
            String nombre = txtNombre.getText();
            String especie = txtEspecie.getText();
            String raza = txtRaza.getText();
            int edad = Integer.parseInt(txtEdad.getText());

            Mascota mascota = new Mascota(nombre, especie, raza, edad, 0);
            veterinaria.registrarMascota(mascota);
            veterinaria.asignarIdMascota(); // Asigna un ID único

            // Actualizamos la tabla
            listaObservableMascotas.setAll(veterinaria.getListademascotasenclinica());

            // Limpiar campos
            txtNombre.clear();
            txtEspecie.clear();
            txtRaza.clear();
            txtEdad.clear();
        } catch (NumberFormatException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Ingrese un número válido para la edad", ButtonType.OK);
            alerta.show();
        }
    }
}