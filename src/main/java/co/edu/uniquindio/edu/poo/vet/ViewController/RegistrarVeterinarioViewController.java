package co.edu.uniquindio.edu.poo.vet.ViewController;

import co.edu.uniquindio.edu.poo.vet.Model.Veterinaria;
import co.edu.uniquindio.edu.poo.vet.Model.Veterinario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistrarVeterinarioViewController {

    @FXML private TableView<Veterinario> tablaVeterinarios;
    @FXML private TableColumn<Veterinario, String> colNombre;
    @FXML private TableColumn<Veterinario, String> colApellido;
    @FXML private TableColumn<Veterinario, String> colTelefono;
    @FXML private TableColumn<Veterinario, String> colDireccion;
    @FXML private TableColumn<Veterinario, String> colIdProfesional;


    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtIdProfesional;

    @FXML private Button btnRegistrarVeterinario;

    private ObservableList<Veterinario> listaVeterinarios = FXCollections.observableArrayList();
    private Veterinaria veterinaria = new Veterinaria("Veterinaria Ejemplo", "Calle Falsa 123");

    @FXML
    public void initialize() {

        colNombre.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        colApellido.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getApellido()));
        colTelefono.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTelefono()));
        colDireccion.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDireccion()));
        colIdProfesional.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getIdProfesional()));

        tablaVeterinarios.setItems(listaVeterinarios);

        // Acción del botón
        btnRegistrarVeterinario.setOnAction(event -> OnRegistrarVeterinar());
    }

    @FXML
    private void OnRegistrarVeterinar() {        // Tomar datos de los TextField
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();
        String idProfesional = txtIdProfesional.getText();


        Veterinario veterinario = new Veterinario(nombre, apellido, telefono, direccion, idProfesional);


        veterinaria.registrarVeterinario(veterinario);


        listaVeterinarios.add(veterinario);


        txtNombre.clear();
        txtApellido.clear();
        txtTelefono.clear();
        txtDireccion.clear();
        txtIdProfesional.clear();
    }
}