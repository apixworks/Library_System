package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public HBox member_hbox, book_hbox;
    @FXML public Label member_label, book_label;
    @FXML public ImageView member_img;

    private String current;
    private ArrayList<HBox> hBoxes;
    private ArrayList<HBox> temp_hBoxes;
    private ArrayList<Label> labels;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hBoxes = new ArrayList<>();
        hBoxes.add(book_hbox);
        hBoxes.add(member_hbox);
    }

    public void memberClick(){
        current = "members";
        stateChanger();
    }

    public void bookClick(){
        current = "books";
        stateChanger();
    }

    private void stateChanger(){
        if(current.equals("members")){
            clickedEffect(member_hbox,member_label);

            temp_hBoxes = hBoxes;
            temp_hBoxes.remove(member_hbox);

            labels = new ArrayList<>();
            labels.add(book_label);

            unclickedEffect(temp_hBoxes,labels);

        }else if(current.equals("books")){
            clickedEffect(book_hbox, book_label);

            temp_hBoxes = hBoxes;
            temp_hBoxes.remove(book_hbox);

            labels = new ArrayList<>();
            labels.add(member_label);

            unclickedEffect(temp_hBoxes,labels);
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
    }

}
