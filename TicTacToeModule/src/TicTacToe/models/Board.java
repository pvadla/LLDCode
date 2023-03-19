package TicTacToe.models;

public class Board {



    private Cell[][] cells;

    public Board(int dimensions){
        cells = new Cell[dimensions][dimensions];
        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions; j++){
                cells[i][j] = new Cell(i,j);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }



}
