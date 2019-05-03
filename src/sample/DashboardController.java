package sample;

import com.jfoenix.controls.JFXToggleNode;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    public AnchorPane anchorPane;

    @FXML
    Pane no_books, no_members, no_john, no_jane;

    @FXML
    public Pane profile_pane;
    @FXML
    public HBox profile_update, logout;

    @FXML
    public Label profile_update_label, logout_label;

    @FXML
    public AreaChart report_chart;

    @FXML
    public JFXToggleNode toggle1;
    @FXML
    public JFXToggleNode toggle2;
    @FXML
    public JFXToggleNode toggle3;

    ArrayList<JFXToggleNode> toggleNodes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchorPane.setPrefWidth(Screen.getPrimary().getBounds().getWidth() - 261);
        anchorPane.setPrefHeight(Screen.getPrimary().getBounds().getHeight() - 66);

        AnchorPane.setLeftAnchor(no_books, Screen.getPrimary().getBounds().getWidth() / 4);
        AnchorPane.setRightAnchor(no_john, Screen.getPrimary().getBounds().getWidth() / 4);

//        AnchorPane.setLeftAnchor(no_books,Screen.getPrimary().getBounds().getWidth()/4);
//        AnchorPane.setLeftAnchor(no_john,Screen.getPrimary().getBounds().getWidth()/2);

//        no_books.setLayoutX(Screen.getPrimary().getBounds().getWidth()/4);
//        no_john.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2);

        profile_update.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                profile_update.setStyle("-fx-background-radius:5px; -fx-background-color:  #1BBED2;");
                profile_update.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.rgb(0, 0, 0, 0.23), 10, 0, 0, 3));
                profile_update_label.setTextFill(Color.rgb(255, 255, 255));
            }
        });
        profile_update.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                profile_update.setStyle(null);
                profile_update.setEffect(null);
                profile_update_label.setTextFill(Color.rgb(0, 0, 0));
            }
        });
        logout.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logout.setStyle("-fx-background-radius:5px; -fx-background-color:  #1BBED2;");
                logout.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.rgb(0, 0, 0, 0.23), 10, 0, 0, 3));
                logout_label.setTextFill(Color.rgb(255, 255, 255));
            }
        });
        logout.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logout.setStyle(null);
                logout.setEffect(null);
                logout_label.setTextFill(Color.rgb(0, 0, 0));
            }
        });

        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis = new CategoryAxis();
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>(); //Make a new XYChart object
        series.getData().add(new XYChart.Data<String,Number>("January", 600));
        series.getData().add(new XYChart.Data<String,Number>("February", 300));
        series.getData().add(new XYChart.Data<String,Number>("March", 1200));
        series.getData().add(new XYChart.Data<String,Number>("April", 750));
        series.getData().add(new XYChart.Data<String,Number>("May", 2000));
        series.getData().add(new XYChart.Data<String,Number>("June", 500));
        report_chart.getData().addAll(series);

        Node fill = series.getNode().lookup(".chart-series-area-fill"); // only for AreaChart
        Node line = series.getNode().lookup(".chart-series-area-line");

        Color color = Color.rgb(252,179,34); // or any other color

        String rgb = String.format("%d, %d, %d",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));

        fill.setStyle("-fx-fill: rgba(" + rgb + ", 0.15);");
        line.setStyle("-fx-stroke: rgba(" + rgb + ", 1.0);");

        ToggleGroup group = new ToggleGroup();
        toggle1.setToggleGroup(group);
        toggle2.setToggleGroup(group);
        toggle3.setToggleGroup(group);
    }

    public void toggle1Click(){
        clickedEffect(toggle1);
        toggleNodes = new ArrayList<>();
        toggleNodes.add(toggle2);
        toggleNodes.add(toggle3);
        unclickedEffect(toggleNodes);
    }

    public void toggle2Click(){
        clickedEffect(toggle2);
        toggleNodes = new ArrayList<>();
        toggleNodes.add(toggle1);
        toggleNodes.add(toggle3);
        unclickedEffect(toggleNodes);
    }

    public void toggle3Click(){
        clickedEffect(toggle3);
        toggleNodes = new ArrayList<>();
        toggleNodes.add(toggle1);
        toggleNodes.add(toggle2);
        unclickedEffect(toggleNodes);
    }

    private void clickedEffect(JFXToggleNode label){
        label.setTextFill(Color.rgb(255,255,255));
    }

    private void unclickedEffect(ArrayList<JFXToggleNode> labels){
        for(JFXToggleNode label: labels){
            label.setTextFill(Color.rgb(0,0,0));
        }
    }

    public void getStage(Stage stage, VBox profileBox) {
        stage.widthProperty().addListener(e -> {
//            System.out.println(stage.getWidth());
//            AnchorPane.setLeftAnchor(no_books,stage.getWidth()/4);
//            AnchorPane.setLeftAnchor(no_john,stage.getWidth()/2);
            if (stage.getWidth() > 1500) {
                no_books.setPrefWidth(309);
                no_members.setPrefWidth(309);
                no_jane.setPrefWidth(309);
                no_john.setPrefWidth(309);
            } else {
                no_books.setPrefWidth(209);
                no_members.setPrefWidth(209);
                no_jane.setPrefWidth(209);
                no_john.setPrefWidth(209);
            }
            AnchorPane.setLeftAnchor(no_books, Screen.getPrimary().getBounds().getWidth() / 4);
            AnchorPane.setRightAnchor(no_john, Screen.getPrimary().getBounds().getWidth() / 4);
        });
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
                if (profile_pane.isVisible()) {
                    profile_pane.setVisible(false);
                }
            }
        });
    }
}
