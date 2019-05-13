import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Die Klasse Spielfeld erstellt das Fenster, in welchem das Spiel angezeigt wird
 * Author(Cihan Karahan, Shium Rahman, Gideon Schafroth)
 * Version(10.5.19)
 */
public class Spielfeld
{
   private JFrame frame;
   private Canvas canvas;
   private String titel;
   private int breite;
   private int hoehe;
   
   /**
    * Konstruktor der Klasse Spielfeld
    * @param title Titel der über dem Fenster angezeigt wird
    * @param width die Breite des Fensters
    * @param height die Höhe des Fensters
    */
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

      canvas = new Canvas();//Das ganze Fenster ist ein Canvas, also eine Zeichenfläche um Grafiken dort anzeigen zu können
      canvas.setPreferredSize(new Dimension(breite, hoehe));
      canvas.setMaximumSize(new Dimension(breite, hoehe));
      canvas.setMinimumSize(new Dimension(breite, hoehe));
      canvas.setFocusable(false);
      frame.add(canvas);
      frame.pack();
   }

   /**
    * gibt Canvas zurück
    */
   public Canvas getCanvas()
   {
      return canvas;
   }

   /**
    * gibt das JFrame zurück
    */
   public JFrame getFrame()
   {
      return frame;
   }
}

