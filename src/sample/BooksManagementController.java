package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BooksManagementController implements Initializable {
    @FXML
    public AnchorPane anchorPane;

    @FXML public TableView<Book> books_table;
    @FXML public TableColumn<Book,String> isbn;
    @FXML public TableColumn<Book,String> title;
    @FXML public TableColumn<Book,String> publication;
    @FXML public TableColumn<Book, String> language;
    @FXML public TableColumn<Book, String> category;
    @FXML public TableColumn<Book, String> status;
    @FXML public TableColumn<Book, String> action;

    @FXML public Pane profile_pane;
    @FXML public HBox profile_update,logout;

    @FXML public Label profile_update_label,logout_label;

    ObservableList<Book> books;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchorPane.setPrefWidth(Screen.getPrimary().getBounds().getWidth() -261);
        anchorPane.setPrefHeight(Screen.getPrimary().getBounds().getHeight() -66);

        profile_update.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                profile_update.setStyle("-fx-background-radius:5px; -fx-background-color:  #1BBED2;");
                profile_update.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.rgb(0, 0, 0, 0.23), 10, 0, 0, 3));
                profile_update_label.setTextFill(Color.rgb(255,255,255));
            }
        });
        profile_update.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                profile_update.setStyle(null);
                profile_update.setEffect(null);
                profile_update_label.setTextFill(Color.rgb(0,0,0));
            }
        });
        logout.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logout.setStyle("-fx-background-radius:5px; -fx-background-color:  #1BBED2;");
                logout.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.rgb(0, 0, 0, 0.23), 10, 0, 0, 3));
                logout_label.setTextFill(Color.rgb(255,255,255));
            }
        });
        logout.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logout.setStyle(null);
                logout.setEffect(null);
                logout_label.setTextFill(Color.rgb(0,0,0));
            }
        });

        isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        publication.setCellValueFactory(new PropertyValueFactory<>("publication"));
        language.setCellValueFactory(new PropertyValueFactory<>("language"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        action.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        books_table.setRowFactory(tv -> new TableRow<Book>() {
            @Override
            public void updateItem(Book item, boolean empty) {
                super.updateItem(item, empty) ;
                if (item == null) {
                    setStyle("");
                } else {
                    setStyle("-fx-border-color: #E0E0E0; -fx-border-width: 0.7 0 0 0;");
                }
            }
        });

        Callback<TableColumn<Book,String>, TableCell<Book,String>> cellFactory =
                new Callback<TableColumn<Book, String>, TableCell<Book, String>>() {
                    @Override
                    public TableCell<Book, String> call(TableColumn<Book, String> param) {
                        final TableCell<Book,String> cell = new TableCell<Book,String>(){
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

                                    ImageView viewImage = new ImageView(new Image(getClass().getResourceAsStream("icons/library-books-white.png")));
                                    viewImage.setFitHeight(24);
                                    viewImage.setFitWidth(24);
                                    viewBtn.setGraphic(viewImage);

                                    ImageView editImage = new ImageView(new Image(getClass().getResourceAsStream("icons/edit.png")));
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

                                    Book book = getTableView().getItems().get(getIndex());
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
                                    hBox.setAlignment(Pos.CENTER_LEFT);
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

        status.setCellFactory(new Callback<TableColumn<Book, String>, TableCell<Book, String>>() {

            @Override
            public TableCell<Book, String> call(TableColumn<Book, String> p) {


                return new TableCell<Book, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            this.setAlignment(Pos.CENTER_LEFT);
                            if(item.equals("Available")) {
                                this.setStyle("-fx-text-fill: #2cbba9;-fx-font-size: 14px;-fx-font-weight:normal;");
                                setText("Available");
                            }
                            else {
                                this.setStyle("-fx-text-fill: red;-fx-font-size: 14px;-fx-font-weight:normal;");
                                setText("Not Available");
                            }
                        }
                    }
                };
            }
        });

        books = FXCollections.observableArrayList(
                new Book("1", "Mathematical Statistics", "Second edition","English","Mathematics","Available"),
                new Book("2", "How the Brain Learns", "fifth edition","Kiswahili","Social Science","Available"),
                new Book("3", "Artificial Intelligence and the Two Singularities", "First edition","Kiswahili","Statistics","Not available"),
                new Book("4", "Applied Text Analysis with Python", "Ninth edition","French","Programming","Available"),
                new Book("5", "Making Sense of People The Science of Personality Differences", "Eleventh Edition","English","Social Science","Not available"),
                new Book("6", "Social Engineering The Science of Human Hacking", "Third edition","English","COmputer Science","Available"),
                new Book("7", "English for Writing Research Papers", "Sixth edition","Kiswahili","Writing","Available"),
                new Book("8", "How the Brain Learns", "Tenth edition","French","Social Science","Not available"),
                new Book("9", "Applied Text Analysis with Python", "Eleventh edition","English","Programming","Available"));

        TableView.TableViewSelectionModel tableViewSelectionModel = books_table.getSelectionModel();

        tableViewSelectionModel.setCellSelectionEnabled(true);
        books_table.setItems(books);
    }

    public void getSearchView(TextField searchView){
        searchView.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<Book> temp_books = FXCollections.observableArrayList();
            for(Book book: books){
                if(book.getTitle().toLowerCase().contains(newValue.toLowerCase())){
                    temp_books.add(book);
                }
            }
            books_table.setItems(temp_books);
        });
    }

    public void addBookDialog(){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_book.fxml"));
        stage.setTitle("Tanga Library");
        Scene editBookScene = null;
        try {
            editBookScene = new Scene(fxmlLoader.load(),938,700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(editBookScene);
        stage.show();
    }

    public void getStage(Stage stage, VBox profileBox){
        profileBox.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                profile_pane.setVisible(true);
            }
        });
        stage.getScene().addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                anchorPane.requestFocus();
                if(profile_pane.isVisible()){
                    profile_pane.setVisible(false);
                }
            }
        });
    }
}
