package components;

import Pieces.*;
import components.basic.Panel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import Pieces.basic.Piece;
import components.basic.Square;
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
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                
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
        
        //Spielbrett:
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                
                if (squares[x][y].getIsLight()) {
                    g.setColor(color_light);
                } else {
                    g.setColor(color_dark);
                }
                
                g.fillRect(squares[x][y].getX() * size_square, squares[x][y].getY() * size_square, size_square, size_square);
            }
        }
        
        //Figuren:
        for (Piece p : pieces) {
            g.drawImage(images.getImage(p.getIsWhite(), p.getName()), p.getSquare().getX() * size_square, p.getSquare().getY() * size_square, null);
        }
        
        
    }
    
}
