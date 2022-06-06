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
    
    int size_board = 512;
    int size_square = size_board / 8;
    
    Color color_light = new Color(140, 140, 140);
    Color color_dark = new Color(50, 50, 50);
    Color color_highlight_positive = new Color(0, 255, 0, 120);
    Color color_highlight_negative = new Color(255, 0, 0, 120);
    
    LinkedList<Piece> pieces = new LinkedList<>();
    Piece selected_piece;
    
    ImageManager images = new ImageManager();
    
    public GameBoard() {
        init();
        initPieces();
    }
    
    private void init() {
        
        this.setPreferredSize(new Dimension(size_board, size_board));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selected_piece = getPieceFromPosition(e.getX(), e.getY());
                dragPiece(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (selected_piece != null) {
                    selected_piece.move(e.getX()/size_square, e.getY()/size_square);
                    selected_piece = null;
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
        if (selected_piece != null) {
            selected_piece.x = x - size_square / 2;
            selected_piece.y = y - size_square / 2;
            this.repaint();
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        boolean color_light_dark = true;
        
        //Spielbrett:
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                
                if (color_light_dark) {
                    g.setColor(color_light);
                } else {
                    g.setColor(color_dark);
                }
                
                g.fillRect(x*size_square, y*size_square, size_square, size_square);
                color_light_dark = !color_light_dark;
                
                //Highlight Test:
                if (y == 2) {
                    g.setColor(color_highlight_positive);
                    g.fillRect(x*size_square, y*size_square, size_square, size_square);
                }
                
                //Highlight Test:
                if (y == 4) {
                    g.setColor(color_highlight_negative);
                    g.fillRect(x*size_square, y*size_square, size_square, size_square);
                }
            }
            color_light_dark = !color_light_dark;
        }
        
        //Figuren:
        for (Piece p : pieces) {
            if (!p.is_killed && p != selected_piece) {
                g.drawImage(images.getImage(p.is_light, p.name), p.x, p.y, this);
            }
        }
        
        if (selected_piece != null) {
            g.drawImage(images.getImageSelected(selected_piece.is_light, selected_piece.name), selected_piece.x, selected_piece.y, this);
        }
        
    }
        
    private Piece getPieceFromPosition(int x, int y) {
        
        int pos_x = x / size_square;
        int pos_y = y / size_square;
        
        for (Piece p : pieces) {
            if (p.pos_x == pos_x && p.pos_y == pos_y && !p.is_killed) {
                return p;
            }
        }
        
        return null;
    }
    
}
