package Pieces;

import Pieces.basic.Piece;
import components.basic.Square;
import java.util.LinkedList;

public class Queen extends Piece {
    
    public Queen(boolean is_white, LinkedList<Piece> pieces, Square square) {
        super(is_white, "queen", pieces, square);
    }
    
}
