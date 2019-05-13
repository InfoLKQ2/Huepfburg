import java.awt.image.BufferedImage;
/**
 * Die Klasse Player beschäftigt sich mit allen Funktionen, die der Spieler durch die Spielfigur ausführen kann
 * 
 * @author ((Cihan M. Karahan, Gideon J. Schafroth, Shium M. Rahmman)) 
 * @version (13.05.2019)
 */

public class Player extends Creature {
  public static final int DEFAULT_HEALTH = 100; // Changeable to our demands
  public static final int DEFAULT_SPEED = 1;    

  public Player(int x, int y, BufferedImage image) {
    super("Player", image, x, y, Entity.DEFAULT_WIDTH, Entity.DEFAULT_HEIGHT, Player.DEFAULT_HEALTH, Player.DEFAULT_SPEED);
  }

  @Override
  public void update() {
    move();
  }
}
