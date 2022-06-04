package main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImageManager {
    
    private BufferedImage b_bishop;
    private BufferedImage b_king;
    private BufferedImage b_knight;
    private BufferedImage b_pawn;
    private BufferedImage b_queen;
    private BufferedImage b_rook;
    private BufferedImage w_bishop;
    private BufferedImage w_king;
    private BufferedImage w_knight;
    private BufferedImage w_pawn;
    private BufferedImage w_queen;
    private BufferedImage w_rook;
    
    public ImageManager() {
        
        try {
            
            b_bishop = ImageIO.read(new File("src\\ressources\\without_shadow\\b_bishop.png"));
            b_king = ImageIO.read(new File("src\\ressources\\without_shadow\\b_king.png"));
            b_knight = ImageIO.read(new File("src\\ressources\\without_shadow\\b_knight.png"));
            b_pawn = ImageIO.read(new File("src\\ressources\\without_shadow\\b_pawn.png"));
            b_queen = ImageIO.read(new File("src\\ressources\\without_shadow\\b_queen.png"));
            b_rook = ImageIO.read(new File("src\\ressources\\without_shadow\\b_rook.png"));
            w_bishop = ImageIO.read(new File("src\\ressources\\without_shadow\\w_bishop.png"));
            w_king = ImageIO.read(new File("src\\ressources\\without_shadow\\w_king.png"));
            w_knight = ImageIO.read(new File("src\\ressources\\without_shadow\\w_knight.png"));
            w_pawn = ImageIO.read(new File("src\\ressources\\without_shadow\\w_pawn.png"));
            w_queen = ImageIO.read(new File("src\\ressources\\without_shadow\\w_queen.png"));
            w_rook = ImageIO.read(new File("src\\ressources\\without_shadow\\w_rook.png"));
            
            
        } catch (IOException ex) {
            Logger.getLogger(ImageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BufferedImage getImage(boolean isWhite, String name) {
        switch (name) {
            case "bishop":
                if (isWhite) {
                    return w_bishop;
                } else {
                    return b_bishop;
                }
            case "king":
                if (isWhite) {
                    return w_king;
                } else {
                    return b_king;
                }
            case "knight":
                if (isWhite) {
                    return w_knight;
                } else {
                    return b_knight;
                }
            case "pawn":
                if (isWhite) {
                    return w_pawn;
                } else {
                    return b_pawn;
                }
            case "queen":
                if (isWhite) {
                    return w_queen;
                } else {
                    return b_queen;
                }
            case "rook":
                if (isWhite) {
                    return w_rook;
                } else {
                    return b_rook;
                }
            default:
                return null;
        }
    }
    
}
