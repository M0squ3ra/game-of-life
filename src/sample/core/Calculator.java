package sample.core;

public class Calculator {
    private int width;
    private int height;
    private Cell[][] cells;

    public Calculator(Cell[][] cells,int width,int height) {
        this.cells = cells;
        this.width = width;
        this.height = height;
    }

    public void setState(boolean[][] state){
        for(int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                cells[i][j].setAlive(state[i][j]);
            }
        }
    }

    //permite los limites periodicos
    public int getPos(int i,int j,int mod){
        //(i + j) % mod
        if(i + j < 0){
            return mod - 1;
        } else if(i + j < mod){
            return i + j;
        }else {
            return 0;
        }

    }

    public int getLiveNeighbors(int x, int y){
        int n = 0;

        int i = getPos(x,-1,width);
        int j = getPos(y,-1,height);
        if (cells[i][j].isAlive())
            n++;

        i = getPos(x,-1,width);
        j = getPos(y,0,height);
        if (cells[i][j].isAlive())
            n++;

        i = getPos(x,-1,width);
        j = getPos(y,1,height);
        if (cells[i][j].isAlive())
            n++;

        i = getPos(x,0,width);
        j = getPos(y,-1,height);
        if (cells[i][j].isAlive())
            n++;

        i = getPos(x,0,width);
        j = getPos(y,1,height);
        if (cells[i][j].isAlive())
            n++;

        i = getPos(x,1,width);
        j = getPos(y,-1,height);
        if (cells[i][j].isAlive())
            n++;

        i = getPos(x,1,width);
        j = getPos(y,0,height);
        if (cells[i][j].isAlive())
            n++;

        i = getPos(x,1,width);
        j = getPos(y,1,height);
        if (cells[i][j].isAlive())
            n++;

        return n;
    }

    public void nextCicle(){
        //aca calculamos como debe quedar el tablero en el siguiente ciclo
        //utilizar matriz de booleanos para una vez calculados todas las celdas
        //cambiar el estado de todas las celdas de golpe
        boolean[][] nextState;

        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){

            }
        }
    }
}
