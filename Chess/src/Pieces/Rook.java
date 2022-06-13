package Pieces;

import Pieces.basic.MovementHintType;
import Pieces.basic.Piece;
import components.basic.Square;
import java.util.LinkedList;

public class Rook extends Piece {
    
    public Rook(boolean is_white, LinkedList<Piece> pieces, Square square) {
        super(is_white, "rook", pieces, square);
    }
    
    @Override
    public MovementHintType checkPosition(Square square) {
        
        Square pos = this.getSquare();
        
        if (square == pos) {
            return MovementHintType.NONE;
        }
        
        if (square.getX() == pos.getX()) {
            return getReturnForSquare(square);
        }
        if (square.getY() == pos.getY()) {
            return getReturnForSquare(square);
        }
        
        return MovementHintType.NONE;
    }
}
