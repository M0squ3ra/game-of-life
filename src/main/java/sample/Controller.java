package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import sample.core.Calculator;
import sample.core.Cell;

public class Controller {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button start;

    @FXML
    private Button stop;

    @FXML
    private Button next;

    @FXML
    private Button reset;

    private Cell[][] cells;
    private Calculator calculator;
    private Timeline timeline;
    private int width = 37;
    private int height = 37;

    public void initialize(){

        GridPane gridPane = new GridPane();
        gridPane.setVgap(1);
        gridPane.setHgap(1);
        anchorPane.getChildren().add(gridPane);

        //puede ser que h y w esten al revez
        cells = new Cell[width][height];

        //añado las celdas al gridpane
        for(int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                cells[i][j] = new Cell(i,j);
                gridPane.add(cells[i][j],i,j);
            }
        }

        calculator = new Calculator(cells,width,height);

        timeline = new Timeline(new KeyFrame(Duration.seconds(0.5),(actionEvent -> calculator.nextCycle())));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void start() {
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }

    public void next(){
        calculator.nextCycle();
    }

    public void reset(){
        timeline.stop();
        for(int i = 0;i < height; i++)
            for(int j = 0; j < width; j++)
                cells[i][j].setAlive(false);
    }
}
