package TicTacToe.strategies.GameWinningStarategy;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.GameState;
import TicTacToe.models.Player;

public interface GameWinningStrategy {

    GameState checkForWinner(Board board, Player player, Cell cell);


}
