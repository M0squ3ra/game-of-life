package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import sample.core.Calculator;
import sample.core.Cell;

import java.util.Random;

public class Controller {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button start;

    @FXML
    private Button stop;

    @FXML
    private Button next;

    private Cell[][] cells;
    private Calculator calculator;

    public void initialize(){

        GridPane gridPane = new GridPane();
        gridPane.setVgap(1);
        gridPane.setHgap(1);
        anchorPane.getChildren().add(gridPane);

        int width = 37;
        int height = 37;

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
    }

    public void start() {
        System.out.println("start");
    }

    public void stop() {
        System.out.println("stop");
    }

    public void next(){
        calculator.nextCicle();
    }
}
