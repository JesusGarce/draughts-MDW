package es.urjccode.mastercloudapps.adcs.draughts.models;

public class BoardMockWithoutRemovePieces extends Board {

    public BoardMockWithoutRemovePieces() {
        super();
    }

    @Override
    void removeIfSomeoneCanEat(Color color){ }

}
