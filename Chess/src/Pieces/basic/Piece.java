package Pieces.basic;

import components.basic.Square;
import java.util.LinkedList;

public abstract class Piece {
    
    private boolean is_white;
    private boolean is_killed;
    private String name;
    
    private LinkedList<Piece> pieces;
    private Square square;
    
    public Piece(boolean is_white, String name, LinkedList<Piece> pieces, Square square) {
        
        this.is_white = is_white;
        this.name = name;
        this.pieces = pieces;
        this.is_killed = false;
        this.square = square;
        
        pieces.add(this);
    }
    
    public Square getSquare() {
        return square;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean getIsWhite() {
        return is_white;
    }
}
