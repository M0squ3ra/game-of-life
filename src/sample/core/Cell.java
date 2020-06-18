package sample.core;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Parent {
    private int x;
    private int y;
    private boolean alive;

    private Rectangle fondo;
    private Rectangle box;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.alive = false;

        //fondo de la celda
        this.fondo = new Rectangle(15,15);
        this.fondo.setFill(Color.rgb(77, 77, 77));
        this.fondo.setOnMouseClicked(mouseEvent -> setAlive(!this.isAlive()));
        this.getChildren().add(this.fondo);

        //rectangulo que indica estado de la celda
        //(ancho fondo - ancho celda)/2 = centrado, lo mismo para alto
        this.box = new Rectangle(0.5,0.5,14,14);
        this.box.setFill(Color.WHITE);
        this.box.setVisible(false);
        this.box.setOnMouseClicked(mouseEvent -> setAlive(!this.isAlive()));
        this.getChildren().add(this.box);
    }

    public void setAlive(boolean alive){
        this.box.setVisible(alive);
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
