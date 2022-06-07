package Pieces;

import Pieces.basic.MovementHintType;
import Pieces.basic.Piece;
import components.basic.Square;
import java.util.LinkedList;

public class Queen extends Piece {
    
    public Queen(boolean is_white, LinkedList<Piece> pieces, Square square) {
        super(is_white, "queen", pieces, square);
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
        
        for (int i = 1; i <= 8; i++) {
            if (pos.getX()+i == square.getX() && pos.getY()+i == square.getY()) {
                return getReturnForSquare(square);
            }
            if (pos.getX()-i == square.getX() && pos.getY()-i == square.getY()) {
                return getReturnForSquare(square);
            }
            if (pos.getX()-i == square.getX() && pos.getY()+i == square.getY()) {
                return getReturnForSquare(square);
            }
            if (pos.getX()+i == square.getX() && pos.getY()-i == square.getY()) {
                return getReturnForSquare(square);
            }
        }
        
        return MovementHintType.NONE;
    }
}
