package components;

import components.basic.Panel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import Pieces.Piece;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import main.ImageManager;

public class GameBoard extends Panel {
    
    int sizeBoard = 512;
    int sizeSquare = sizeBoard / 8;
    
    Color white = new Color(153, 153, 102);
    Color black = new Color(107, 107, 71);
    
    LinkedList<Piece> pieces = new LinkedList<>();
    Piece selectedPiece;
    
    ImageManager images = new ImageManager();
    
    public GameBoard() {
        init();
    }
    
    private void init() {
        
        this.setPreferredSize(new Dimension(sizeBoard, sizeBoard));
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectedPiece = getPieceFromPosition(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (selectedPiece != null) {
                    selectedPiece.move(e.getX()/sizeSquare, e.getY()/sizeSquare);
                    selectedPiece = null;
                    repaint();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedPiece != null) {
                    selectedPiece.x = e.getX() - sizeSquare/2;
                    selectedPiece.y = e.getY() - sizeSquare/2;
                    repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
        
        //Figuren zum Testen;
        pieces.add(new Piece(0, 0, false, "rook", pieces));
        pieces.add(new Piece(1, 0, false, "knight", pieces));
        pieces.add(new Piece(2, 0, false, "bishop", pieces));
        pieces.add(new Piece(3, 0, false, "queen", pieces));
        pieces.add(new Piece(4, 0, false, "king", pieces));
        pieces.add(new Piece(5, 0, false, "bishop", pieces));
        pieces.add(new Piece(6, 0, false, "knight", pieces));
        pieces.add(new Piece(7, 0, false, "rook", pieces));
        pieces.add(new Piece(0, 1, false, "pawn", pieces));
        pieces.add(new Piece(1, 1, false, "pawn", pieces));
        pieces.add(new Piece(2, 1, false, "pawn", pieces));
        pieces.add(new Piece(3, 1, false, "pawn", pieces));
        pieces.add(new Piece(4, 1, false, "pawn", pieces));
        pieces.add(new Piece(5, 1, false, "pawn", pieces));
        pieces.add(new Piece(6, 1, false, "pawn", pieces));
        pieces.add(new Piece(7, 1, false, "pawn", pieces));
        pieces.add(new Piece(0, 6, true, "pawn", pieces));
        pieces.add(new Piece(1, 6, true, "pawn", pieces));
        pieces.add(new Piece(2, 6, true, "pawn", pieces));
        pieces.add(new Piece(3, 6, true, "pawn", pieces));
        pieces.add(new Piece(4, 6, true, "pawn", pieces));
        pieces.add(new Piece(5, 6, true, "pawn", pieces));
        pieces.add(new Piece(6, 6, true, "pawn", pieces));
        pieces.add(new Piece(7, 6, true, "pawn", pieces));
        pieces.add(new Piece(0, 7, true, "rook", pieces));
        pieces.add(new Piece(1, 7, true, "knight", pieces));
        pieces.add(new Piece(2, 7, true, "bishop", pieces));
        pieces.add(new Piece(3, 7, true, "queen", pieces));
        pieces.add(new Piece(4, 7, true, "king", pieces));
        pieces.add(new Piece(5, 7, true, "bishop", pieces));
        pieces.add(new Piece(6, 7, true, "knight", pieces));
        pieces.add(new Piece(7, 7, true, "rook", pieces));
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        boolean color_w = true;
        
        //Spielbrett:
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                
                if (color_w) {
                    g.setColor(white);
                } else {
                    g.setColor(black);
                }
                
                g.fillRect(x*sizeSquare, y*sizeSquare, sizeSquare, sizeSquare);
                color_w = !color_w;
            }
            color_w = !color_w;
        }
        
        //Figuren:
        for (Piece p : pieces) {
            if (!p.isKilled && p != selectedPiece) {
                g.drawImage(images.getImage(p.isWhite, p.name), p.x, p.y, this);
            }
        }
        
        if (selectedPiece != null) {
            g.drawImage(images.getImageSelected(selectedPiece.isWhite, selectedPiece.name), selectedPiece.x, selectedPiece.y, this);
        }
        
    }
        
    private Piece getPieceFromPosition(int x, int y) {
        
        int pos_x = x / sizeSquare;
        int pos_y = y / sizeSquare;
        
        for (Piece p : pieces) {
            if (p.pos_x == pos_x && p.pos_y == pos_y && !p.isKilled) {
                return p;
            }
        }
        
        return null;
    }
    
}
