package components.basic;

import Pieces.basic.Piece;

public class Square {
    
    private boolean is_light;
    
    private int pos_x;
    private int pos_y;
    
    private Piece piece;
    
    public Square(boolean is_light, int pos_x, int pos_y) {
        this.is_light = is_light;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }
    
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    public boolean getIsLight() {
        return is_light;
    }
    
    public int getX() {
        return pos_x;
    }
    
    public int getY() {
        return pos_y;
    }
}
