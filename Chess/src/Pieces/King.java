package Pieces;

import Pieces.basic.Piece;
import java.util.LinkedList;

public class King extends Piece {
    
    public King(int pos_x, int pos_y, boolean isWhite, LinkedList<Piece> pieces) {
        super(pos_x, pos_y, isWhite, "king", pieces);
    }
}
