/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_cal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 179
 */
public class JavaFx_Cal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Button btn1 = new Button("Hello World!");
        StackPane Pane = new StackPane();
        Pane.getChildren().add(btn1);
        Scene scene = new Scene(Pane, 600, 400);
        stage.setTitle("Test JavaFX");
        stage.setScene(scene);
        stage.show();

    }

}
