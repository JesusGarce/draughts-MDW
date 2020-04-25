package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GameBuilder {

    private Color color;
    private List<String> strings;
    private Board board;

    public GameBuilder() {
        this.color = null;
        this.strings = new ArrayList<String>();
        this.board = new Board();
    }

    public GameBuilder board(Board board){
        this.board = board;
        return this;
    }

    public GameBuilder color(Color color){
        this.color = color;
        return this;
    }

    public GameBuilder rows(String... strings) {
        for (String string : strings) {
            assert Pattern.matches("[bn ]{8}", string);
            this.strings.add(string);
        }
        return this;
    }

    public Game build() {
        if (this.strings.size() == 0)
            return new Game();
        Game game = new Game(board);
        assert this.strings.size() == Coordinate.getDimension();
        this.setColor(game, board);
        for (int i = 0; i < this.strings.size(); i++) {
            this.setRow(board, i, this.strings.get(i));
        }
        return game;
    }

    private void setColor(Game game, Board board) {
        if (this.color == Color.BLACK) {
            board.put(new Coordinate(7, 0), new Pawn(Color.WHITE));
            game.move(new Coordinate(7, 0), new Coordinate(6, 1));
            board.remove(new Coordinate(6, 1));
        }
    }

    private void setRow(Board board, int row, String string) {
        for (int j = 0; j < string.length(); j++) {
            Color color = this.getColor(string.charAt(j));
            if (color != null) {
                Piece piece = new Pawn(color);
                board.put(new Coordinate(row, j), piece);
            }
        }
    }

    private Color getColor(char character) {
        switch (character) {
        case 'b':
            return Color.WHITE;
        case 'n':
            return Color.BLACK;
        default:
            return null;
        }
    }

}
