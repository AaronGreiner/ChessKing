package Pieces;

import Pieces.basic.Piece;
import components.basic.Square;
import java.util.LinkedList;

public class King extends Piece {
    
    public King(boolean is_white, LinkedList<Piece> pieces, Square square) {
        super(is_white, "king", pieces, square);
    }
    
    @Override
    public boolean checkPosition(Square square) {
        
        Square pos = this.getSquare();
        
        if (square == pos) {
            return false;
        }
        
        if (square.getX() == pos.getX() + 1 && square.getY() == pos.getY()) {
            return true;
        }
        if (square.getX() == pos.getX() - 1 && square.getY() == pos.getY()) {
            return true;
        }
        if (square.getX() == pos.getX() && square.getY() == pos.getY() + 1) {
            return true;
        }
        if (square.getX() == pos.getX() && square.getY() == pos.getY() - 1) {
            return true;
        }
        
        if (pos.getX() + 1 == square.getX() && pos.getY() + 1 == square.getY()) {
            return true;
        }
        if (pos.getX() - 1 == square.getX() && pos.getY() - 1 == square.getY()) {
            return true;
        }
        if (pos.getX() - 1 == square.getX() && pos.getY() + 1 == square.getY()) {
            return true;
        }
        if (pos.getX() + 1 == square.getX() && pos.getY() - 1 == square.getY()) {
            return true;
        }
        
        return false;
    }
}
