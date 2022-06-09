package components;

import Pieces.*;
import components.basic.Panel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import Pieces.basic.Piece;
import components.basic.Square;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import main.ImageManager;

public class GameBoard extends Panel {
    
    int size_board = 512;
    int size_square = size_board / 8;
    
    Color color_light = new Color(140, 140, 140);
    Color color_dark = new Color(50, 50, 50);
    Color color_hint_move = new Color(0, 255, 0, 120);
    Color color_hint_capture = new Color(255, 0, 0, 120);
    
    Square[][] squares = new Square[8][8];
    
    LinkedList<Piece> pieces = new LinkedList<>();
    Piece selected_piece;
    
    ImageManager images = new ImageManager();
    
    public GameBoard() {
        init();
        initBoard();
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
                    selected_piece.move(getSquareFromCursor(e.getX(), e.getY()));
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
    
    private void initBoard() {
        
        boolean is_light = true;
        
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                squares[x][y] = new Square(is_light, x, y);
                is_light = !is_light;
            }
            is_light = !is_light;
        }
        
        squares[0][0].setPiece(new Rook(false, pieces, squares[0][0]));
        squares[1][0].setPiece(new Knight(false, pieces, squares[1][0]));
        squares[2][0].setPiece(new Bishop(false, pieces, squares[2][0]));
        squares[3][0].setPiece(new Queen(false, pieces, squares[3][0]));
        squares[4][0].setPiece(new King(false, pieces, squares[4][0]));
        squares[5][0].setPiece(new Bishop(false, pieces, squares[5][0]));
        squares[6][0].setPiece(new Knight(false, pieces, squares[6][0]));
        squares[7][0].setPiece(new Rook(false, pieces, squares[7][0]));
        
        squares[0][7].setPiece(new Rook(true, pieces, squares[0][7]));
        squares[1][7].setPiece(new Knight(true, pieces, squares[1][7]));
        squares[2][7].setPiece(new Bishop(true, pieces, squares[2][7]));
        squares[3][7].setPiece(new Queen(true, pieces, squares[3][7]));
        squares[4][7].setPiece(new King(true, pieces, squares[4][7]));
        squares[5][7].setPiece(new Bishop(true, pieces, squares[5][7]));
        squares[6][7].setPiece(new Knight(true, pieces, squares[6][7]));
        squares[7][7].setPiece(new Rook(true, pieces, squares[7][7]));
        
        for (int x = 0; x < 8; x++) {
            squares[x][1].setPiece(new Pawn(false, pieces, squares[x][1]));
            squares[x][6].setPiece(new Pawn(true, pieces, squares[x][6]));
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        
        paintBoard(g2);
        paintHints(g2);
        paintPieces(g2);
        paintSelectedPiece(g2);
    }
    
    private void paintBoard(Graphics2D g2) {
        
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                
                if (squares[x][y].getIsLight()) {
                    g2.setColor(color_light);
                } else {
                    g2.setColor(color_dark);
                }
                
                g2.fillRect(squares[x][y].getX() * size_square, squares[x][y].getY() * size_square, size_square, size_square);
            }
        }
    }
    
    private void paintHints(Graphics2D g2) {
        
        if (selected_piece != null) {
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    
                    switch (selected_piece.checkPosition(squares[x][y])) {
                        case CAPTURE:
                            g2.setColor(color_hint_capture);
                            g2.fillRoundRect(squares[x][y].getX() * size_square+3, squares[x][y].getY() * size_square+3, size_square-6, size_square-6, 20, 20);
                            break;
                        case MOVE:
                            g2.setColor(color_hint_move);
                            g2.fillRoundRect(squares[x][y].getX() * size_square+3, squares[x][y].getY() * size_square+3, size_square-6, size_square-6, 20, 20);
                            break;
                    }
                }
            }
        }
    }
    
    private void paintPieces(Graphics2D g2) {
        
        for (Piece p : pieces) {
            if (!p.getIsKilled()) {
                if (p == selected_piece) {
                    g2.drawImage(   images.getImageAlpha(p.getIsWhite(), p.getName()),
                                    p.getSquare().getX() * size_square,
                                    p.getSquare().getY() * size_square,
                                    null);
                } else {
                    g2.drawImage(   images.getImage(p.getIsWhite(), p.getName()),
                                    p.getSquare().getX() * size_square,
                                    p.getSquare().getY() * size_square,
                                    null);
                }
            }
        }
    }
    
    private void paintSelectedPiece(Graphics2D g2) {
        
        if (selected_piece != null) {
            g2.drawImage(   images.getImageSelected(selected_piece.getIsWhite(), selected_piece.getName()), 
                            selected_piece.getCurrentXPosition(), 
                            selected_piece.getCurrentYPosition(), 
                            null);
        }
    }
    
    private Piece getPieceFromPosition(int x, int y) {
        
        for (Piece p : pieces) {
            if (!p.getIsKilled() && p.getSquare().getX() == x / size_square && p.getSquare().getY() == y / size_square) {
                return p;
            }
        }
        return null;
    }
    
    private Square getSquareFromCursor(int x, int y) {
        
        int pos_x = x / size_square;
        int pos_y = y / size_square;
        
        if (pos_x >= 0 && pos_x < 8 && pos_y >= 0 && pos_y < 8) {
            return squares[pos_x][pos_y];
        }
        return null;
    }
    
    private void dragPiece(int x, int y) {
        
        if (selected_piece != null) {
            selected_piece.setCurrentPosition(x, y);
        }
        
        repaint();
    }
}
