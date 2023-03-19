package TicTacToe.strategies.GameWinningStarategy;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.GameState;
import TicTacToe.models.Player;

public class OrderNGameWinningStrategy implements GameWinningStrategy{


    @Override
    public GameState checkForWinner(Board board, Player player, Cell cell) {
        GameState retVal = GameState.End_In_Result;

        Cell[][] cells= board.getCells();
        int row_of_curr_cell = cell.getRow();
        int col_of_curr_cell = cell.getCol();

        //check the row
        boolean flag = true;
        for(int j = 0; j < cells.length; j++){
            if(cells[row_of_curr_cell][j].getPlayer() != player){
                flag = false;
                break;
            }
        }
        if(flag) return GameState.End_In_Result;

        //check the col
        flag = true;
        for(int i = 0; i < cells.length; i++){
            if(cells[i][col_of_curr_cell].getPlayer() != player){
                flag = false;
                break;
            }
        }
        if(flag) return GameState.End_In_Result;


        //check the diagonal


        //check for draw
        flag = true;
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells.length; j++){
                if(cells[i][j].getPlayer() == null){
                    flag = false;
                }
            }
        }

        if(flag) return GameState.End_In_Draw;


        return GameState.InProgress;
    }
}
