package co.edu.uniquindio.edu.poo.vet.ViewController;

import co.edu.uniquindio.edu.poo.vet.Model.AgendaCitaMedica;
import co.edu.uniquindio.edu.poo.vet.Model.Veterinario;
import co.edu.uniquindio.edu.poo.vet.Model.Veterinaria;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AgendarConsultaViewController {

    @FXML
    private DatePicker dateFecha;

    @FXML
    private TextField txtHora;

    @FXML
    private TextField txtMotivo;

    @FXML
    private ComboBox<Veterinario> comboVeterinario;

    @FXML
    private Button btnAgendar;

    @FXML
    private TableView<AgendaCitaMedica> tablaConsultas;

    @FXML
    private TableColumn<AgendaCitaMedica, LocalDate> colFecha;

    @FXML
    private TableColumn<AgendaCitaMedica, LocalTime> colHora;

    @FXML
    private TableColumn<AgendaCitaMedica, String> colMotivo;

    @FXML
    private TableColumn<AgendaCitaMedica, Veterinario> colVeterinario;


    private ObservableList<AgendaCitaMedica> listaConsultas;


    private Veterinaria veterinaria;

    @FXML
    public void initialize() {
        veterinaria = new Veterinaria("Mi Vet", "Calle 123");
        veterinaria.registrarVeterinario(new Veterinario("Juan", "Perez", "123456", "Calle 1", "VET001"));
        veterinaria.registrarVeterinario(new Veterinario("Ana", "Lopez", "987654", "Calle 2", "VET002"));


        comboVeterinario.setItems(FXCollections.observableArrayList(veterinaria.getVeteriniosclinica()));


        comboVeterinario.setConverter(new StringConverter<Veterinario>() {
            @Override
            public String toString(Veterinario vet) {
                return vet == null ? "" : vet.getNombre() + " " + vet.getApellido();
            }

            @Override
            public Veterinario fromString(String s) {
                return null;
            }
        });


        listaConsultas = FXCollections.observableArrayList();
        tablaConsultas.setItems(listaConsultas);


        colFecha.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFecha()));
        colHora.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getHora()));
        colMotivo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMotivoConsulta()));
        colVeterinario.setCellValueFactory(cellData -> {
            Veterinario vet = cellData.getValue().getListaVeterinarios().isEmpty() ? null : cellData.getValue().getListaVeterinarios().get(0);
            return new SimpleObjectProperty<>(vet);
        });


        colVeterinario.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Veterinario vet, boolean empty) {
                super.updateItem(vet, empty);
                if (empty || vet == null) {
                    setText("");
                } else {
                    setText(vet.getNombre() + " " + vet.getApellido());
                }
            }
        });


        btnAgendar.setOnAction(event -> agendarConsulta());
    }

    private void agendarConsulta() {
        LocalDate fecha = dateFecha.getValue();
        String horaStr = txtHora.getText();
        String motivo = txtMotivo.getText();
        Veterinario vetSeleccionado = comboVeterinario.getValue();

        if (fecha == null || horaStr.isEmpty() || motivo.isEmpty() || vetSeleccionado == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Debe completar todos los campos", ButtonType.OK);
            alert.showAndWait();
            return;
        }


        LocalTime hora;
        try {
            hora = LocalTime.parse(horaStr, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Formato de hora inválido. Use HH:mm", ButtonType.OK);
            alert.showAndWait();
            return;
        }


        AgendaCitaMedica nuevaConsulta = new AgendaCitaMedica(fecha, hora, motivo);
        nuevaConsulta.getListaVeterinarios().add(vetSeleccionado);
        veterinaria.agendarCita(nuevaConsulta);


        listaConsultas.add(nuevaConsulta);


        dateFecha.setValue(null);
        txtHora.clear();
        txtMotivo.clear();
        comboVeterinario.getSelectionModel().clearSelection();
    }
}