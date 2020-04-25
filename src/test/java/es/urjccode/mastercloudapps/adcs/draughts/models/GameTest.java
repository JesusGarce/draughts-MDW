package es.urjccode.mastercloudapps.adcs.draughts.models;

public class GameTest {

    protected Game game;
    protected Game expectedGame;

    protected void setGame(Color color, String... strings) {
        this.game = new GameBuilder().color(color).rows(strings).build();
    }

    protected void setExpectedGame(Color color, String... strings) {
        this.expectedGame = new GameBuilder().color(color).rows(strings).build();
    }

    protected void setGameWithoutRandomBoard(Color color, String... strings) {
        this.game = new GameBuilder().board(new BoardMockWithNoRandom()).color(color).rows(strings).build();
    }

    protected void setExpectedGameWithoutRandomBoard(Color color, String... strings) {
        this.expectedGame = new GameBuilder().board(new BoardMockWithNoRandom()).color(color).rows(strings).build();
    }

}
