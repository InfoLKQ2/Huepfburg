import java.awt.image.BufferedImage;
/**
 * Beschreiben Sie hier die Klasse Player.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
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
