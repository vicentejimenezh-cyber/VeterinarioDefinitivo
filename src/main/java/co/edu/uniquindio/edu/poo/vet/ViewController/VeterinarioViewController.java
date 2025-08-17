package co.edu.uniquindio.edu.poo.vet.ViewController;

import co.edu.uniquindio.edu.poo.vet.Utils.SceneManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import co.edu.uniquindio.edu.poo.vet.Model.ConsultaMedica;
import co.edu.uniquindio.edu.poo.vet.Model.AgendaCitaMedica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class VeterinarioViewController {

    @FXML
    private TableView<ConsultaMedica> tablaHistorial;
    @FXML
    private TableColumn<ConsultaMedica, String> colFecha;
    @FXML
    private TableColumn<ConsultaMedica, String> colDiagnostico;
    @FXML
    private TableColumn<ConsultaMedica, String> colTratamiento;

    @FXML
    private TableView<AgendaCitaMedica> tablaCitas;
    @FXML
    private TableColumn<AgendaCitaMedica, String> colMascota;
    @FXML
    private TableColumn<AgendaCitaMedica, String> colPropietario;
    @FXML
    private TableColumn<AgendaCitaMedica, String> colFechaCita;
    @FXML
    private TableColumn<AgendaCitaMedica, String> colHoraCita;
    @FXML
    private TableColumn<AgendaCitaMedica, String> colMotivo;

    private ObservableList<ConsultaMedica> listaConsultas = FXCollections.observableArrayList();
    private ObservableList<AgendaCitaMedica> listaCitas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Inicializar columnas Historial
        colFecha.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getAgendacitamedica().getFecha().toString()));
        colDiagnostico.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDiagnostico()));
        colTratamiento.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getTratamiento()));

        tablaHistorial.setItems(listaConsultas);

        // Inicializar columnas Citas
        colMascota.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getListaVeterinarios().isEmpty() ? "" : "Mascota"));
        colPropietario.setCellValueFactory(data ->
                new SimpleStringProperty("Propietario")); // Ajustar según modelo real
        colFechaCita.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getFecha().toString()));
        colHoraCita.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getHora().toString()));
        colMotivo.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getMotivoConsulta()));

        tablaCitas.setItems(listaCitas);
    }

    public void agregarConsulta(ConsultaMedica c) {
        listaConsultas.add(c);
    }

    public void agregarCita(AgendaCitaMedica c) {
        listaCitas.add(c);
    }


    @FXML
    void OnVolver(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneManager.cambiarEscena(stage, "VeterinariaApp.fxml");

    }
}

