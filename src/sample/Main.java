package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

//        Parent root = FXMLLoader.load(getClass().getResource("main_window.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main_window.fxml"));
        primaryStage.setTitle("Tanga Library");
        primaryStage.setScene(new Scene(fxmlLoader.load(), 1000, 700));
        MainWindowController mainWindowController = fxmlLoader.getController();
        mainWindowController.getStage(primaryStage);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
