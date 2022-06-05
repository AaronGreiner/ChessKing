package Pieces;

import Pieces.basic.Piece;
import java.util.LinkedList;

public class Bishop extends Piece {
    
    public Bishop(int pos_x, int pos_y, boolean isWhite, LinkedList<Piece> pieces) {
        super(pos_x, pos_y, isWhite, "bishop", pieces);
    }
}
