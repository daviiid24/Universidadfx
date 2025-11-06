package co.edu.uniquindio.universidadfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UniversidadApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UniversidadApp.class.getResource("universidadview.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("App Universidad");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}