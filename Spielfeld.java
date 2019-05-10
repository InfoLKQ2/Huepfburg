import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Beschreiben Sie hier die Klasse Spielfeld.
 * 
 * @author (Projekt Hüpfburg(alle)) 
 * @version (10.5.19)
 */
public class Spielfeld
{
   private JFrame frame;
   private Canvas canvas;
   private String titel;
   private int breite;
   private int hoehe;

   public Spielfeld(String title, int width, int height)
   {
      titel = title;
      breite = width;
      hoehe = height;

      frame = new JFrame(titel);
      frame.setSize(breite, hoehe);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);

      canvas = new Canvas();
      canvas.setPreferredSize(new Dimension(breite, hoehe));
      canvas.setMaximumSize(new Dimension(breite, hoehe));
      canvas.setMinimumSize(new Dimension(breite, hoehe));
      canvas.setFocusable(false);
      frame.add(canvas);
      frame.pack();
   }

   public Canvas getCanvas()
   {
      return canvas;
   }

   public JFrame getFrame()
   {
      return frame;
   }
}

