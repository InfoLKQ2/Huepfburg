import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

/**
 * Diese Klasse beinhaltet die GUI für das Spiel Hüpfburg-2D
 *
 * @author Team Hüpfburg: Jupp Bruns, Cihan Karahan, Shium Rahman, Gideon Schafroth und Clemens Zander
 * @version 1.0
 */
public class GUI
{
    private JFrame fenster;
    /**
     * Erzeuge einen Bildbetrachter und zeige seine GUI auf
     * dem Bildschirm an.
     */
    public GUI()
    {
        fensterErzeugen();
    }
    
    /**
     * Erzeuge das Swing-Fenster samt Inhalt.
     */
    private void fensterErzeugen()
    {
        fenster = new JFrame("Hüpfburg-2D");
        contentPaneErzeugen(fenster);
        
        fenster.pack();
        fenster.setVisible(true);
    }
    
    private void contentPaneErzeugen(JFrame fenster)
    {
        Container contentPane = fenster.getContentPane();
        
    }
}
