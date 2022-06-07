package Pieces;

import Pieces.basic.Piece;
import components.basic.Square;
import java.util.LinkedList;

public class Pawn extends Piece {
    
    public Pawn(boolean is_white, LinkedList<Piece> pieces, Square square) {
        super(is_white, "pawn", pieces, square);
    }
    
}
