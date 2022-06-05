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
    Piece pieceSamePosition;
    
    public Piece(int pos_x, int pos_y, boolean isWhite, String name, LinkedList<Piece> pieces) {
        
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.x = pos_x*64;
        this.y = pos_y*64;
        this.isWhite = isWhite;
        this.name = name;
        this.pieces = pieces;
        
        this.isKilled = false;
    }
    
    public void move(int pos_x, int pos_y) {
        
        switch (checkPosition(pos_x, pos_y)) {
            case 0: //Außerhalb des Spielfeldes
                resetPosition();
                break;
            case 1: //Feld besetzt von eigener Farbe
                resetPosition();
                break;
            case 2: //Feld besetzt von anderer Farbe
                pieceSamePosition.kill();
                updatePosition(pos_x, pos_y);
                break;
            default: //Position aktualisieren
                updatePosition(pos_x, pos_y);
        }
    }
    
    private int checkPosition(int pos_x, int pos_y) {
        
        //Prüfen ob Zug im Spielfeld
        if (pos_x > 7 || pos_x < 0 || pos_y > 7 || pos_y < 0 ) {
            return 0;
        }
        
        //Prüfen ob von anderer Figur besetztes Feld
        for (Piece p : pieces) {
            if (p.pos_x == pos_x && p.pos_y == pos_y && !p.isKilled) {
                pieceSamePosition = p;
                if (p.isWhite == this.isWhite) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        
        return -1;
    }
    
    private void resetPosition() {
        this.x = this.pos_x*64;
        this.y = this.pos_y*64;
    }
    
    private void updatePosition(int pos_x, int pos_y) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.x = pos_x*64;
        this.y = pos_y*64;
    }
    
    private void kill() {
        isKilled = true;
    }
}
