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
        
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        Panel panel = new Panel();
        board = new GameBoard();
        
        panel.add(board);
        this.add(panel, BorderLayout.PAGE_START);
    }
    
}
