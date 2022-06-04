package Pieces;

import java.util.LinkedList;

public class Piece {
    
    public int pos_x;
    public int pos_y;
    public int x;
    public int y;
    public boolean isWhite;
    public boolean isKilled;
    public String name;
    LinkedList<Piece> pieces;
    
    public Piece(int pos_x, int pos_y, boolean isWhite, String name, LinkedList<Piece> pieces) {
        
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.x = pos_x*64;
        this.y = pos_y*64;
        this.isWhite = isWhite;
        this.name = name; //Gleichzeitig aktuell auch das Bild (ohne w_ / b_ und .png)
        this.pieces = pieces;
        
        this.isKilled = false;
        
        pieces.add(this);
    }
    
    public void move(int pos_x, int pos_y) {
        
        //Prüfen, dass an der Position noch nichts anderes steht, sonst killen
        for (Piece p : pieces) {
            if (p.pos_x == pos_x && p.pos_y == pos_y) {
                p.kill();
            }
        }
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.x = pos_x*64;
        this.y = pos_y*64;
        
    }
    
    public void kill() {
//        pieces.remove(this);
        isKilled = true;
    }
}
