package Pieces;

import Pieces.basic.Piece;
import components.basic.Square;
import java.util.LinkedList;

public class King extends Piece {
    
    public King(boolean is_white, LinkedList<Piece> pieces, Square square) {
        super(is_white, "king", pieces, square);
    }
    
}
