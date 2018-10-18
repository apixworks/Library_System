package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    @FXML public HBox member_hbox, book_hbox;
    @FXML public Label member_label, book_label;
    @FXML public ImageView member_image;
    @FXML public ImageView book_image;
    @FXML public BorderPane borderPane;
    @FXML public TextField searchView;

    private String current;
    private ArrayList<HBox> hBoxes;
    private ArrayList<Label> labels;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("membership_management.fxml"));
            borderPane.setCenter(fxmlLoader.load());
            MembershipManagementController membershipManagementController = fxmlLoader.getController();
            membershipManagementController.getSearchView(searchView);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stateChanger(){
        if(current.equals("members")){
            clickedEffect(member_hbox,member_label);

            hBoxes = new ArrayList<>();
            hBoxes.add(book_hbox);

            labels = new ArrayList<>();
            labels.add(book_label);

            member_image.setImage(new Image(Main.class.getResourceAsStream("icons/account-white.png")));

            unclickedEffect(hBoxes,labels);

        }else if(current.equals("books")){
            clickedEffect(book_hbox, book_label);

            hBoxes = new ArrayList<>();
            hBoxes.add(member_hbox);

            labels = new ArrayList<>();
            labels.add(member_label);

            book_image.setImage(new Image(Main.class.getResourceAsStream("icons/library-books-white.png")));

            unclickedEffect(hBoxes,labels);
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
        }else if(current.equals("books")){
            member_image.setImage(new Image(Main.class.getResourceAsStream("icons/account.png")));
        }
    }

    public void getDetails(){

    }

}
