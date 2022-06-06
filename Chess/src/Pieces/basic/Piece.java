package Pieces.basic;

import java.util.LinkedList;

public abstract class Piece {
    
    public boolean is_light;
    public boolean is_killed;
    public String name;
    
    LinkedList<Piece> pieces;
    Piece piece_same_position;
    
    public Piece(boolean is_light, String name, LinkedList<Piece> pieces) {
        
        this.is_light = is_light;
        this.name = name;
        this.pieces = pieces;
        
        this.is_killed = false;
    }
    
}
