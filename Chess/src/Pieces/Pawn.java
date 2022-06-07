package Pieces;

import Pieces.basic.MovementHintType;
import Pieces.basic.Piece;
import components.basic.Square;
import java.util.LinkedList;

public class Pawn extends Piece {
    
    public Pawn(boolean is_white, LinkedList<Piece> pieces, Square square) {
        super(is_white, "pawn", pieces, square);
    }
    
    @Override
    public MovementHintType checkPosition(Square square) {
        
        Square pos = this.getSquare();
        
        if (square == pos) {
            return MovementHintType.NONE;
        }
        
        if (this.getIsWhite()) {
            if (this.getMoveCount() == 0) {
                if (square.getX() == pos.getX() && (square.getY() + 1 == pos.getY() || square.getY() + 2 == pos.getY())) {
                    return getReturnForSquare(square);
                }
            } else {
                if (square.getX() == pos.getX() && square.getY() + 1 == pos.getY()) {
                    return getReturnForSquare(square);
                }
            }
        } else {
            if (this.getMoveCount() == 0) {
                if (square.getX() == pos.getX() && (square.getY() - 1 == pos.getY() || square.getY() - 2 == pos.getY())) {
                    return getReturnForSquare(square);
                }
            } else {
                if (square.getX() == pos.getX() && square.getY() - 1 == pos.getY()) {
                    return getReturnForSquare(square);
                }
            }
        }
        
        return MovementHintType.NONE;
    }
}
