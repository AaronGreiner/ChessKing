package Pieces;

import Pieces.basic.Piece;
import components.basic.Square;
import java.util.LinkedList;

public class Bishop extends Piece {
    
    public Bishop(boolean is_white, LinkedList<Piece> pieces, Square square) {
        super(is_white, "bishop", pieces, square);
    }
    
    @Override
    public boolean checkPosition(Square square) {
        
        Square pos = this.getSquare();
        
        if (square == pos) {
            return false;
        }
        
        for (int i = 1; i <= 8; i++) {
            if (pos.getX()+i == square.getX() && pos.getY()+i == square.getY()) {
                return true;
            }
            if (pos.getX()-i == square.getX() && pos.getY()-i == square.getY()) {
                return true;
            }
            if (pos.getX()-i == square.getX() && pos.getY()+i == square.getY()) {
                return true;
            }
            if (pos.getX()+i == square.getX() && pos.getY()-i == square.getY()) {
                return true;
            }
        }
        
        return false;
    }
}
