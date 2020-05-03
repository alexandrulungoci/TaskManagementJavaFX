package com.sda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Login extends Application {

    public static void main(String[] args) {
        Application.launch();
    }


    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = loadMainScene();
        stage.setScene(scene);
        stage.show();
    }

    public Scene loadMainScene() throws IOException {
        URL url = getClass().getClassLoader().getResource("mainMenu.fxml");
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        return scene;
    }


}
