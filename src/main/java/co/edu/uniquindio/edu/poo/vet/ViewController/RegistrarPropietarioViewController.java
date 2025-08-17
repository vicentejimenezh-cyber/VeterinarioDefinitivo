package co.edu.uniquindio.edu.poo.vet.ViewController;

import co.edu.uniquindio.edu.poo.vet.Model.Propietario;
import co.edu.uniquindio.edu.poo.vet.Model.Veterinaria;
import co.edu.uniquindio.edu.poo.vet.Utils.SceneManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegistrarPropietarioViewController {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtDireccion;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnSalir;

    @FXML
    private TableView<Propietario> tablaPropietarios;

    @FXML
    private TableColumn<Propietario, String> colId;

    @FXML
    private TableColumn<Propietario, String> colNombre;

    @FXML
    private TableColumn<Propietario, String> colApellido;

    @FXML
    private TableColumn<Propietario, String> colTelefono;

    @FXML
    private TableColumn<Propietario, String> colDireccion;

    private ObservableList<Propietario> listaPropietarios;

    private Veterinaria veterinaria;

    @FXML
    void OnVol(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "VeterinariaApp.fxml");

    }
}