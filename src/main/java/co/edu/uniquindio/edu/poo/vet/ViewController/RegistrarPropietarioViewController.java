package co.edu.uniquindio.edu.poo.vet.ViewController;

import co.edu.uniquindio.edu.poo.vet.Model.Propietario;
import co.edu.uniquindio.edu.poo.vet.Model.Veterinaria;
import co.edu.uniquindio.edu.poo.vet.Utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegistrarPropietarioViewController {

    @FXML private TableView<Propietario> tablaPropietarios;
    @FXML private TableColumn<Propietario, String> colIdPropietario;
    @FXML private TableColumn<Propietario, String> colNombre;
    @FXML private TableColumn<Propietario, String> colApellido;
    @FXML private TableColumn<Propietario, String> colTelefono;
    @FXML private TableColumn<Propietario, String> colDireccion;


    @FXML private TextField txtIdPropietario;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtDireccion;

    @FXML private Button btnRegistrarPropietario;
    /*@FXML private Button btnLimpiar;
    @FXML private Button btnSalir;
    */



    private ObservableList<Propietario> listaPropietarios = FXCollections.observableArrayList();
    private Veterinaria veterinaria = new Veterinaria("Veterinaria Ejemplo", "Calle Falsa 123");

    @FXML
    public void initialize() {

        colIdPropietario.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getIdPropietario()));
        colNombre.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        colApellido.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getApellido()));
        colTelefono.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTelefono()));
        colDireccion.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDireccion()));

        tablaPropietarios.setItems(listaPropietarios);

        // Acción del botón
        btnRegistrarPropietario.setOnAction(event -> OnRegistrarPropietario());
    }

    @FXML
    void OnVol(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "VeterinariaApp.fxml");

    }

    @FXML
    private void OnRegistrarPropietario() {
        String idPropietario = txtIdPropietario.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();





        Propietario propietario = new Propietario(nombre, apellido, telefono, direccion, idPropietario);


        veterinaria.registrarPropietario(propietario);


        listaPropietarios.add(propietario);

        txtNombre.clear();
        txtApellido.clear();
        txtTelefono.clear();
        txtDireccion.clear();
        txtIdPropietario.clear();

    }
}