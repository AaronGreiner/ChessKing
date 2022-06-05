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
    
    private final static FlatDarkLaf laf_dark = new FlatDarkLaf();
    private final static FlatLightLaf laf_light = new FlatLightLaf();
    
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(laf_dark);
            
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SwingUtilities.invokeLater(() -> {
            
            frame = new GameFrame();
            frame.setVisible(true);
            
        });
        
    }
    
}
