package co.edu.uniquindio.edu.poo.vet.ViewController;

import co.edu.uniquindio.edu.poo.vet.Utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class PersonalApoyoViewController {

    @FXML
    private Button btnRegistrarVeterinario;

    @FXML
    private Button btnRegistrarMascota;

    @FXML
    private Button btnRegistrarPropietario;

    @FXML
    private Button btnAgendarConsulta;

    @FXML
    private Button btnSalir;


    @FXML
    void OnVolve(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "VeterinariaApp.fxml");

    }

    @FXML
    void OnRegistrarVeterinario(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "RegistrarVeterinario.fxml");

    }

    @FXML
    void OnRegistrarMascota(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "RegistrarMascota.fxml");

    }
    @FXML
    void OnRegistrarPropietario(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "AgregarPropietario.fxml");

    }

    @FXML
    void OnAgendarConsulta(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "AgendarConsulta.fxml");

    }

    @FXML
    void OnSalir(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "VeterinariaApp.fxml");

    }

}