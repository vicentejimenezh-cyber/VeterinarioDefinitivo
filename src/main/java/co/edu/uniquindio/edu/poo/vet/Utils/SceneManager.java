package co.edu.uniquindio.edu.poo.vet.Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    public static void cambiarEscena(Stage stage, String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/co/edu/uniquindio/edu/poo/vet/" + rutaFXML));
            System.out.println(loader.getLocation());
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cambiar de escena: " + e.getMessage());
        }
    }
}
