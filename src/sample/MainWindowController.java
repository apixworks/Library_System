package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWindowController {
    @FXML public HBox member_hbox, book_hbox, dashboard_hbox;
    @FXML public Label member_label, book_label, dashboard_label;
    @FXML public ImageView member_image, book_image, dashboard_image;
    @FXML public BorderPane borderPane;
    @FXML public TextField searchView;

    @FXML public VBox profile_box;

    private String current;
    private ArrayList<HBox> hBoxes;
    private ArrayList<Label> labels;

    Stage stage;

    public void dashboardClick(){
        current = "dashboard";
        stateChanger();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            borderPane.setCenter(fxmlLoader.load());
            DashboardController dashboardController = fxmlLoader.getController();
            dashboardController.getStage(stage,profile_box);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void memberClick(){
        current = "members";
        stateChanger();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("membership_management.fxml"));
            borderPane.setCenter(fxmlLoader.load());
            MembershipManagementController membershipManagementController = fxmlLoader.getController();
            membershipManagementController.getSearchView(searchView);
            membershipManagementController.getStage(stage,profile_box);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bookClick(){
        current = "books";
        stateChanger();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("book_management.fxml"));
            borderPane.setCenter(fxmlLoader.load());
            BooksManagementController booksManagementController = fxmlLoader.getController();
            booksManagementController.getSearchView(searchView);
            booksManagementController.getStage(stage,profile_box);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stateChanger(){
        if(current.equals("members")){
            clickedEffect(member_hbox,member_label);

            hBoxes = new ArrayList<>();
            hBoxes.add(book_hbox);
            hBoxes.add(dashboard_hbox);

            labels = new ArrayList<>();
            labels.add(book_label);
            labels.add(dashboard_label);

            member_image.setImage(new Image(Main.class.getResourceAsStream("icons/account-white.png")));

            unclickedEffect(hBoxes,labels);

        }else if(current.equals("books")){
            clickedEffect(book_hbox, book_label);

            hBoxes = new ArrayList<>();
            hBoxes.add(member_hbox);
            hBoxes.add(dashboard_hbox);

            labels = new ArrayList<>();
            labels.add(member_label);
            labels.add(dashboard_label);

            book_image.setImage(new Image(Main.class.getResourceAsStream("icons/library-books-white.png")));

            unclickedEffect(hBoxes,labels);

        }else if(current.equals("dashboard")){
            clickedEffect(dashboard_hbox, dashboard_label);

            hBoxes = new ArrayList<>();
            hBoxes.add(member_hbox);
            hBoxes.add(book_hbox);

            labels = new ArrayList<>();
            labels.add(member_label);
            labels.add(book_label);

            unclickedEffect(hBoxes,labels);

            dashboard_image.setImage(new Image(Main.class.getResourceAsStream("icons/dashboard-white.png")));

        }
    }

    private void clickedEffect(HBox hBox, Label label){
        label.setTextFill(Color.rgb(255,255,255));
        hBox.setStyle("-fx-background-radius:5px; -fx-background-color:  #1BBED2;");
        hBox.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.rgb(0, 0, 0, 0.23), 10, 0, 0, 3));
    }

    private void unclickedEffect(ArrayList<HBox> hBoxes,ArrayList<Label> labels){
        for(HBox hBox : hBoxes){
            hBox.setStyle(null);
            hBox.setEffect(null);
        }
        for(Label label: labels){
            label.setTextFill(Color.rgb(94,99,107));
        }
        if(current.equals("members")){
            book_image.setImage(new Image(Main.class.getResourceAsStream("icons/library-books.png")));
            dashboard_image.setImage(new Image(Main.class.getResourceAsStream("icons/dashboard.png")));
        }else if(current.equals("books")){
            member_image.setImage(new Image(Main.class.getResourceAsStream("icons/account.png")));
            dashboard_image.setImage(new Image(Main.class.getResourceAsStream("icons/dashboard.png")));
        }else if(current.equals("dashboard")){
            book_image.setImage(new Image(Main.class.getResourceAsStream("icons/library-books.png")));
            member_image.setImage(new Image(Main.class.getResourceAsStream("icons/account.png")));
        }
    }

    public void getStage(Stage stage){
        this.stage = stage;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            borderPane.setCenter(fxmlLoader.load());
            DashboardController dashboardController = fxmlLoader.getController();
            dashboardController.getStage(stage,profile_box);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        stage.getScene().addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                borderPane.requestFocus();
//            }
//        });
    }

}
