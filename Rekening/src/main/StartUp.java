package main;

import domein.DomeinController;
import gui.HoofdPaneel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//public class StartUp {
//
//    public static void main(String[] args) {
//        new RekeningApplicatie(new DomeinController()).werkMetRekeningen();
//        new KostenApplicatie(new DomeinController()).werkMetKosten();
//    }
//
//}

public class StartUp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        DomeinController controller = new DomeinController();
        HoofdPaneel root = new HoofdPaneel(controller);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Rekeningen");
        stage.show();
    }
}
