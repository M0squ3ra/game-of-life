package sample;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import sample.core.Cell;

public class Controller {

    @FXML
    private AnchorPane anchorPane;

    public void initialize(){

        GridPane gridPane = new GridPane();
        gridPane.setVgap(1);
        gridPane.setHgap(1);
        anchorPane.getChildren().add(gridPane);

        int width = 37;
        int height = 37;

        //puede ser que h y w esten al revez
        Cell[][] cells = new Cell[width][height];

        for(int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                cells[i][j] = new Cell(i,j);
                gridPane.add(cells[i][j],i,j);
            }
        }

        cells[1][3].setAlive(true);
    }
}
