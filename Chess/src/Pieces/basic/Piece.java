package Pieces.basic;

import components.basic.Square;
import java.util.LinkedList;

public abstract class Piece {
    
    private boolean is_white;
    private boolean is_killed;
    private String name;
    
    private int x_pos_current;
    private int y_pos_current;
    
    private LinkedList<Piece> pieces;
    private Square square;
    
    public Piece(boolean is_white, String name, LinkedList<Piece> pieces, Square square) {
        
        this.is_white = is_white;
        this.name = name;
        this.pieces = pieces;
        this.is_killed = false;
        this.square = square;
        
        this.x_pos_current = square.getX() * 64;
        this.y_pos_current = square.getY() * 64;
        
        pieces.add(this);
    }
    
    public void move(Square square) {
        
        if (square != null && this.square != square) {
            if (square.getPiece() != null) {
                if (square.getPiece().getIsWhite() != this.getIsWhite()) {
                    square.getPiece().setIsKilled(true);
                } else {
                    return;
                }
            }
            this.square.setPiece(null);
            this.square = square;
            square.setPiece(this);
        }
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
    
    public void setIsKilled(boolean is_killed) {
        this.is_killed = is_killed;
    }
    
    public boolean getIsKilled() {
        return is_killed;
    }
    
    public void setCurrentPosition(int x, int y) {
        this.x_pos_current = x - 64 / 2;
        this.y_pos_current = y - 64 / 2;
    }
    
    public int getCurrentXPosition() {
        return x_pos_current;
    }
    
    public int getCurrentYPosition() {
        return y_pos_current;
    }
}
