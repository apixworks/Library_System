package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class MembershipManagementController implements Initializable {
    @FXML public AnchorPane anchorPane;

    @FXML public TableView<Member> members_table;
    @FXML public TableColumn<Member,String> id;
    @FXML public TableColumn<Member,String> name;
    @FXML public TableColumn<Member,String> faculty;
    @FXML public TableColumn<Member, String> action;

    ObservableList<Member> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchorPane.setPrefWidth(Screen.getPrimary().getBounds().getWidth() -261);
        anchorPane.setPrefHeight(Screen.getPrimary().getBounds().getHeight() -66);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        faculty.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        action.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        Callback<TableColumn<Member,String>, TableCell<Member,String>> cellFactory =
                new Callback<TableColumn<Member, String>, TableCell<Member, String>>() {
                    @Override
                    public TableCell<Member, String> call(TableColumn<Member, String> param) {
                        final TableCell<Member,String> cell = new TableCell<Member,String>(){
                            @Override
                            protected void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if(empty){
                                    setGraphic(null);
                                    setText(null);
                                }else{
                                    final Button viewBtn = new Button();
//                                    final Button bookBtn = new Button();
                                    final Button editBtn = new Button();

                                    ImageView viewImage = new ImageView(new Image(getClass().getResourceAsStream("icons/account-white.png")));
                                    viewImage.setFitHeight(24);
                                    viewImage.setFitWidth(24);
                                    viewBtn.setGraphic(viewImage);

                                    ImageView editImage = new ImageView(new Image(getClass().getResourceAsStream("icons/account-edit.png")));
                                    editImage.setFitHeight(24);
                                    editImage.setFitWidth(24);
                                    editBtn.setGraphic(editImage);

                                    viewBtn.setPrefWidth(30);
                                    viewBtn.setPrefHeight(24);
                                    viewBtn.setStyle("-fx-background-radius:3px; -fx-background-color:  #2cbba9;");
                                    viewBtn.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.rgb(0, 0, 0, 0.23), 10, 0, 0, 1));

//                                    bookBtn.setPrefWidth(30);
//                                    bookBtn.setPrefHeight(24);
//                                    bookBtn.setStyle("-fx-background-radius:3px; -fx-background-color:  #1BBED2;");
//                                    bookBtn.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.rgb(0, 0, 0, 0.23), 10, 0, 0, 1));

                                    editBtn.setPrefWidth(30);
                                    editBtn.setPrefHeight(24);
                                    editBtn.setStyle("-fx-background-radius:3px; -fx-background-color:  #fcb322;");
                                    editBtn.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.rgb(0, 0, 0, 0.23), 10, 0, 0, 1));

                                    Member member = getTableView().getItems().get(getIndex());
                                    viewBtn.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {

                                        }
                                    });
//                                    bookBtn.setOnAction(new EventHandler<ActionEvent>() {
//                                        @Override
//                                        public void handle(ActionEvent event) {
//
//                                        }
//                                    });
                                    editBtn.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {

                                        }
                                    });
                                    HBox hBox = new HBox();
                                    hBox.getChildren().addAll(viewBtn, editBtn);
                                    hBox.setAlignment(Pos.CENTER);
                                    hBox.setSpacing(10);
                                    setGraphic(hBox);
//                                    this.setStyle("-fx-font-weight: normal");
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        action.setCellFactory(cellFactory);

        data = FXCollections.observableArrayList(
                        new Member("Jacob", "Smith", "jacob.smith@example.com"),
                        new Member("Isabella", "Johnson", "isabella.johnson@example.com"),
                        new Member("Ethan", "Williams", "ethan.williams@example.com"),
                        new Member("Emma", "Jones", "emma.jones@example.com"),
                        new Member("Michael", "Brown", "michael.brown@example.com"),
                        new Member("Jacob", "Smith", "jacob.smith@example.com"),
                        new Member("Isabella", "Johnson", "isabella.johnson@example.com"),
                        new Member("Ethan", "Williams", "ethan.williams@example.com"),
//                        new Member("Emma", "Jones", "emma.jones@example.com"),
//                        new Member("Michael", "Brown", "michael.brown@example.com"),
//                        new Member("Jacob", "Smith", "jacob.smith@example.com"),
//                        new Member("Isabella", "Johnson", "isabella.johnson@example.com"),
//                        new Member("Ethan", "Williams", "ethan.williams@example.com"),
//                        new Member("Emma", "Jones", "emma.jones@example.com"),
//                        new Member("Michael", "Brown", "michael.brown@example.com"),
//                        new Member("Jacob", "Smith", "jacob.smith@example.com"),
//                        new Member("Isabella", "Johnson", "isabella.johnson@example.com"),
//                        new Member("Ethan", "Williams", "ethan.williams@example.com"),
//                        new Member("Emma", "Jones", "emma.jones@example.com"),
//                        new Member("Michael", "Brown", "michael.brown@example.com"),
//                        new Member("Jacob", "Smith", "jacob.smith@example.com"),
//                        new Member("Isabella", "Johnson", "isabella.johnson@example.com"),
//                        new Member("Ethan", "Williams", "ethan.williams@example.com"),
//                        new Member("Emma", "Jones", "emma.jones@example.com"),
//                        new Member("Michael", "Brown", "michael.brown@example.com"),
//                        new Member("Jacob", "Smith", "jacob.smith@example.com"),
//                        new Member("Isabella", "Johnson", "isabella.johnson@example.com"),
//                        new Member("Ethan", "Williams", "ethan.williams@example.com"),
//                        new Member("Emma", "Jones", "emma.jones@example.com"),
                        new Member("Michael", "Brown", "michael.brown@example.com"));

        TableView.TableViewSelectionModel tableViewSelectionModel = members_table.getSelectionModel();

        tableViewSelectionModel.setCellSelectionEnabled(true);
        members_table.setItems(data);
    }

    public void getSearchView(TextField searchView){
        searchView.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<Member> temp_members = FXCollections.observableArrayList();
            for(Member member: data){
                if(member.getName().toLowerCase().contains(newValue.toLowerCase())){
                    temp_members.add(member);
                }
            }
            members_table.setItems(temp_members);
        });
    }
}
