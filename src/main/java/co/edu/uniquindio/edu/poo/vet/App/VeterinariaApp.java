package co.edu.uniquindio.edu.poo.vet.App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VeterinariaApp extends Application {
//metodo que inicia la aplicacion
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/co/edu/uniquindio/edu/poo/vet/VeterinariaApp.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("VeterinariaApp");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}