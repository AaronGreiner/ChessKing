package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageManager extends JFrame {
    
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
    
    private BufferedImage b_bishop_selected;
    private BufferedImage b_king_selected;
    private BufferedImage b_knight_selected;
    private BufferedImage b_pawn_selected;
    private BufferedImage b_queen_selected;
    private BufferedImage b_rook_selected;
    private BufferedImage w_bishop_selected;
    private BufferedImage w_king_selected;
    private BufferedImage w_knight_selected;
    private BufferedImage w_pawn_selected;
    private BufferedImage w_queen_selected;
    private BufferedImage w_rook_selected;
    
    private BufferedImage b_bishop_alpha;
    private BufferedImage b_king_alpha;
    private BufferedImage b_knight_alpha;
    private BufferedImage b_pawn_alpha;
    private BufferedImage b_queen_alpha;
    private BufferedImage b_rook_alpha;
    private BufferedImage w_bishop_alpha;
    private BufferedImage w_king_alpha;
    private BufferedImage w_knight_alpha;
    private BufferedImage w_pawn_alpha;
    private BufferedImage w_queen_alpha;
    private BufferedImage w_rook_alpha;
    
    public ImageManager() {
        
        try {
            
            b_bishop = ImageIO.read(getClass().getResource("/ressources/without_shadow/b_bishop.png"));
            b_king = ImageIO.read(getClass().getResource("/ressources/without_shadow/b_king.png"));
            b_knight = ImageIO.read(getClass().getResource("/ressources/without_shadow/b_knight.png"));
            b_pawn = ImageIO.read(getClass().getResource("/ressources/without_shadow/b_pawn.png"));
            b_queen = ImageIO.read(getClass().getResource("/ressources/without_shadow/b_queen.png"));
            b_rook = ImageIO.read(getClass().getResource("/ressources/without_shadow/b_rook.png"));
            w_bishop = ImageIO.read(getClass().getResource("/ressources/without_shadow/w_bishop.png"));
            w_king = ImageIO.read(getClass().getResource("/ressources/without_shadow/w_king.png"));
            w_knight = ImageIO.read(getClass().getResource("/ressources/without_shadow/w_knight.png"));
            w_pawn = ImageIO.read(getClass().getResource("/ressources/without_shadow/w_pawn.png"));
            w_queen = ImageIO.read(getClass().getResource("/ressources/without_shadow/w_queen.png"));
            w_rook = ImageIO.read(getClass().getResource("/ressources/without_shadow/w_rook.png"));
            
            b_bishop_selected = ImageIO.read(getClass().getResource("/ressources/with_shadow/b_bishop.png"));
            b_king_selected = ImageIO.read(getClass().getResource("/ressources/with_shadow/b_king.png"));
            b_knight_selected = ImageIO.read(getClass().getResource("/ressources/with_shadow/b_knight.png"));
            b_pawn_selected = ImageIO.read(getClass().getResource("/ressources/with_shadow/b_pawn.png"));
            b_queen_selected = ImageIO.read(getClass().getResource("/ressources/with_shadow/b_queen.png"));
            b_rook_selected = ImageIO.read(getClass().getResource("/ressources/with_shadow/b_rook.png"));
            w_bishop_selected = ImageIO.read(getClass().getResource("/ressources/with_shadow/w_bishop.png"));
            w_king_selected = ImageIO.read(getClass().getResource("/ressources/with_shadow/w_king.png"));
            w_knight_selected = ImageIO.read(getClass().getResource("/ressources/with_shadow/w_knight.png"));
            w_pawn_selected = ImageIO.read(getClass().getResource("/ressources/with_shadow/w_pawn.png"));
            w_queen_selected = ImageIO.read(getClass().getResource("/ressources/with_shadow/w_queen.png"));
            w_rook_selected = ImageIO.read(getClass().getResource("/ressources/with_shadow/w_rook.png"));
            
            b_bishop_alpha = ImageIO.read(getClass().getResource("/ressources/alpha/b_bishop.png"));
            b_king_alpha = ImageIO.read(getClass().getResource("/ressources/alpha/b_king.png"));
            b_knight_alpha = ImageIO.read(getClass().getResource("/ressources/alpha/b_knight.png"));
            b_pawn_alpha = ImageIO.read(getClass().getResource("/ressources/alpha/b_pawn.png"));
            b_queen_alpha = ImageIO.read(getClass().getResource("/ressources/alpha/b_queen.png"));
            b_rook_alpha = ImageIO.read(getClass().getResource("/ressources/alpha/b_rook.png"));
            w_bishop_alpha = ImageIO.read(getClass().getResource("/ressources/alpha/w_bishop.png"));
            w_king_alpha = ImageIO.read(getClass().getResource("/ressources/alpha/w_king.png"));
            w_knight_alpha = ImageIO.read(getClass().getResource("/ressources/alpha/w_knight.png"));
            w_pawn_alpha = ImageIO.read(getClass().getResource("/ressources/alpha/w_pawn.png"));
            w_queen_alpha = ImageIO.read(getClass().getResource("/ressources/alpha/w_queen.png"));
            w_rook_alpha = ImageIO.read(getClass().getResource("/ressources/alpha/w_rook.png"));
            
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
    
    public BufferedImage getImageSelected(boolean isWhite, String name) {
        switch (name) {
            case "bishop":
                if (isWhite) {
                    return w_bishop_selected;
                } else {
                    return b_bishop_selected;
                }
            case "king":
                if (isWhite) {
                    return w_king_selected;
                } else {
                    return b_king_selected;
                }
            case "knight":
                if (isWhite) {
                    return w_knight_selected;
                } else {
                    return b_knight_selected;
                }
            case "pawn":
                if (isWhite) {
                    return w_pawn_selected;
                } else {
                    return b_pawn_selected;
                }
            case "queen":
                if (isWhite) {
                    return w_queen_selected;
                } else {
                    return b_queen_selected;
                }
            case "rook":
                if (isWhite) {
                    return w_rook_selected;
                } else {
                    return b_rook_selected;
                }
            default:
                return null;
        }
    }
    
    public BufferedImage getImageAlpha(boolean isWhite, String name) {
        switch (name) {
            case "bishop":
                if (isWhite) {
                    return w_bishop_alpha;
                } else {
                    return b_bishop_alpha;
                }
            case "king":
                if (isWhite) {
                    return w_king_alpha;
                } else {
                    return b_king_alpha;
                }
            case "knight":
                if (isWhite) {
                    return w_knight_alpha;
                } else {
                    return b_knight_alpha;
                }
            case "pawn":
                if (isWhite) {
                    return w_pawn_alpha;
                } else {
                    return b_pawn_alpha;
                }
            case "queen":
                if (isWhite) {
                    return w_queen_alpha;
                } else {
                    return b_queen_alpha;
                }
            case "rook":
                if (isWhite) {
                    return w_rook_alpha;
                } else {
                    return b_rook_alpha;
                }
            default:
                return null;
        }
    }
    
}
