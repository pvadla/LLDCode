package TicTacToe.strategies.BotPlayingStrategies;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

public class EasyPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move decideMove(Player player, Board board) {
        Cell[][] cells = board.getCells();
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells.length; j++){
                if(cells[i][j].getPlayer() == null){
                    Move move = new Move(player, i, j );
                    return move;
                }
            }
        }
        return null;
    }
}
