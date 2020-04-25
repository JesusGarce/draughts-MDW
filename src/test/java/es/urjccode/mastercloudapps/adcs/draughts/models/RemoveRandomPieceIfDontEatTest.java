package es.urjccode.mastercloudapps.adcs.draughts.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class RemoveRandomPieceIfDontEatTest extends GameTest {

    private void assertMove(Coordinate... coordinates){
        assertNull(this.game.move(coordinates));
        assertEquals(this.game, this.expectedGame);
    }

    private void assertMoveFail(Coordinate... coordinates){
        assertNull(this.game.move(coordinates));
        assertNotEquals(this.game, this.expectedGame);
    }

    @Test
    public void testMovePieceAndDontEatAnything(){
        this.setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            " n      ",
            "b      b",
            "        ",
            "        ");
        this.setExpectedGame(Color.BLACK,
            "        ",
            "        ",
            "        ",
            "        ",
            " n    b ",
            "        ",
            "        ",
            "        ");
        this.assertMove(
            new Coordinate(5, 7),
            new Coordinate(4, 6)
        );
    }

    @Test
    public void testMovePieceAndDontEatAnythingManyOptions(){
        this.setGameWithoutRandomBoard(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            " n n    ",
            "b b b  b",
            "        ",
            "        ");
        this.setExpectedGameWithoutRandomBoard(Color.BLACK,
            "        ",
            "        ",
            "        ",
            "        ",
            " n n  b ",
            "  b b   ",
            "        ",
            "        ");
        this.assertMove(
            new Coordinate(5, 7),
            new Coordinate(4, 6)
        );
    }

    @Test
    public void testMovePawnAndEatOne(){
        this.setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            " n      ",
            "b      b",
            "        ",
            "        ");
        this.setExpectedGame(Color.BLACK,
            "        ",
            "        ",
            "        ",
            "  b     ",
            "        ",
            "       b",
            "        ",
            "        ");
        this.assertMove(
            new Coordinate(5, 0),
            new Coordinate(3, 2)
        );
    }

    @Test
    public void testMovePawnAndEatMany(){
        this.setGame(Color.WHITE,
            "        ",
            "        ",
            "   n    ",
            "        ",
            " n      ",
            "b      b",
            "        ",
            "        ");
        this.setExpectedGame(Color.BLACK,
            "        ",
            "    b   ",
            "        ",
            "        ",
            "        ",
            "       b",
            "        ",
            "        ");
        this.assertMove(
            new Coordinate(5, 0),
            new Coordinate(3, 2),
            new Coordinate(1,4)
        );
    }

}
