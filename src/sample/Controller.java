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

        cells[0][0].setAlive(true);
        cells[0][1].setAlive(true);
        cells[0][2].setAlive(true);
        cells[1][0].setAlive(true);
        cells[1][2].setAlive(true);
        cells[1][1].setAlive(true);
        cells[36][0].setAlive(true);
        cells[36][1].setAlive(true);
        cells[36][2].setAlive(true);
        cells[1][3].setAlive(true);
        cells[2][3].setAlive(true);
        cells[3][3].setAlive(true);
        cells[0][36].setAlive(true);
        cells[1][36].setAlive(true);

    }

    public void start() {
        while (true){
            int rx = (int) (Math.random() * 37);
            int ry = (int) (Math.random() * 37);

            cells[rx][ry].setAlive(true);
        }



        /*Calculator calculator = new Calculator(cells);

        while (true){  //en el futuro deberia poder detenerse y pausarse
            int i = 0;
            try {
                calculator.nextCicle();
                cells[i][1].setAlive(true);
                Thread.sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }
        }*/
    }
}
