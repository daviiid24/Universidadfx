module co.edu.uniquindio.universidadfx.universidadfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.universidadfx to javafx.fxml;
    opens co.edu.uniquindio.universidadfx.viewcontroller;


    exports co.edu.uniquindio.universidadfx;
    exports co.edu.uniquindio.universidadfx.model;
    exports co.edu.uniquindio.universidadfx.factory;
    exports co.edu.uniquindio.universidadfx.viewcontroller;
}