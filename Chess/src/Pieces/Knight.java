package Pieces;

import Pieces.basic.MovementHintType;
import Pieces.basic.Piece;
import components.basic.Square;
import java.util.LinkedList;

public class Knight extends Piece {
    
    public Knight(boolean is_white, LinkedList<Piece> pieces, Square square) {
        super(is_white, "knight", pieces, square);
    }
    
    @Override
    public MovementHintType checkPosition(Square square) {
        
        Square pos = this.getSquare();
        
        if (square == pos) {
            return MovementHintType.NONE;
        }
        
        if (square.getX() == pos.getX()+2 && square.getY() == pos.getY()+1) {
            return getReturnForSquare(square);
        }
        if (square.getX() == pos.getX()+2 && square.getY() == pos.getY()-1) {
            return getReturnForSquare(square);
        }
        if (square.getX() == pos.getX()-2 && square.getY() == pos.getY()+1) {
            return getReturnForSquare(square);
        }
        if (square.getX() == pos.getX()-2 && square.getY() == pos.getY()-1) {
            return getReturnForSquare(square);
        }
        
        if (square.getX() == pos.getX()+1 && square.getY() == pos.getY()+2) {
            return getReturnForSquare(square);
        }
        if (square.getX() == pos.getX()+1 && square.getY() == pos.getY()-2) {
            return getReturnForSquare(square);
        }
        if (square.getX() == pos.getX()-1 && square.getY() == pos.getY()+2) {
            return getReturnForSquare(square);
        }
        if (square.getX() == pos.getX()-1 && square.getY() == pos.getY()-2) {
            return getReturnForSquare(square);
        }
        
        return MovementHintType.NONE;
    }
}
