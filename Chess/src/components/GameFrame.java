package components;

import components.basic.Button;
import components.basic.Frame;
import components.basic.Panel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

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
        
        Button btn = new Button();
        btn.setText("Refresh");
        btn.addActionListener((ActionEvent e) -> {
            board.repaint();
        });
        
        panel.add(board);
        this.add(panel, BorderLayout.PAGE_START);
        this.add(btn, BorderLayout.PAGE_END);
    }
    
}
