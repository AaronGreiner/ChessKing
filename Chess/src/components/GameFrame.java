package components;

import components.basic.Frame;
import components.basic.Panel;
import java.awt.BorderLayout;

public class GameFrame extends Frame {
    
    private GameBoard board;
    
    public GameFrame() {
        init();
    }
    
    private void init() {
        
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Panel panel = new Panel();
        board = new GameBoard();
        
        panel.add(board);
        this.add(panel, BorderLayout.PAGE_START);
        
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
}
