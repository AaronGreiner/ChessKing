package components;

import Pieces.*;
import components.basic.Panel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import Pieces.basic.Piece;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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
        initPieces();
    }
    
    private void init() {
        
        this.setPreferredSize(new Dimension(sizeBoard, sizeBoard));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedPiece = getPieceFromPosition(e.getX(), e.getY());
                dragPiece(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (selectedPiece != null) {
                    selectedPiece.move(e.getX()/sizeSquare, e.getY()/sizeSquare);
                    selectedPiece = null;
                    repaint();
                }
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                dragPiece(e.getX(), e.getY());
            }
        });
        
    }
    
    private void initPieces() {
        
        pieces.add(new Rook(0, 0, false, pieces));
        pieces.add(new Rook(0, 7, true, pieces));
        
        pieces.add(new Knight(1, 0, false, pieces));
        pieces.add(new Knight(1, 7, true, pieces));
        
        pieces.add(new Bishop(2, 0, false, pieces));
        pieces.add(new Bishop(2, 7, true, pieces));
        
        pieces.add(new Queen(3, 0, false, pieces));
        pieces.add(new Queen(3, 7, true, pieces));
        
        pieces.add(new King(4, 0, false, pieces));
        pieces.add(new King(4, 7, true, pieces));
        
        pieces.add(new Bishop(5, 0, false, pieces));
        pieces.add(new Bishop(5, 7, true, pieces));
        
        pieces.add(new Knight(6, 0, false, pieces));
        pieces.add(new Knight(6, 7, true, pieces));
        
        pieces.add(new Rook(7, 0, false, pieces));
        pieces.add(new Rook(7, 7, true, pieces));
        
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(i, 1, false, pieces));
            pieces.add(new Pawn(i, 6, true, pieces));
        }
        
    }
    
    private void dragPiece(int x, int y) {
        if (selectedPiece != null) {
            selectedPiece.x = x - sizeSquare / 2;
            selectedPiece.y = y - sizeSquare / 2;
            this.repaint();
        }
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
