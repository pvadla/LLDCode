package TicTacToe.models;

import TicTacToe.factories.BotPlayingStrategyFactory;
import TicTacToe.strategies.BotPlayingStrategies.BotPlayingStrategy;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;


    public Bot(String name, char symbol, BotDifficultyLevel botDifficultyLevel){
        super(name,symbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    @Override
    public Move decideMove(Board board) {
        return this.botPlayingStrategy.decideMove(this,board);
    }
}
