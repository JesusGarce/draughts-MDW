package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.List;

class BoardMockWithNoRandom extends Board {

    BoardMockWithNoRandom() {
        super();
    }

    @Override
    Piece removeRandomPiece(List<Coordinate> coordinates){
        return remove(coordinates.get(0));
    }

}
