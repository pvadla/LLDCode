package TicTacToe.models;

import TicTacToe.exceptions.InvalidArgumentsGameException;
import TicTacToe.strategies.GameWinningStarategy.GameWinningStrategy;
import TicTacToe.strategies.GameWinningStarategy.OrderNGameWinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private int turn;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;

    private GameWinningStrategy gameWinningStrategy;

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getTurn() {
        return turn;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    //For Builder pattern constructor should be private
    private Game(int dim, List<Player> players){
        this.board = new Board(dim);
        this.players = players;
        this.turn = 0;
        this.moves = new ArrayList<>();
        this.gameState = GameState.InProgress;
        this.winner = null;
        this.gameWinningStrategy = new OrderNGameWinningStrategy();
    }

    public void display(){
        this.board.display();

    }


    public void undo(){


    }

    public void makeNextMove(){
        Player player = players.get(turn);

        Move move = player.decideMove(board);

        Cell cellForMove = board.getCells()[move.getRow()][move.getCol()];

        //validate the chosen move from row and col
        cellForMove.setPlayer(player);
        moves.add(move);

        //if we have won, set game state and winner
        //other wise prepare for next Turn
        GameState newGameState = this.gameWinningStrategy.checkForWinner(board,player, cellForMove);
        if(newGameState == GameState.End_In_Result){
            this.gameState = GameState.End_In_Result;
            this.winner = player;
        }else if(newGameState == GameState.End_In_Draw){
            this.gameState = GameState.End_In_Draw;
            this.winner = null;
        } else{
            turn = (turn + 1) % players.size();
        }

    }

    public void replay(){

    }



    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public static class GameBuilder {

        private int dimensions;
        private List<Player> players;

        public GameBuilder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private void validate() throws InvalidArgumentsGameException{
            //dimensions >= 3
            if(dimensions < 3){
                throw new InvalidArgumentsGameException("Dimensions should be >= 3");
            }

            HashSet<Character> uniqueSymbols = new HashSet<>();
            for(Player p: players){
                if(uniqueSymbols.contains(p.getSymbol())){
                    throw new InvalidArgumentsGameException("Players should have unique symbol");
                }else{
                    uniqueSymbols.add(p.getSymbol());
                }

            }

        }

        public Game build() throws InvalidArgumentsGameException{

            try{
                validate();
                return new Game(dimensions,players);
            }catch(InvalidArgumentsGameException ex){
                throw ex;
            }
        }

    }
}
