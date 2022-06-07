package Pieces;

import Pieces.basic.Piece;
import components.basic.Square;
import java.util.LinkedList;

public class Rook extends Piece {
    
    public Rook(boolean is_white, LinkedList<Piece> pieces, Square square) {
        super(is_white, "rook", pieces, square);
    }
    
    @Override
    public boolean checkPosition(Square square) {
        
        Square pos = this.getSquare();
        
        if (square == pos) {
            return false;
        }
        
        if (square.getX() == pos.getX()) {
            return true;
        }
        if (square.getY() == pos.getY()) {
            return true;
        }
        
        return false;
    }
}
