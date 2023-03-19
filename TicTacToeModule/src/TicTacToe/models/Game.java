package TicTacToe.models;

import TicTacToe.exceptions.InvalidArgumentsGameException;

import java.util.HashSet;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private int turn;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    //For Builder pattern constructor should be private
    private Game(){
        //making use of builder necessary

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
                Game g = new Game();
                return g;
            }catch(InvalidArgumentsGameException ex){
                throw ex;
            }
        }

    }
}
