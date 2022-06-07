package Pieces;

import Pieces.basic.Piece;
import components.basic.Square;
import java.util.LinkedList;

public class Rook extends Piece {
    
    public Rook(boolean is_white, LinkedList<Piece> pieces, Square square) {
        super(is_white, "rook", pieces, square);
    }
    
}
