package components;

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
    
    private void initPieces() {
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
    }
    
}
