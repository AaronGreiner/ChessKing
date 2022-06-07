package Pieces;

import Pieces.basic.Piece;
import components.basic.Square;
import java.util.LinkedList;

public class Bishop extends Piece {
    
    public Bishop(boolean is_white, LinkedList<Piece> pieces, Square square) {
        super(is_white, "bishop", pieces, square);
    }
    
}
