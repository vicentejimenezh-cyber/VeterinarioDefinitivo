module co.edu.uniquindio.edu.poo.vet {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires javafx.graphics;
    requires javafx.base;


    opens co.edu.uniquindio.edu.poo.vet to javafx.fxml;
    exports co.edu.uniquindio.edu.poo.vet;
    exports co.edu.uniquindio.edu.poo.vet.App;
    opens co.edu.uniquindio.edu.poo.vet.App to javafx.fxml;
    exports co.edu.uniquindio.edu.poo.vet.ViewController;
    opens co.edu.uniquindio.edu.poo.vet.ViewController to javafx.fxml;
}