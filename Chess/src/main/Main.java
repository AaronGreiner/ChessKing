package main;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import components.GameFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    
    public static GameFrame frame;
    
    private final static FlatDarkLaf lafDark = new FlatDarkLaf();
    private final static FlatLightLaf lafLight = new FlatLightLaf();
    
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(lafDark);
            
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SwingUtilities.invokeLater(() -> {
            
            frame = new GameFrame();
            frame.setVisible(true);
            
        });
        
    }
    
}
