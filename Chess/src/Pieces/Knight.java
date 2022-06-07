package Pieces;

import Pieces.basic.Piece;
import components.basic.Square;
import java.util.LinkedList;

public class Knight extends Piece {
    
    public Knight(boolean is_white, LinkedList<Piece> pieces, Square square) {
        super(is_white, "knight", pieces, square);
    }
    
    @Override
    public boolean checkPosition(Square square) {
        
        Square pos = this.getSquare();
        
        if (square == pos) {
            return false;
        }
        
        if (square.getX() == pos.getX()+2 && square.getY() == pos.getY()+1) {
            return true;
        }
        if (square.getX() == pos.getX()+2 && square.getY() == pos.getY()-1) {
            return true;
        }
        if (square.getX() == pos.getX()-2 && square.getY() == pos.getY()+1) {
            return true;
        }
        if (square.getX() == pos.getX()-2 && square.getY() == pos.getY()-1) {
            return true;
        }
        
        if (square.getX() == pos.getX()+1 && square.getY() == pos.getY()+2) {
            return true;
        }
        if (square.getX() == pos.getX()+1 && square.getY() == pos.getY()-2) {
            return true;
        }
        if (square.getX() == pos.getX()-1 && square.getY() == pos.getY()+2) {
            return true;
        }
        if (square.getX() == pos.getX()-1 && square.getY() == pos.getY()-2) {
            return true;
        }
        
        return false;
    }
}
