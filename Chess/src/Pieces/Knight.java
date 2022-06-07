package Pieces;

import Pieces.basic.Piece;
import components.basic.Square;
import java.util.LinkedList;

public class Knight extends Piece {
    
    public Knight(boolean is_white, LinkedList<Piece> pieces, Square square) {
        super(is_white, "knight", pieces, square);
    }
    
}
