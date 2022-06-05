package Pieces;

import Pieces.basic.Piece;
import java.util.LinkedList;

public class Pawn extends Piece {
    
    public Pawn(int pos_x, int pos_y, boolean isWhite, LinkedList<Piece> pieces) {
        super(pos_x, pos_y, isWhite, "pawn", pieces);
    }
}
