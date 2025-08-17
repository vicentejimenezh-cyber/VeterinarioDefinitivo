package co.edu.uniquindio.edu.poo.vet.ViewController;

import co.edu.uniquindio.edu.poo.vet.Utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class VeterinariaAppViewController {

    @FXML
    private Button btnPersonalApoyo;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnVeterinario;

    @FXML
    private Label welcomeText;

    @FXML
    void OnPersonalApoyo(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "PersonalApoyo.fxml");    }

    @FXML
    void OnSalir(ActionEvent event)
    {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void OnVeterinario(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "Veterinario.fxml");

    }

}
