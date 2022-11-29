package com.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
/*        Button btn = new Button("Say Hello World!");
        //btn.setText("Say Hello World!");
        btn.setOnAction(e -> {
                System.out.println("Hello World!");
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);*/
        Parent parent = FXMLLoader.load(getClass().getResource("view/first.fxml"));

        Scene scene = new Scene(parent, 300, 250);

        primaryStage.setTitle("Hello world!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
